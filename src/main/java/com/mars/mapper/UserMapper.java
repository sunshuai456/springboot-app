package com.mars.mapper;

import com.mars.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
//
//    @Results(id = "user", value = {
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "id", property = "id"),
//            @Result(column = "add_time", property = "addTime"),
//            @Result(column = "delete_time", property = "deleteTime"),
//            @Result(column = "user_name", property = "userName"),
//            @Result(column = "password", property = "password"),
//            @Result(column = "real_name", property = "realName"),
//    })
//    @Select("select * from tb_user where id=#{id}")
    User findById(int id);

//    @Select("select * from tb_user where user_name=#{userName}")
    User findByUserName(String userName);

//    @Insert("insert into tb_user(add_time,user_name,password,real_name) values(#{addTime},#{userName},#{password},#{realName})")
    void save(User user);

//    @Update("update tb_user set user_name=#{userName},password=#{password},real_name=#{realName} where id=#{id}")
    void update(User user);

//    @Update("update tb_user set delete_time=#{deleteTime} where id=#{id}")
    void delete(User user);
//
//
//    @ResultMap("user")
//    @Select({"<script>",
//            "select * from tb_user where delete_time is null",
//            "<if test='username!=null and username != \"\"'>", "and username like %${search}%", "</if>",
//            "</script>"})
//    Pageable<User> findByPage(String search, int pageNo, int pageSize);

}