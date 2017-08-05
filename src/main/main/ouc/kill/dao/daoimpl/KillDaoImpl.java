package ouc.kill.dao.daoimpl;

import org.springframework.stereotype.Component;
import ouc.kill.base.BaseDaoImpl;
import ouc.kill.dao.KillDao;
import ouc.kill.bean.KillBean;
import ouc.kill.entity.Kill;
import ouc.kill.util.QueryHelper;

import java.util.List;

/**
 * Created by huzhiming on 2017/7/24.
 * Description:
 */
@Component("killDao")
public class KillDaoImpl extends BaseDaoImpl<KillBean> implements KillDao
{
    private QueryHelper getBaseQueryHelper()
    {
        QueryHelper queryHelper = new QueryHelper(KillBean.class);
        queryHelper.addSelectItems(KillBean.baseColumns);
        queryHelper.addFrom(Kill.class, "k");
        return queryHelper;
    }

    @Override
    public List<KillBean> killList()
    {
        QueryHelper queryHelper = getBaseQueryHelper();
        queryHelper.addCondition("k.state=?", 0);
        return loadItems(queryHelper);
    }

    @Override
    public KillBean findKillById(int id)
    {
        QueryHelper queryHelper = getBaseQueryHelper();
        queryHelper.addCondition("k.killId=?", id);
        List<KillBean> list = loadItems(queryHelper);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

}
