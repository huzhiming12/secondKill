package ouc.kill.dao;

import ouc.kill.base.BaseDao;
import ouc.kill.bean.KillBean;
import ouc.kill.entity.Kill;

import java.util.List;

/**
 * Created by huzhiming on 2017/7/24.
 * Description:
 */
public interface KillDao extends BaseDao<KillBean>
{
    List<KillBean> killList();

    KillBean findKillById(int id);
}
