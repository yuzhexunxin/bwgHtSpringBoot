package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Exh;
import com.example.demo.entity.News;
import com.example.demo.mapper.ExhMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ExhController {
    @Autowired
    private ExhMapper exhMapper;
    @ApiOperation("获取全部展品信息")
    @GetMapping("/exhAll")
    public List exhAll() {
        List<Exh> list = exhMapper.selectList(null);
        System.out.println(list);
        return list;
    }
    @ApiOperation("根据id获取展品信息")
    @GetMapping("/exhAll/id/{exhId}")
    public List<Exh> findById(@PathVariable Integer exhId) {
        QueryWrapper<Exh> queryWrapper = new QueryWrapper();
        queryWrapper.eq("exh_id", exhId);
        return exhMapper.selectList(queryWrapper);
    }
    @ApiOperation("根据名称搜索展品信息")
    @GetMapping("/exhAll/name/{exhName}")
    public List<Exh> findByName(@PathVariable String exhName) {
        QueryWrapper<Exh> queryWrapper = new QueryWrapper();
        queryWrapper.like("exh_name", exhName);
        return exhMapper.selectList(queryWrapper);
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
