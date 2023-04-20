package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Cmnt;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CmntMapper extends BaseMapper<Cmnt> {

    @Select("select * from cmnt where zlid = #{id} order by date")
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type",property = "type"),
                    @Result(column = "text",property = "text"),
                    @Result(column = "userid",property = "userid"),
                    @Result(column = "exhid",property = "exhid"),
                    @Result(column = "zlid",property = "zlid"),
                    @Result(column = "newid",property = "newid"),
                    @Result(column = "date",property = "date"),
                    @Result(column = "userid",property = "user",javaType = User.class,
                        one = @One(select = "com.example.demo.mapper.UserMapper.selectByUid")
                    ),
            }
    )
    List<Cmnt> selectCmntAndZl(int id);
    //    展品页面查询评论及其用户
    @Select("select * from cmnt where exhid = #{id} order by date")
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type",property = "type"),
                    @Result(column = "text",property = "text"),
                    @Result(column = "userid",property = "userid"),
                    @Result(column = "exhid",property = "exhid"),
                    @Result(column = "zlid",property = "zlid"),
                    @Result(column = "newid",property = "newid"),
                    @Result(column = "date",property = "date"),
                    @Result(column = "userid",property = "user",javaType = User.class,
                            one = @One(select = "com.example.demo.mapper.UserMapper.selectByUid")
                    ),
            }
    )
    List<Cmnt> selectCmntAndExh(int id);
    //    新闻页面查询评论及其用户
    @Select("select * from cmnt where newid = #{id} order by date")
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "type",property = "type"),
                    @Result(column = "text",property = "text"),
                    @Result(column = "userid",property = "userid"),
                    @Result(column = "exhid",property = "exhid"),
                    @Result(column = "zlid",property = "zlid"),
                    @Result(column = "newid",property = "newid"),
                    @Result(column = "date",property = "date"),
                    @Result(column = "userid",property = "user",javaType = User.class,
                            one = @One(select = "com.example.demo.mapper.UserMapper.selectByUid")
                    ),
            }
    )
    List<Cmnt> selectCmntAndNew(int id);
}
