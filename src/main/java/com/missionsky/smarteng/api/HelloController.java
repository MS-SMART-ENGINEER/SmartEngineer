package com.missionsky.smarteng.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.missionsky.smarteng.model.PageBean;
import com.missionsky.smarteng.model.User;
import com.missionsky.smarteng.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return helloService.getGreeting();
    }

    @RequestMapping(value = "/hello/{userId}", method = RequestMethod.GET)
    public String say(@PathVariable String userId) {
        return  helloService.getGreeting() + helloService.getUserName(userId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam String userId) {
        return  helloService.getUser(userId);
    }

    @RequestMapping(value="/user/page")
    public List<User> getUsersByPage()
    {
        /*
       * 第一个参数是第几页；第二个参数是每页显示条数。
       */
        PageHelper.startPage(1,3);
        //结果集
        List<User> results=helloService.getUsers();
        //pageInfo msg cosole打印测试
        PageInfo<User> pageInfo=new PageInfo<>(results);
        System.out.println("总记录数: "+pageInfo.getTotal());
        System.out.println("当前页码: "+pageInfo.getPageNum());
        System.out.println("总页数: "+pageInfo.getPages());

        //pageBean实体对象封装
        PageBean pageResult=new PageBean();
        pageResult.setResults(results);
        pageResult.setPageIndex(pageInfo.getPageNum());
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setTotals(pageInfo.getTotal());

        return results;
    }

}
