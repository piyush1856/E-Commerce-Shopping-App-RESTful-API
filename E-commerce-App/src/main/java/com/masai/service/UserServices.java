package com.masai.service;




import java.util.List;

import com.masai.enums.Category;
import com.masai.exception.CartException;
import com.masai.exception.OrderException;
import com.masai.exception.ProductException;
import com.masai.exception.UserException;
import com.masai.model.Cart;
import com.masai.model.CartDTO;
import com.masai.model.OrderDTO;
import com.masai.model.Orders;
import com.masai.model.Product;
import com.masai.model.User;

public interface UserServices {
	
	
    public User regUser(User user)throws UserException;
    
    public User updateUser(User user,String key) throws UserException;
    
    public List<Product> veiwAllProducts() throws ProductException;
    
    public List<Product> veiwProductByCategory(Category category) throws ProductException;
    
    public List<Product> sortedByPrice() throws ProductException;
    
    public List<Product> filterByPrice(Integer price) throws ProductException;

    public Cart addProductToCart(Integer userId, Integer productId) throws CartException, UserException, ProductException;

    public Cart removeProductFromCart(Integer userId, Integer productId) throws CartException, UserException, ProductException;

    public Cart removeAllProduct(Integer userId) throws CartException, UserException;
    
    public Cart increaseProductQuantity(Integer userId, Integer productId) throws CartException, UserException, ProductException;
    
    public Cart decreaseProductQuantity(Integer userId, Integer productId) throws CartException, UserException, ProductException;
    
    public Orders addASingleOrder(Integer userid, Integer productid, Orders order) throws OrderException, UserException, CartException;
    
    public Orders addAllOrder(Integer userid, Orders order) throws OrderException, UserException, CartException;

    public Orders viewOrder(Integer orderId) throws OrderException;
    
    public OrderDTO checkStatus(Integer orderId) throws OrderException;
    
    public CartDTO viewCart(Integer userId) throws CartException, UserException;

    public List<Orders> viewAllOrder() throws OrderException;

    public List<Orders> viewAllOrdersByUserId(Integer userId) throws OrderException;
    
    public Orders cancelOrderByOrderId(Integer orderID) throws OrderException;

}
