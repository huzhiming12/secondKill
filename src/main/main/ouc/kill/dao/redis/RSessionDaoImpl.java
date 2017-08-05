package ouc.kill.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ouc.kill.bean.SessionBean;
import ouc.kill.util.ConfigUtil;
import ouc.kill.util.ProtostuffUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by huzhiming on 2017/7/28.
 * Description:
 */

@Component
public class RSessionDaoImpl
{
    @Autowired
    private JedisPool jedisPool;
    private static int expireTime;

    static
    {
        expireTime = Integer.parseInt(ConfigUtil.getInstance().getConstantVarByKey("token_valid_time"));
        expireTime = expireTime * 60 * 60;
    }

    //获取session
    public SessionBean getSession(String loginToken)
    {
        Jedis jedis = jedisPool.getResource();
        String key = "loginToken:" + loginToken;
        SessionBean session = null;
        byte[] b = jedis.get(key.getBytes());
        if (b != null)
            session = ProtostuffUtil.deserializer(b, SessionBean.class);
        jedis.close();
        return session;
    }

    //存放session
    public int setSession(SessionBean session, String loginToken)
    {
        Jedis jedis = jedisPool.getResource();
        String key = "loginToken:" + loginToken;
        byte[] bytes = ProtostuffUtil.serializer(session);
        jedis.setex(key.getBytes(), expireTime, bytes);
        jedis.close();
        return expireTime;
    }

    //删除session
    public void delSession(String loginToken)
    {
        Jedis jedis = jedisPool.getResource();
        String key = "loginToken:" + loginToken;
        jedis.del(key.getBytes());
        jedis.close();
    }
}
