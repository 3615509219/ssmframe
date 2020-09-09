package com.xtkj.controller;

import com.xtkj.pojo.User;
import com.xtkj.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");
        IUserService userService = (IUserService) context.getBean("userService");
        ModelAndView m = new ModelAndView();
        String action = req.getParameter("action");
        switch (action) {
            case "query": {
                int userId = Integer.parseInt(req.getParameter("queryUserId"));
                User query = userService.query(userId);
                req.setAttribute("query", query);
            }
            break;
            case "add": {
                String userName = req.getParameter("addUserName");
                double userMoney = Double.parseDouble(req.getParameter("addUserMoney"));
                user.setTbUsername(userName);
                user.setTbUsermoney(userMoney);
                int add = userService.add(user);
                if (add>0){
                    req.setAttribute("add","增加成功");
                }
            }
            break;
            case "delete":{
                int userId = Integer.parseInt(req.getParameter("delUserId"));
                int delete = userService.delete(userId);
                if (delete>0){
                    req.setAttribute("delete","删除成功");
                }
            }
            break;
            case "update":{
                int userId = Integer.parseInt(req.getParameter("updUserId"));
                String userName = req.getParameter("updUserName");
                double userMoney = Double.parseDouble(req.getParameter("updUserMoney"));
                user.setTbUsername(userName);
                user.setTbUsermoney(userMoney);
                int update = userService.update(user);
                if (update>0){
                    req.setAttribute("update","修改成功");
                }
            }
        }
        m.setViewName("/index");
        return m;
    }
}
