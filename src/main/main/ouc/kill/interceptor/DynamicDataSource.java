package ouc.kill.interceptor;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by huzhiming on 2017/7/30.
 * Description: 动态切换数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource
{
    @Override
    protected Object determineCurrentLookupKey()
    {
        Object key = DynamicDataSourceHolder.getDataSourceKey();
        if (key != null)
            System.out.println("choose dataSource:" + key.toString());
        else
            System.out.println("null");
        return key;
    }
}
