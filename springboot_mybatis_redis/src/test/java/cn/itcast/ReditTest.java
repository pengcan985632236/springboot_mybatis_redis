package cn.itcast;

import cn.itcast.dao.UserMapper;
import cn.itcast.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class ReditTest {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test() throws Exception {
        // 1.从redis中获取数据，数据格式一般使用json
        String key = "user.findAll1";
        String userListJson = redisTemplate.boundValueOps(key).get();
        if(null==userListJson){
            // 2.判断想要的数据是否存在
            // 2.1没有数据，从数据库取数据
            List<User> users = userMapper.selectAll();
            // 2.2 将集合转换为String
            ObjectMapper objectMapper = new ObjectMapper();
            userListJson = objectMapper.writeValueAsString(users);
            // 2.3把数据存缓存中
            redisTemplate.boundValueOps(key).set(userListJson);
            System.out.println("===========从数据库中获取数据======================");


        }
        else
        {
            System.out.println("===========从缓存redis中获取数据======================");

        }



        // 4.将数据打印到控制台
        System.out.println(userListJson);
    }
}
