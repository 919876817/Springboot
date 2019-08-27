package com.yuanian.personnel.controller;

import java.io.IOException;

import com.yuanian.personnel.pojo.User;
import net.sf.json.JSONObject;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ClientController {
    @RequestMapping("/client")
    @ResponseBody
    public Map<String, String> HttpPostData(String usercode) throws IOException {
//        try {
            HttpClient httpclient = new DefaultHttpClient();
            String uri = "http://localhost:8080/user/findUserById";
            HttpPost httppost = new HttpPost(uri);
            //添加http头信息
            httppost.addHeader("Authorization", "your token"); //认证token
            httppost.addHeader("Content-Type", "application/json");
            httppost.addHeader("User-Agent", "imgfornote");
            JSONObject obj = new JSONObject();
            obj.put("name", usercode);
            httppost.setEntity(new StringEntity(obj.toString()));
            HttpResponse response;
            response = httpclient.execute(httppost);
            //检验状态码，如果成功接收数据
            int code = response.getStatusLine().getStatusCode();
            System.out.println(code+"code");
//            if (code == 200) {
                String rev = EntityUtils.toString(response.getEntity());//返回json格式： {"id": "","name": ""}
                obj= JSONObject.fromObject(rev);

                User user = (User)JSONObject.toBean(obj,User.class);
                Map<String,String> map=new HashMap<>();
                map.put("usercode",user.getUsercode());
                map.put("username",user.getUsername());
                map.put("department",user.getDepartment());

                System.out.println("返回数据==="+user.getDepartment());
                return map;
//                List<User> us = new ArrayList<>();
//                us.add(user);
//                model.addAttribute("client",us);
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            return "client";
//        }

    }

}
