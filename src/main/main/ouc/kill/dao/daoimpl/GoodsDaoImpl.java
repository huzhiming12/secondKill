package ouc.kill.dao.daoimpl;

import org.springframework.stereotype.Component;
import ouc.kill.base.BaseDaoImpl;
import ouc.kill.dao.GoodsDao;
import ouc.kill.bean.GoodsBean;
import ouc.kill.entity.Goods;
import ouc.kill.util.QueryHelper;

import java.util.List;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 */
@Component(value = "goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<GoodsBean> implements GoodsDao
{
    @Override
    public List<GoodsBean> loadGoods()
    {
        QueryHelper queryHelper = new QueryHelper(GoodsBean.class);
        queryHelper.addSelectItems(GoodsBean.baseColumns);
        queryHelper.addFrom(Goods.class, "g");
        List<GoodsBean> res = loadItems(queryHelper);
        return res;
    }
}
