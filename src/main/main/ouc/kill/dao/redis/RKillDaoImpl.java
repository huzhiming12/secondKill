package ouc.kill.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ouc.kill.bean.KillBean;
import ouc.kill.util.ProtostuffUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by huzhiming on 2017/7/28.
 * Description:
 */

@Component
public class RKillDaoImpl
{
    @Autowired
    private JedisPool jedisPool;
    private static int expireTime = 60 * 60 * 24 * 2;
    private static String prefix = "kill:";

    public KillBean getKillById(int killId)
    {
        Jedis jedis = jedisPool.getResource();
        String key = prefix + killId;
        KillBean kill = null;
        byte[] bytes = jedis.get(key.getBytes());
        if (bytes != null)
            kill = ProtostuffUtil.deserializer(bytes, KillBean.class);
        jedis.close();
        return kill;
    }

    public void setKill(KillBean kill)
    {
        Jedis jedis = jedisPool.getResource();
        String key = prefix + kill.getKillId();
        byte[] data = ProtostuffUtil.serializer(kill);
        jedis.setex(key.getBytes(), expireTime, data);
        jedis.close();
    }
}
