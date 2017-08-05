package ouc.kill.util;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 */
public class ConfigUtil
{
    private static String constantFilePath;

    private ConfigUtil()
    {
        constantFilePath = ConfigUtil.class.getClassLoader().getResource("").getPath() + "config.properties";
        //System.out.println(constantFilePath);
    }

    private static class ConstantUtilHandler
    {
        private static ConfigUtil INSTANCE = new ConfigUtil();
    }

    public static ConfigUtil getInstance()
    {
        return ConstantUtilHandler.INSTANCE;
    }

    /**
     * 获取Constant文件中变量值
     *
     * @param key
     * @return
     */
    public String getConstantVarByKey(String key)
    {
        String value = PropertiesUtil.getInstance().getPropertiesByKey(key, constantFilePath);
        return value;
    }
}
