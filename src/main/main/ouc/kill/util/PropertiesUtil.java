package ouc.kill.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 */
public class PropertiesUtil
{
    private PropertiesUtil()
    {
    }

    private static class PropertiesHandler
    {
        private static PropertiesUtil INSTANCE = new PropertiesUtil();
    }

    public static PropertiesUtil getInstance()
    {
        return PropertiesHandler.INSTANCE;
    }

    /**
     * 获取properties
     *
     * @param path 文件路径
     * @return
     */
    private Properties getProperties(String path)
    {
        Properties p = new Properties();
        try
        {
            InputStream stream = new FileInputStream(new File(path));
            p.load(stream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return p;
    }

    /**
     * 获取变量值
     *
     * @param key
     * @param path
     * @return
     */
    public String getPropertiesByKey(String key, String path)
    {
        Properties properties = getProperties(path);
        return properties.getProperty(key);
    }

}
