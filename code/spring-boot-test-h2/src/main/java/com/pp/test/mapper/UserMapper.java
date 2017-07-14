package com.pp.test.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.pp.test.entity.User;

public interface UserMapper {
	
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into users (username,password,status)values(#{username},#{password},#{status})")
    public Integer addUser(User user);
    
    @Delete("delete from users where id=#{0}")
    public Integer deleteUserById(Integer id);
    
    @Update("update users set username=#{username},password=#{password},status=#{status} where id=#{id}")
    public Integer updateUser(User user);
    
    @Select("select * from users where id=#{0}")
    public User getById(Integer id);
    
    @Select("select * from users")
    public List<User> queryUserList();
    }