package ouc.kill.util;


import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import java.util.HashMap;

/**
 * Created by huzhiming on 2017/7/28.
 * Description:
 */
public class ProtostuffUtil
{
    private static HashMap<Class, RuntimeSchema> schemaCache = new HashMap<Class, RuntimeSchema>();

    //获取schema
    private static <T> RuntimeSchema<T> getSchema(Class<T> cls)
    {
        RuntimeSchema<T> schema = schemaCache.get(cls);
        if (schema == null)
        {
            schema = RuntimeSchema.createFrom(cls);
            if (schema != null)
                schemaCache.put(cls, schema);
        }
        return schema;
    }

    //序列化
    public static <T> byte[] serializer(T obj)
    {
        RuntimeSchema<T> schema = getSchema((Class<T>) obj.getClass());
        byte[] data = ProtostuffIOUtil.toByteArray(obj, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        return data;
    }

    //反序列化
    public static <T> T deserializer(byte[] data, Class<T> cls)
    {
        RuntimeSchema<T> schema = getSchema(cls);
        T obj = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(data, obj, schema);
        return obj;
    }
}
