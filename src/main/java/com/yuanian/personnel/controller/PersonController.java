package com.yuanian.personnel.controller;

import com.yuanian.personnel.pojo.User;
import com.yuanian.personnel.service.UserService;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class PersonController {
    @Autowired
    private UserService userService;
    /**
     * 页面跳转
     */
//        @RequestMapping("/{page}")
//        public String showPage(@PathVariable String page) {
//            return page;
//        }
    //查询所有User
//        @RequestMapping("/findUserAll")
    @RequestMapping("/findUserAll")
    public  @ResponseBody List<User> findUserAll(HttpServletRequest request) throws IOException {
            return this.userService.selectUserAll();

    }
    //根据id查询User
    @RequestMapping("/findUserById")
    public @ResponseBody User getUserByName(HttpServletRequest request) throws IOException {
        StringBuffer str = new StringBuffer();
        try {
            BufferedInputStream in = new BufferedInputStream(request.getInputStream());
            int i;
            char c;
            while ((i=in.read())!=-1) {
                c=(char)i;
                str.append(c);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        JSONObject obj= JSONObject.fromObject(str.toString());
        System.out.println(obj.get("name"));
        User user= userService.selectUser(obj.get("name").toString());
        return user;
    }
 //添加用户
    public void  addUser(User user){
        this.userService.addUser(user);
    }

}
