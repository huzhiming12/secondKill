package ouc.center.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ouc.kill.anotation.DataSource;
import ouc.kill.bean.KillBean;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;
import ouc.kill.dao.KillDao;
import ouc.kill.dao.OrderDao;
import ouc.kill.dao.redis.RKillDaoImpl;
import ouc.kill.entity.Kill;
import ouc.kill.entity.Order;
import ouc.kill.service.KillSer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
@Service
public class CenterSer
{
    @Autowired
    private KillSer killSer;
    @Autowired
    private KillDao killDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private RKillDaoImpl rKillDao;

    private Map<Integer, HashSet<String>> map = new HashMap<>();
    private ReentrantLock lock = new ReentrantLock();

    @DataSource()
    @Transactional
    public ResultBean kill(int killId, String userToken)
    {
        ResultBean result = new ResultBean();
        HashSet<String> killSet = null;
        lock.lock();
        try
        {
            killSet = map.get(killId);
            if (killSet == null)
                killSet = new HashSet<>();
            map.put(killId, killSet);
        } finally
        {
            lock.unlock();
        }
        KillBean kill = killSer.loadKillById(killId);
        synchronized (killSet)
        {
            if (killSet.contains(userToken))
            {
                result.setMsg("请勿重复提交请求!");
                result.setStatus(Status.BADREQUEST);
            } else if (killSet.size() >= kill.getLimitNum())
            {
                result.setMsg("秒杀已结束!");
                result.setStatus(Status.BADREQUEST);
            } else
            {
                killSet.add(userToken);
                kill.setSelled(kill.getSelled() + 1);
                Kill k = new Kill(kill);
                Order order = new Order(killId, userToken, kill.getGoodsId());
                orderDao.addItem(order);
                killDao.update(k);
                rKillDao.setKill(kill);
                result.setMsg("抢购成功!");
                result.setStatus(Status.OK);
            }
        }
        return result;
    }
}
