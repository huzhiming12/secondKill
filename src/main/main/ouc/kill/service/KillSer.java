package ouc.kill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ouc.kill.anotation.DataSource;
import ouc.kill.bean.KillBean;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.SessionBean;
import ouc.kill.bean.Status;
import ouc.kill.dao.KillDao;
import ouc.kill.dao.redis.RKillDaoImpl;
import ouc.kill.dao.redis.RSessionDaoImpl;
import ouc.kill.util.ConfigUtil;
import ouc.kill.util.CookieUtil;
import ouc.kill.util.HttpUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huzhiming on 2017/7/24.
 * Description:
 */
@Service
public class KillSer
{
    private int num = 1;
    @Autowired
    private KillDao killDao;
    @Autowired
    private RKillDaoImpl rKillDao;
    @Autowired
    private RSessionDaoImpl rSessionDao;

    @DataSource(type = "slave")
    @Transactional
    public List<KillBean> loadKillList()
    {
        return killDao.killList();
    }

    @DataSource(type = "slave")
    @Transactional
    public KillBean loadKillById(int killId)
    {
        //从缓存中获取,如果不存在然后再读取数据库
        KillBean bean = rKillDao.getKillById(killId);
        if (bean == null)
        {
            bean = killDao.findKillById(killId);
            //写入redis中
            if (bean != null)
                rKillDao.setKill(bean);
        }
        return bean;
    }

    ReentrantLock lock = new ReentrantLock();
    HashMap<Integer, HashSet<String>> map = new HashMap<>();

    public ResultBean kill(int killId, HttpServletRequest request)
    {
        ResultBean result = new ResultBean();
        Cookie cookie = CookieUtil.getCookie(request, "loginToken");
        String loginToken = cookie.getValue();
        SessionBean session = rSessionDao.getSession(loginToken);
        if (session == null || session.getUserToken() == null)
        {
            result.setMsg("您还未登录!");
            result.setStatus(Status.BADREQUEST);
            return result;
        }
        HashSet<String> killSet = null;
        lock.lock();
        try
        {
            killSet = map.get(killId);
            if (killSet == null)
                killSet = new HashSet<String>();
            map.put(killId, killSet);
        } finally
        {
            lock.unlock();
        }
        result = tryKill(killSet, session.getUserToken(), killId);
        return result;
    }

    @DataSource(type = "slave")
    @Transactional
    private ResultBean tryKill(HashSet<String> killSet, String userToken, int killId)
    {
        ResultBean result = new ResultBean();
        KillBean kill = loadKillById(killId);
        synchronized (killSet)
        {
            if (killSet.contains(userToken))
            {
                result.setStatus(Status.BADREQUEST);
                result.setMsg("请勿重复提交请求!");
                return result;
            } else if (killSet.size() >= kill.getLimitNum())
            {
                result.setStatus(Status.BADREQUEST);
                result.setMsg("秒杀已结束!");
            } else
                killSet.add(userToken);
        }
        String path = ConfigUtil.getInstance().getConstantVarByKey("center_server") + "/center/kill";
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("killId", killId + "");
        params.put("userToken", userToken);
        result = HttpUtil.doPost(path, params);
        return result;
    }
}
