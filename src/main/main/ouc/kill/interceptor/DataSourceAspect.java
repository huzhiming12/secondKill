package ouc.kill.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import ouc.kill.anotation.DataSource;

/**
 * Created by huzhiming on 2017/7/30.
 * Description:
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered
{
    private int order;

    @Value("20")
    public void setOrder(int order)
    {
        this.order = order;
    }

    @Override
    public int getOrder()
    {
        return 0;
    }

    @Pointcut("@annotation(ouc.kill.anotation.DataSource)")
    private void init()
    {
        System.out.println("init(  )");
    }

    @Before("@annotation(source)")
    private void changeDataSource(DataSource source)
    {
        if (source.type().equals("slave"))
            DynamicDataSourceHolder.markSlave();
        else
            DynamicDataSourceHolder.markMaster();
    }
}
