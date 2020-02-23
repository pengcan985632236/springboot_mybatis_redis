package cn.itcast.controller;

import cn.itcast.dao.UserMapper;
import cn.itcast.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> users = userMapper.selectAll();
        return users;


    }
}
