package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.AccountService;
import com.atguigu.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;


    @GetMapping("/sql")
    @ResponseBody
    public String queryFromDb(){
        Long along = jdbcTemplate.queryForObject("select count(*) from t_user",Long.class);
        return along.toString();
    }
    /**
     * 登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/logins")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            //
            session.setAttribute("loginUser",user);
            // 登录成功重定向到main页面
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }



    }

    /**
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(Model model,HttpSession session){
        Object obj = session.getAttribute("loginUser");
        if(obj != null){
            return "main";
        }else{
            model.addAttribute("msg","请重新登录");
            return "login";
        }


    }
    @GetMapping("/city")
    @ResponseBody
    public City getCitById(Long id){
        return cityService.getCityById(id);

    }

    @PostMapping("/savecity")
    @ResponseBody
    public void saveCity(City city){
        cityService.insert(city);

    }

    @GetMapping("/acct")
    @ResponseBody
    public Account getById(Long id){
        return accountService.getAccountById(id);
    }
}
