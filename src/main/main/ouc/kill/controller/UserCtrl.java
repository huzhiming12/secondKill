package ouc.kill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ouc.kill.base.BaseCtrl;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;
import ouc.kill.entity.User;
import ouc.kill.service.UserSer;
import ouc.kill.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */

@Controller
@RequestMapping(value = "/")
public class UserCtrl extends BaseCtrl
{
    @Autowired
    private UserSer userSer;

    @RequestMapping(value = "registerUI", method = RequestMethod.GET)
    public String userRegisterUI()
    {
        return USER_PREFIX + "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public String userRegister(User user)
    {
        ResultBean result = userSer.userRegister(user);
        String res = JsonUtil.objectToJson(result);
        System.out.println(res);
        return res;
    }

    @RequestMapping("loginUI")
    public String login()
    {
        return USER_PREFIX + "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(String username, String password, HttpServletResponse response, Model model)
    {
        ResultBean result = userSer.userLogin(username, password, response);
        if (result.getStatus() == Status.OK)
        {
            return "redirect:index";
        } else
        {
            model.addAttribute("result", result);
            return USER_PREFIX + "login";
        }
    }

    @RequestMapping("logout")
    public String userLogout(HttpServletRequest request, HttpServletResponse response)
    {
        userSer.userLogout(request, response);
        return "redirect:loginUI";
    }
}
