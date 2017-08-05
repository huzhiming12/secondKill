package ouc.kill.util;

import com.google.gson.Gson;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
public class JsonUtil
{
    public static Gson gson = new Gson();

    public static String objectToJson(Object object)
    {
        return gson.toJson(object);
    }

    public static <T> T jsonToObject(String jsonStr, Class<T> type)
    {
        T result = gson.fromJson(jsonStr, type);
        return result;
    }

}
