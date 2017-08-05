package ouc.kill.dao;

import ouc.kill.base.BaseDao;
import ouc.kill.bean.OrderBean;

import java.util.List;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
public interface OrderDao extends BaseDao<OrderBean>
{
     List<OrderBean> loadOrders(String userToken);
}
