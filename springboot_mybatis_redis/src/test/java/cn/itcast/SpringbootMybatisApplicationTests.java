package cn.itcast;

import cn.itcast.dao.UserMapper;
import cn.itcast.entity.User;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectAll();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(users);
        System.out.println("--------------------------------------------------------------------------");

    }

}
