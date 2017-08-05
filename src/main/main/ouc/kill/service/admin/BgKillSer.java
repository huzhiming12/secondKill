package ouc.kill.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ouc.kill.anotation.DataSource;
import ouc.kill.bean.KillBean;
import ouc.kill.dao.KillDao;
import ouc.kill.entity.Kill;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;

/**
 * Created by huzhiming on 2017/7/24.
 * Description:
 */

@Service
public class BgKillSer
{
    @Autowired
    private KillDao killDao;

    @DataSource()
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResultBean addKill(Kill kill)
    {
        ResultBean result = new ResultBean();
        if (killDao.addItem(kill))
        {
            result.setStatus(Status.OK);
            result.setMsg("秒杀添加成功!");
        } else
        {
            result.setStatus(Status.BADREQUEST);
            result.setMsg("秒杀添加失败!");
        }
        return result;
    }

    @DataSource(type = "slave")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResultBean loadKillList()
    {
        ResultBean result = new ResultBean();
        result.setData(killDao.killList());
        result.setStatus(Status.OK);
        return result;
    }

    @DataSource()
    @Transactional
    public void updateKill(int killId)
    {
        KillBean bean = killDao.findKillById(killId);
        Kill kill = new Kill(bean);
        kill.setState((kill.getState()+1)%2);
        killDao.update(kill);
    }

}
