package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.enums.Category;
import com.masai.enums.OrderStatus;
import com.masai.exception.AdminException;
import com.masai.exception.OrderException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Admin;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.model.User;

public interface AdminServices {
	
    public Admin regAdmin(Admin admin)throws AdminException;
    
    public Admin getAdminByID(Integer aid) throws AdminException;
    
    public Admin updateAdmin(Admin admin,String key) throws AdminException;
    
    public Product addProduct(Product product) throws ProductException;

    public List<Product> getAllProduct() throws ProductException;
    
    public Product getProductByID(Integer productID) throws ProductException;
    
    public Product deleteProductByID(Integer productID) throws ProductException;
    
    public Product updateQuantityByID(Integer productID, Integer quantity) throws ProductException;
    
    public List<Orders> getAllOrders() throws OrderException;
    
    public Orders gerOrderById(Integer orderId) throws OrderException;
    
    public Orders updateOrderStatus(Integer orderId, OrderStatus status) throws OrderException;
    
    public User userFindById(Integer userId) throws UserException;
    
    public User userFindByEmail(String email) throws UserException;
    
    public List<User> userFindByName(String name) throws UserException;
    
    public User userFindByMob(String mob) throws UserException;
    
    public List<Orders> cancelOrRefunedOrders() throws OrderException;
    
    public List<Product> salesMadeToday() throws OrderException;
    
    public List<Product> salesMadeLastWeek() throws OrderException;
    
    public List<Product> salesMadeLastMonth() throws OrderException;
    
    public List<Product> salesMadeJantoDec() throws OrderException;
    
    public Product highestSoldProductByRating(LocalDate date1, LocalDate date2) throws ProductException;
    
    public Product highestRatedProductByDuration(LocalDate date1, LocalDate date2) throws ProductException;
    
    public Product highestSoldProductBySalePrice(Integer price1, Integer price2) throws ProductException;
    
    public Product highestSoldProductByCategory(Category category) throws ProductException;
    
    
}
