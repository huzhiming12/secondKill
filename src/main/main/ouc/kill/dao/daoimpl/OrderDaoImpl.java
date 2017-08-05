package ouc.kill.dao.daoimpl;

import org.springframework.stereotype.Component;
import ouc.kill.base.BaseDaoImpl;
import ouc.kill.bean.OrderBean;
import ouc.kill.dao.OrderDao;
import ouc.kill.entity.Order;
import ouc.kill.util.QueryHelper;

import java.util.List;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
@Component
public class OrderDaoImpl extends BaseDaoImpl<OrderBean> implements OrderDao
{
    public List<OrderBean> loadOrders(String userToken)
    {
        QueryHelper queryHelper = new QueryHelper(OrderBean.class);
        queryHelper.addSelectItems(OrderBean.baseColumn);
        queryHelper.addFrom(Order.class, "o");
        queryHelper.addCondition("o.user.userToken=?", userToken);
        List<OrderBean> list = loadItems(queryHelper);
        return list;
    }
}
