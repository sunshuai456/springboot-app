package com.mars.service;

import com.mars.mapper.UserMapper;
import com.mars.dto.UserDto;
import com.mars.entity.User;
import com.mars.util.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserService {

    private final UserMapper userMapper;

    public User findById(int id) {
        User user = userMapper.findById(id);
        Assert.notNull(user, "用户信息不存在");
        return user;
    }

    public UserDto getUser(int id) {
        User user = findById(id);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public void save(String userName, String passwrod, String realName) {
        User oldUser = userMapper.findByUserName(userName);
        Assert.isNull(oldUser, "用户名已存在");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passwrod);
        user.setRealName(realName);
        user.setAddTime(new Date());
        userMapper.save(user);
    }

    public void delete(int id) {
        User user = findById(id);
        user.setDeleteTime(new Date());
        userMapper.delete(user);
    }

    public void update(int id, String userName, String password, String realName) {
        User oldUser = userMapper.findByUserName(userName);
        Assert.isTrue(oldUser == null || oldUser.getId() == id, "登录名称已存在");
        User user = findById(id);
        user.setUserName(userName);
        user.setPassword(password);
        user.setRealName(realName);
        userMapper.update(user);
    }

}
