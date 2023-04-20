package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Like;
import com.example.demo.mapper.LikeMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LikeController {
    @Autowired
    private LikeMapper likeMapper;
    // 查找订单用户
    @ApiOperation("增加收藏")
    @PostMapping("/like/save")
    public Like saveLike(@RequestBody Like like) {
        likeMapper.insert(like);
        // 成功返回1
        return like;
    }
    @ApiOperation("根据用户id获取收藏")
    @GetMapping("/like/{id}")
    public List<Like> findLikeByUserId(@PathVariable Integer id) {
        QueryWrapper<Like> queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid", id);
        return likeMapper.selectList(queryWrapper);
    }
    @ApiOperation("根据用户id删除收藏")
    @DeleteMapping("/like/delete/{id}")
    public Integer deleteLikeById(@PathVariable Integer id) {
        QueryWrapper<Like> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        likeMapper.delete(queryWrapper);
        return 1;

    }

}
