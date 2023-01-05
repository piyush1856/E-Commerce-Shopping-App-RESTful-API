package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.AdminSignInDTO;
import com.masai.model.CurrentAdminSession;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginLogOutServiceImpl implements AdminLoginLogOutService{
	

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDao adminSessionDao;

    @Override
    public String logInAdmin(AdminSignInDTO adminSignInDTO) throws AdminException {

        Admin existingAdmin = adminDao.findByMobileNumber(adminSignInDTO.getMobile());
        if(existingAdmin == null){
            throw new AdminException("Please enter valid email or password");
        }

        Optional<CurrentAdminSession> validAdminSessionOpt = adminSessionDao.findById(existingAdmin.getAdminID());
        if(validAdminSessionOpt.isPresent()){
            throw new AdminException("User already logged in with this mobile number");
        }

        if(existingAdmin.getPassword().equals(adminSignInDTO.getPassword())) {
            String key = RandomString.make(6);
            CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminID(), key, LocalDateTime.now());
            adminSessionDao.save(currentAdminSession);
            return "Kindly note this UUID for future reference : " + currentAdminSession.getUuid();
        }
        throw new AdminException("Kindly enter valid password");
    }

    @Override
    public String logOutAdmin(String key) throws AdminException {
        CurrentAdminSession currentAdminSession = adminSessionDao.findByUuid(key);
        if(currentAdminSession == null){
            throw new AdminException("User not logged In with this mobile number yet");
        }

        adminSessionDao.delete(currentAdminSession);
        return "Logged Out !";
    }

}
