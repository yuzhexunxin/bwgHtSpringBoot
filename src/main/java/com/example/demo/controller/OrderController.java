package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.entity.Cmnt;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.mapper.OrderMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    // 查找订单用户
    @ApiOperation("增加预约订单")
    @PostMapping("/order/save")
    public Integer saveOrder(@RequestBody Order order) {
        orderMapper.insert(order);
        // 成功返回1
        return 1;
    }
    @ApiOperation("根据id修改预约订单状态")
    @PutMapping("/order/cancel")
    public Integer cancelOrderById(@RequestBody Order order) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper();
        queryWrapper.eq("ordercode", order.getOrdercode());
        orderMapper.update(order,queryWrapper);
        return 1;
    }
    @ApiOperation("根据用户id获取订单")
    @GetMapping("/order/user/{id}")
    public List<Order> findOrderByUserId(@PathVariable Integer id) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper();
        queryWrapper.eq("userid", id).orderByDesc("dodate");
        return orderMapper.selectList(queryWrapper);
    }
    @ApiOperation("根据用户id删除订单")
    @DeleteMapping("/order/delete/{id}")
    public Integer deleteOrderById(@PathVariable Integer id) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        orderMapper.delete(queryWrapper);
        return 1;

    }

}
