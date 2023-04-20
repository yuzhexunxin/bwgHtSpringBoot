package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Zl;
import com.example.demo.mapper.ZlMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ZlController {
    @Autowired
    private ZlMapper zlMapper;
    @ApiOperation("获取全部展览信息")
    @GetMapping("/zlAll")
    public List exhAll() {
        List<Zl> list = zlMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @ApiOperation("根据id获取展览信息")
    @GetMapping("/zlAll/id/{id}")
    public List<Zl> findByCId(@PathVariable Integer id) {
        QueryWrapper<Zl> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        return zlMapper.selectList(queryWrapper);
    }
    @ApiOperation("根据名称搜索展览信息")
    @GetMapping("/zlAll/name/{name}")
    public List<Zl> findByName(@PathVariable String name) {
        QueryWrapper<Zl> queryWrapper = new QueryWrapper();
        queryWrapper.like("title", name);
        System.out.println(name);
        return zlMapper.selectList(queryWrapper);
    }
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
//    // 条件查询
//    @GetMapping("/user/find")
//    public List<User> findByCond() {
//        QueryWrapper<User> queryWrapper = new QueryWrapper();
//        queryWrapper.eq("name","小米");
//        return userMapper.selectList(queryWrapper);
//    }

}
