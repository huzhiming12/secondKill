package ouc.kill.base;

import ouc.kill.util.QueryHelper;

import java.util.List;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
public interface BaseDao<T>
{
    boolean addItem(Object item);

    List<T> loadItems(QueryHelper queryHelper);

    void update(Object item);
}
