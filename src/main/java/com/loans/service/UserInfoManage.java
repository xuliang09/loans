package com.loans.service;

import java.util.List;

import com.loans.domain.User;

public interface UserInfoManage
{
    int addUser(User user);
    
    List<User> findByName(String name);
    
    List<User> findByPhoneNumber(String phoneNumber);
}
