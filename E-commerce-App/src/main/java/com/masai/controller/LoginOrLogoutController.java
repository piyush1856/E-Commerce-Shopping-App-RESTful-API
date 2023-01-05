package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.exception.UserException;
import com.masai.model.AdminSignInDTO;
import com.masai.model.UserSignInDTO;
import com.masai.service.AdminLoginLogOutService;
import com.masai.service.AdminServices;
import com.masai.service.UserLogInLogOutService;

@RestController
@RequestMapping("/login")
public class LoginOrLogoutController {

    @Autowired
    private AdminLoginLogOutService adminLoginService;

    @Autowired
    private AdminServices adminServices;

    @Autowired
    private UserLogInLogOutService userLogInLogOutService;


    @PostMapping("/adminLogin")
    public ResponseEntity<String> logInAdminHandler(@RequestBody AdminSignInDTO adminSignInDTO) throws AdminException{
        String result = adminLoginService.logInAdmin(adminSignInDTO);
        if(result != null){
            AdminController.isLogin = true;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/adminLogOut")
    public String logOutAdminHandler(@RequestParam(required = true) String key) throws AdminException{
        String result = adminLoginService.logOutAdmin(key);
        if(result != null){
            AdminController.isLogin = false;
        }
        return result;
    }

    // User Login Logout Controller
    @PostMapping("/userLogin")
    public ResponseEntity<String> logInUserHandler(@RequestBody UserSignInDTO userSignInDTO) throws UserException {
        String result = userLogInLogOutService.logInUser(userSignInDTO);
        if(result != null){
            UserController.isLogin = true;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("/userLoggedOut")
    public String logOutUserHandler(@RequestParam(required = true) String key)throws UserException{
        String result = userLogInLogOutService.logOutUser(key);
        if(result != null){
            UserController.isLogin = false;
        }
        return result;
    }
}
