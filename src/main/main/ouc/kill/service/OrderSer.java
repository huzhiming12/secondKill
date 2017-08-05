package ouc.kill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ouc.kill.anotation.DataSource;
import ouc.kill.bean.OrderBean;
import ouc.kill.bean.SessionBean;
import ouc.kill.dao.OrderDao;
import ouc.kill.dao.redis.RSessionDaoImpl;
import ouc.kill.util.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
@Service
public class OrderSer
{
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RSessionDaoImpl rSessionDao;

    public boolean addOrder(Order order)
    {
        return orderDao.addItem(order);
    }

    @DataSource(type = "slave")
    @Transactional
    public List<OrderBean> loadOrders(HttpServletRequest request)
    {
        Cookie cookie = CookieUtil.getCookie(request, "loginToken");
        String loginToken = cookie.getValue();
        SessionBean session = rSessionDao.getSession(loginToken);
        return orderDao.loadOrders(session.getUserToken());
    }

}
