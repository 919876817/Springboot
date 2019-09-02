package com.yuanian.personnel.quartz;

import com.alibaba.fastjson.JSON;
import com.yuanian.personnel.controller.PersonController;
import com.yuanian.personnel.pojo.Department;
import com.yuanian.personnel.pojo.User;
import com.yuanian.personnel.pojo.Username;
import com.yuanian.personnel.service.UserService;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * Job类
 */
public class QuartzDemo implements Job {
    @Autowired
    private PersonController personController;
    @Autowired
    private UserService userService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            String uri = "http://localhost:8080/user/findUserAll";
            HttpPost httppost = new HttpPost(uri);
            //添加http头信息
            httppost.addHeader("Authorization", "your token"); //认证token
            httppost.addHeader("Content-Type", "application/json");
            httppost.addHeader("User-Agent", "imgfornote");
            JSONObject obj = new JSONObject();
//            obj.put("name", usercode);
//            httppost.setEntity(new StringEntity(obj.toString()));
            HttpResponse response;
            response = httpclient.execute(httppost);
            //检验状态码，如果成功接收数据
            int code = response.getStatusLine().getStatusCode();
            System.out.println(code+"code");
            if (code == 200) {
            String rev = EntityUtils.toString(response.getEntity());//返回json格式： {"id": "","name": ""}

              System.out.println(rev);
                List<User> list = JSON.parseArray(rev, User.class);
//                System.out.println(list.get(0).getDepartment());
                for (User user:list) {
                    User userdome = this.userService.selectByUsercode(user.getUsercode());
                    if (userdome == null) {
                        Department department = new Department();
                        department.setUsercode(user.getUsercode());
                        department.setDepartment(user.getDepartment());
                        this.userService.insertDepartment(department);
                        Username username = new Username();
                        username.setUsercode(user.getUsercode());
                        username.setUsername(user.getUsername());
                        this.userService.insertUsername(username);
                    }
                }

                }
//            obj= JSONObject.fromObject(rev);
//                List<User> list = JSONArray.toList(JSONArray.fromObject(obj, User.class);
//            User user = (User)JSONObject.toBean(obj,User.class);
//            Map<String,String> map=new HashMap<>();
//            map.put("usercode",user.getUsercode());
//            map.put("username",user.getUsername());
//            map.put("department",user.getDepartment());
//            System.out.println("返回数据==="+user.getDepartment());

            } catch (ClientProtocolException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
