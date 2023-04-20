package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Cmnt;
import com.example.demo.entity.Exh;
import com.example.demo.entity.User;
import com.example.demo.mapper.CmntMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class CmntController {
    @Autowired
    private CmntMapper cmntMapper;
    @ApiOperation("增加评论")
    @PostMapping("/cmntAll/save")
    public Integer saveCmnt(@RequestBody Cmnt cmnt) {
        Date date = new Date();
        cmnt.setDate(date);
        cmntMapper.insert(cmnt);
        // 成功返回1
        return 1;
    }
    @ApiOperation("根据id删除评论")
    @DeleteMapping("/cmntAll/delete/{id}")
    public String deleteCmntById(@PathVariable  Integer id) {
        QueryWrapper<Cmnt> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        // 成功返回1
        cmntMapper.delete(queryWrapper);
        return "1";

    }
    @ApiOperation("根据用户id获取评论")
    @GetMapping("/cmntAll/user/{id}")
    public List<Cmnt> findByCondUser(@PathVariable Integer id) {
        QueryWrapper<Cmnt> queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid", id).orderByDesc("date");
        return cmntMapper.selectList(queryWrapper);
    }
    @ApiOperation("根据展览id获取评论")
    @GetMapping("/cmntAll/zl/{id}")
    public List<Cmnt> findByCondZl(@PathVariable Integer id) {
        return cmntMapper.selectCmntAndZl(id);
    }
    @ApiOperation("根据展品id获取评论")
    @GetMapping("/cmntAll/exh/{id}")
    public List<Cmnt> findByCondExh(@PathVariable Integer id) {
        return cmntMapper.selectCmntAndExh(id);
    }
    @ApiOperation("根据新闻id获取评论")
    @GetMapping("/cmntAll/new/{id}")
    public List<Cmnt> findByCondNew(@PathVariable Integer id) {
        return cmntMapper.selectCmntAndNew(id);
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
