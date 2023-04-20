package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.Cmnt;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserMapper userMapper;
    // 根据id查询用户
    @GetMapping("/user/id/{id}")
    public List<User> findByCondId(@PathVariable Integer id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",id);
        return userMapper.selectList(queryWrapper);
    }
    // 根据用户名查询用户
    @GetMapping("/user/name/{name}")
    public List<User> findByCondName(@PathVariable String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",name);
        return userMapper.selectList(queryWrapper);
    }
    // 登录
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, user.getUserName()).eq(User::getPassword, user.getPassword()));
        if(res == null) {
            // 用户不存在
            return null;
        }
        // 返回用户信息
        return res;
    }
    // 注册
    @PostMapping("/register")
    public Integer register(@RequestBody User user) {
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserName, user.getUserName()));
        if(res != null) {
            //存在用户，返回失败
            return 0;
        }
        // 用户为新用户，创建新用户
        userMapper.insert(user);
        return 1;
    }
    @ApiOperation("根据id修改用户信息")
    @PutMapping("/user/putInfo")
    public Integer putUserById(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", user.getUserId());
        userMapper.update(user,queryWrapper);
        return 1;
    }
    @ApiOperation("根据id删除用户")
    @DeleteMapping("/user/delete/{id}")
    public String deleteCmntById(@PathVariable Integer id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", id);
        // 成功返回1
        userMapper.delete(queryWrapper);
        return "1";

    }
//    @ApiOperation("获取用户")
//    @GetMapping("/user")
//    public List query() {
//        List<User> list = userMapper.selectList(null);
//        System.out.println(list);
//        return list;
//    }
//    @PostMapping("/user")
//    public String save(User user) {
//        int i = userMapper.insert(user);
//        if(i>0) {
//            return "插入成功";
//        }else{
//            return "插入失败";
//        }
//    }
//    // 查找用户订单
//    @GetMapping("/user/findAll")
//    public List<User> find() {
//        return userMapper.selectAllUserAndOrders();
//    }


}
