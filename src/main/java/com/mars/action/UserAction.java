package com.mars.action;

import com.mars.annotation.ResponseMessage;
import com.mars.dto.UserDto;
import com.mars.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Tag(name = "UserAction", description = "用户接口")
public class UserAction {

    private final UserService userService;

    @GetMapping(path = "/{id}")
    @Operation(summary = "获取用户", description = "获取指定用户信息",
            parameters = {@Parameter(name = "id", description = "要查询的用户标识")})
    public UserDto get(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping(path = "/save")
    @Operation(summary = "新增用户", description = "添加一个新用户",
            parameters = {
                    @Parameter(name = "userName", description = "登录名称"),
                    @Parameter(name = "password", description = "登录密码"),
                    @Parameter(name = "realName", description = "用户姓名")
            })
    public void save(@RequestParam("userName") String userName,
                     @RequestParam("password") String password,
                     @RequestParam("realName") String realName) {
        userService.save(userName, password, realName);
    }

    @DeleteMapping(path = "/delete")
    @Operation(summary = "删除用户", description = "删除指定用户信息",
            parameters = {@Parameter(name = "id", description = "要删除的用户标识")})
    public void delete(@RequestParam("id") int id) {
        userService.delete(id);
    }

    @PutMapping(path = "/update")
    @Operation(summary = "修改用户", description = "修改用户信息",
            parameters = {
                    @Parameter(name = "id", description = "要修改的用户标识"),
                    @Parameter(name = "userName", description = "登录名称"),
                    @Parameter(name = "password", description = "登录密码"),
                    @Parameter(name = "realName", description = "用户姓名")
            })
    public void update(@RequestParam("id") int id,
                       @RequestParam("userName") String userName,
                       @RequestParam("password") String password,
                       @RequestParam("realName") String realName) {
        userService.update(id, userName, password, realName);
    }

}
