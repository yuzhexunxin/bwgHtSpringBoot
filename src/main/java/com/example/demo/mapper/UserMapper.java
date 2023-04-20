package com.example.demo.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.stream.BaseStream;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user_id = #{id}")
    User selectByUid(int id);
//    查询用户及其订单
//    @Select("select * from user")
//    @Results(
//            {
//                    @Result(column = "id",property = "id"),
//                    @Result(column = "name",property = "name"),
//                    @Result(column = "age",property = "age"),
//                    @Result(column = "id",property = "orders",javaType = List.class,
//                        many = @Many(select = "com.example.demo.mapper.OrderMapper.selectByUid")
//                    ),
//            }
//    )
//    List<User> selectAllUserAndOrders();
}
