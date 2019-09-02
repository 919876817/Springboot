package com.yuanian.personnel.mapper;

import com.yuanian.personnel.pojo.Department;
import com.yuanian.personnel.pojo.User;
import com.yuanian.personnel.pojo.Username;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String usercode);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String usercode);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();
    int insertUsername(Username record);
    int insertDepartment(Department record);
     User selectByUsercode(String usercode);




}