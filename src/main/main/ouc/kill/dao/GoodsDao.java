package ouc.kill.dao;

import ouc.kill.base.BaseDao;
import ouc.kill.bean.GoodsBean;

import java.util.List;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
public interface GoodsDao extends BaseDao<GoodsBean>
{
    List<GoodsBean> loadGoods();
}
