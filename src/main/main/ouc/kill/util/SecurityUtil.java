package ouc.kill.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

import static org.springframework.util.DigestUtils.md5Digest;

/**
 * Created by huzhiming on 2017/7/27.
 * Description:
 */
public class SecurityUtil
{
    public static String md5(String content)
    {
        //盐值,用于混淆MD5
        String salt = "kfnwo090-25l43/,92830423nlnf";
        content += salt;
        String md5 = DigestUtils.md5DigestAsHex(content.getBytes());
        return md5;
    }

    //获取UUID 随机数
    public static String getRandomCode()
    {
        String random = UUID.randomUUID().toString().replace("-", "");
        return random;
    }

}
