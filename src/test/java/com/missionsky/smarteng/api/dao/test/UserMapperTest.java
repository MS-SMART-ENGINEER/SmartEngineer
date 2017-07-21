package com.missionsky.smarteng.api.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.missionsky.smarteng.mapper.UserMapper;
import com.missionsky.smarteng.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by andy.li on 2017/7/21.
 * UserMapper单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getUserById()
    {
        User user=userMapper.getUserById("m001");
        System.out.println(user.getUserId()+" "+user.getName());
    }


    @Test
    public void getUsersByPage()
    {
         /*
       * 第一个参数是第几页；第二个参数是每页显示条数。
       */
        PageHelper.startPage(1,3);
        //结果集
        List<User> results=userMapper.getUsers();
        //pageInfo msg cosole打印测试
        PageInfo<User> pageInfo=new PageInfo<>(results);
        System.out.println("总记录数: "+pageInfo.getTotal());
        System.out.println("当前页码: "+pageInfo.getPageNum());
        System.out.println("总页数: "+pageInfo.getPages());

        //遍历结果集console打印测试
        for(User u:results)
        {
            System.out.println(u.getUserId()+" "+u.getName());
        }
    }

}
