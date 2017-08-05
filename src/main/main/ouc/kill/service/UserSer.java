package ouc.kill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ouc.kill.anotation.DataSource;
import ouc.kill.bean.SessionBean;
import ouc.kill.dao.UserDao;
import ouc.kill.bean.UserBean;
import ouc.kill.dao.redis.RSessionDaoImpl;
import ouc.kill.util.CookieUtil;
import ouc.kill.util.SecurityUtil;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;
import ouc.kill.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */

@Service
public class UserSer
{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RSessionDaoImpl rSessionDao;

    @DataSource()
    @Transactional
    public ResultBean userRegister(User user)
    {
        ResultBean result = new ResultBean();
        UserBean u = userDao.findUserByUserName(user.getUsername());
        if (u != null)
        {
            result.setStatus(Status.BADREQUEST);
            result.setMsg("用户名已存在!");
        } else
        {
            user.setPassword(SecurityUtil.md5(user.getPassword()));
            boolean res = userDao.addItem(user);
            if (res)
                result.setStatus(Status.OK);
            else
                result.setStatus(Status.BADREQUEST);
        }
        return result;
    }


    @DataSource(type = "slave")
    @Transactional
    public ResultBean userLogin(String username, String password, HttpServletResponse response)
    {
        ResultBean resultBean = new ResultBean();
        UserBean bean = userDao.findUserByUserName(username);
        if (bean == null)
        {
            resultBean.setStatus(Status.BADREQUEST);
            resultBean.setMsg("用户名不存在!");
        } else
        {
            if (!bean.getPassword().equals(SecurityUtil.md5(password)))
            {
                resultBean.setStatus(Status.BADREQUEST);
                resultBean.setMsg("密码不正确!");
            } else
            {
                //创建session
                SessionBean session = new SessionBean();
                session.setUsername(bean.getUsername());
                session.setUserToken(bean.getUserToken());
                String loginToken = SecurityUtil.getRandomCode();
                //将session存储在redis中
                int expireTime = rSessionDao.setSession(session, loginToken);
                Cookie cookie = new Cookie("loginToken", loginToken);
                cookie.setPath("/");
                cookie.setMaxAge(expireTime);
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
                resultBean.setStatus(Status.OK);
            }
        }
        return resultBean;
    }

    //用户注销
    public void userLogout(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie cookie = CookieUtil.getCookie(request, "loginToken");
        if (cookie != null)
        {
            //删除Cookie
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            //删除缓存中的session
            rSessionDao.delSession(cookie.getValue());
        }
    }

    //获取用户个人信息
    public SessionBean getSession(HttpServletRequest request)
    {
        Cookie cookie = CookieUtil.getCookie(request, "loginToken");
        //从缓存中获取session
        SessionBean session = rSessionDao.getSession(cookie.getValue());
        return session;
    }

}
