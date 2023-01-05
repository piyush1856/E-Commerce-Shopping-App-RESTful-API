package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Admin;
import com.masai.model.Orders;
import com.masai.model.User;

@Repository
public interface UserDao extends JpaRepository<Admin, Integer>{
	
    @Query("select c.orders from User c where c.userID=?1")
    public List<Orders> getAllOrderByCid(Integer userID);
    
    public User findByMob(String mobile);

}
