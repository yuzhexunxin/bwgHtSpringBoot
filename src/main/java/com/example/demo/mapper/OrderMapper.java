package com.example.demo.mapper;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Exh;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
