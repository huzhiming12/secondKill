package ouc.kill.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by huzhiming on 2017/7/27.
 * Description:
 */
public class CookieUtil
{
    public static Cookie getCookie(HttpServletRequest request, String key)
    {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie.getName().equals(key))
                {
                    return cookie;
                }
            }
        }
        return null;
    }

}
