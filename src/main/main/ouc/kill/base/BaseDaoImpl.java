package ouc.kill.base;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ouc.kill.util.QueryHelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */

public abstract class BaseDaoImpl<T>
{
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    //添加数据
    public boolean addItem(Object item)
    {
        Serializable serializable = getSession().save(item);
        System.out.println(serializable);
        if (serializable != null)
            return true;
        return false;
    }

    // 查询列表
    public List<T> loadItems(QueryHelper queryHelper)
    {
        Query query = getSession().createQuery(queryHelper.createHQL());
        query = queryHelper.querySetParams(query);
        return query.list();
    }

    public void update(Object item)
    {
        getSession().update(item);
    }

}
