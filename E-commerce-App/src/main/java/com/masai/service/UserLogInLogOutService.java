package com.masai.service;

import com.masai.exception.UserException;
import com.masai.model.UserSignInDTO;

public interface UserLogInLogOutService {
    public String logInUser(UserSignInDTO userSignInDTO) throws UserException;
    public String logOutUser(String key) throws UserException;
}
