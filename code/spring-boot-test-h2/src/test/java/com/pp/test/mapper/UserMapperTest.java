package com.pp.test.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pp.test.config.MybatisScanConfiguration;
import com.pp.test.entity.User;

@RunWith(SpringRunner.class)
/** 
 *这里指定的classes是可选的。如果不指定classes，则spring boot会启动整个spring容器，很慢（比如说会执行一些初始化，ApplicationRunner、CommandLineRunner等等）
 *指定的话，就只会初始化指定的bean，速度快，推荐 
 */
@SpringBootTest(classes={DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class, MybatisScanConfiguration.class})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testAddUser() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        Assert.assertNotNull(user.getId());
    }
    
    @Test
    public void testDeleteUserById() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        Integer count = userMapper.deleteUserById(user.getId());
        Assert.assertEquals(new Integer(1), count);
    }
    
    @Test
    public void testUpdateUser() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        user.setUsername("hr");
        userMapper.updateUser(user);
        Assert.assertEquals("hr", user.getUsername());
    }
    
    @Test
    public void testGetById() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        
        User obj = userMapper.getById(user.getId());
        Assert.assertEquals("admin", obj.getUsername());
        Assert.assertEquals("123", obj.getPassword());
        Assert.assertEquals(new Integer(1), obj.getStatus());
    }
    
    @Test
    public void testQueryUserList() {
        User user = new User("admin","123",1);
        userMapper.addUser(user);
        List<User> users = userMapper.queryUserList();
        Assert.assertTrue(!users.isEmpty());
    }
}