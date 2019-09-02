package com.yuanian.personnel.service;


import com.yuanian.personnel.pojo.Department;
import com.yuanian.personnel.pojo.User;
import com.yuanian.personnel.pojo.Username;

import java.util.List;

public interface UserService {
    //添加用户
    void addUser(User users);
    //根据id删除用户
    void deleteUser( String usercode);
    //根据id更新用户
    void updateUser( User user);
    //根据id查询用户
    User  selectUser(String usercode);
    //查询所有用户
    List<User> selectUserAll();

    void insertUsername(Username record);
    void insertDepartment(Department record);
    User selectByUsercode(String usercode);



}
