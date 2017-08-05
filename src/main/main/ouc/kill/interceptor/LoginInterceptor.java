package ouc.kill.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ouc.kill.bean.SessionBean;
import ouc.kill.dao.redis.RSessionDaoImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huzhiming on 2017/7/27.
 * Description:
 */
public class LoginInterceptor implements HandlerInterceptor
{
    @Autowired
    private RSessionDaoImpl rSessionDao;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
        Cookie[] cookies = httpServletRequest.getCookies();
        String loginToken = null;
        if (cookies != null)
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals("loginToken"))
                {
                    loginToken = cookie.getValue();
                    break;
                }
            }
        //cookie中不存在LoginToken
        if (loginToken == null || loginToken.isEmpty() || "".equals(loginToken))
        {
            httpServletRequest.getRequestDispatcher("loginUI").forward(httpServletRequest, httpServletResponse);
            return false;
        }
        //从redis中获取session
        SessionBean session = rSessionDao.getSession(loginToken);
        //redis 中不存在登录令牌
        if (session == null || session.getUserToken() == null || "".equals(session.getUserToken()))
        {
            httpServletRequest.getRequestDispatcher("loginUI").forward(httpServletRequest, httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {

    }
}
