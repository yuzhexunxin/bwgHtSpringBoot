package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class NewsController {
    @Autowired
    private NewsMapper newsMapper;
    @ApiOperation("获取全部新闻信息")
    @GetMapping("/newAll")
    public List exhAll() {
        List<News> list = newsMapper.selectList(null);
        return list;
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
    // 条件查询
    @GetMapping("/newAll/id/{newId}")
    public List<News> findByCond(@PathVariable Integer newId) {
        QueryWrapper<News> queryWrapper = new QueryWrapper();
        queryWrapper.eq("new_id", newId);
        return newsMapper.selectList(queryWrapper);
    }

}
