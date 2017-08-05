package ouc.kill.util;

import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huzhiming on 2017/7/23.
 * Description:
 */
public class QueryHelper
{
    private String select; //select 语句
    private String from = ""; //from 语句
    private String where = ""; //where字句
    private String orderBy = ""; //order by

    //参数列表
    private List<Object> params = new ArrayList<Object>();


    public QueryHelper(Class cls)
    {
        select = "select new " + cls.getName() + " ( ";
    }

    //添加select字段
    public void addSelectItems(String[] items)
    {
        StringBuilder builder = new StringBuilder(select);
        for (String item : items)
        {
            builder.append(item + ",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(") ");
        select = builder.toString();
    }

    // 添加从哪些表查询
    public void addFrom(Class cls, String alias)
    {
        from = " from " + cls.getSimpleName() + " as " + alias;
    }

    //构造from字句
    public QueryHelper(Class[] cls, String[] alias)
    {
        StringBuilder builder = new StringBuilder(" from ");
        for (int i = 0; i < cls.length; i++)
        {
            builder.append(cls[i].getSimpleName() + " as " + alias[i] + " ,");
        }
        builder.deleteCharAt(builder.length() - 1);
        from = builder.toString();
    }

    //初始添加条件
    public void addCondition(String condition, Object param)
    {
        StringBuilder builder = new StringBuilder(" where " + condition);
        if (condition != null)
            params.add(param);
        where = builder.toString();
    }

    //添加多个条件
    public void addCondition(String condition, Object param, String andOrNot)
    {
        StringBuilder builder = new StringBuilder(where);
        builder.append(" " + andOrNot + " " + condition);
        params.add(param);
    }

    //排序
    public void addOrderBy(String property, String ascOrDesc)
    {
        StringBuilder builder = new StringBuilder();
        if ("".equals(orderBy))
            builder.append(" order by ");
        else
            builder.append(" , ");
        builder.append(property + " " + ascOrDesc);
    }

    public String createHQL()
    {
        String res = select + from + where + orderBy;
        System.out.println(res);
        return res;
    }

    //填充参数
    public Query querySetParams(Query query)
    {
        for (int i = 0; i < params.size(); i++)
            query = query.setParameter(i, params.get(i));
        return query;
    }

}
