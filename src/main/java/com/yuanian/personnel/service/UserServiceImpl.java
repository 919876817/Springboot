package com.yuanian.personnel.service;

import com.yuanian.personnel.mapper.UserMapper;
import com.yuanian.personnel.pojo.Department;
import com.yuanian.personnel.pojo.User;
import com.yuanian.personnel.pojo.Username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User users) {
       this.userMapper.insert(users);
    }

    @Override
    public void deleteUser(String usercode) {
        this.userMapper.deleteByPrimaryKey(usercode);

    }

    @Override
    public void updateUser(User user) {
        this.userMapper.updateByPrimaryKey(user);

    }

    @Override
    public User selectUser(String usercode) {

        return  this.userMapper.selectByPrimaryKey(usercode);
    }

    @Override
    public List<User> selectUserAll() {
        return this.userMapper.selectAll();
    }

    @Override
    public void insertUsername(Username username) {
        this.userMapper.insertUsername(username);
    }

    @Override
    public void insertDepartment(Department department) {
       this.userMapper.insertDepartment(department);
    }

    @Override
    public User selectByUsercode(String usercode) {
        return this.userMapper.selectByUsercode(usercode);
    }


}
