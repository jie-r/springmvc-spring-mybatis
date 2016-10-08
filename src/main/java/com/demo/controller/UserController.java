package com.demo.controller;

import com.demo.common.message.BaseResponse;
import com.demo.entities.User;
import com.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static com.demo.common.util.PropertiesUtil.getValue;

/**
 * 用户控制类
 * Created by Administrator on 2016/8/22.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;


    /**
     * 获取全部用户信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "user/client/getUserDataById/{id}", method = RequestMethod.GET)
    public BaseResponse getUserDataById(@PathVariable String id) throws Exception {
        User user = userService.getUserDataById(id);
        return new BaseResponse(getValue("MsgCode.SUCCESS"), getValue("MsgContent.load"), user);
    }

    @RequestMapping(value = "user/client/insertUserDataById", method = RequestMethod.POST)
    public BaseResponse insertUserDataById(User user) throws Exception {
        boolean status = userService.insertUserDataById(user);
        return new BaseResponse(getValue("MsgCode.SUCCESS"), getValue("MsgContent.load"), status);
    }

    @RequestMapping(value = "user/client/deleteUser/{id}", method = RequestMethod.GET)
    public BaseResponse deleteUser(@PathVariable String id) throws Exception {
        boolean status = userService.deleteUser(id);
        return new BaseResponse(getValue("MsgCode.SUCCESS"), status);
    }

    @RequestMapping(value = "user/client/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("id") int id, @RequestParam("password") int password, HttpSession session) throws Exception {
        User user = userService.login(id, password);
        session.setAttribute("currentUser", user);
        String viewName = "login";
        if (user != null) {
            viewName = "index";
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/view/" + viewName + ".jsp");
        return mv;
    }

    @RequestMapping(value = "user/client/updateUser", method = RequestMethod.POST)
    public BaseResponse updateUser(String id, String name, String age, String cs) throws Exception {
        boolean status = userService.updateUser(id, name, age, cs);
        return new BaseResponse(getValue("MsgCode.SUCCESS"), status);
    }


    @RequestMapping(value = "user/client/selectOneC/{id}", method = RequestMethod.GET)
    public BaseResponse selectOneC(@PathVariable String id) throws Exception {
        String val = userService.selectOneC(id);
        return new BaseResponse(getValue("MsgCode.SUCCESS"), val);
    }

    @RequestMapping(value = "user/client/selectOne/{id}", method = RequestMethod.GET)
    public BaseResponse selectOne(@PathVariable String id) throws Exception {
        User user = userService.selectOne(id);
        return new BaseResponse(getValue("MsgCode.SUCCESS"), user);
    }

    /**
     * 页面跳转
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("browser/toLogin")
    @ResponseBody
    public ModelAndView toLoginPage(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView();
        session.removeAttribute("currentUser");
        mv.setViewName("redirect:/view/login.jsp");
        return mv;
    }
}
