package ouc.kill.dao.daoimpl;

import org.springframework.stereotype.Component;
import ouc.kill.base.BaseDaoImpl;
import ouc.kill.dao.UserDao;
import ouc.kill.bean.UserBean;
import ouc.kill.entity.User;
import ouc.kill.bean.Pager;
import ouc.kill.util.QueryHelper;

import java.util.List;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserBean> implements UserDao
{
    public QueryHelper createBaseHelper()
    {
        QueryHelper queryHelper = new QueryHelper(UserBean.class);
        queryHelper.addSelectItems(UserBean.baseColumn);
        queryHelper.addFrom(User.class, "u");
        return queryHelper;
    }

    public UserBean findUserByUserName(String username)
    {
        QueryHelper queryHelper = createBaseHelper();
        queryHelper.addCondition("u.username =?", username);
        List<UserBean> list = loadItems(queryHelper);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }

    public List<UserBean> userList(Pager pager)
    {
        QueryHelper queryHelper = createBaseHelper();
        List<UserBean> res = loadItems(queryHelper);
        return res;
    }

    @Override
    public UserBean findUserByUserToken(String token)
    {
        QueryHelper queryHelper = createBaseHelper();
        queryHelper.addCondition("u.userToken=?", token);
        List<UserBean> list = loadItems(queryHelper);
        if (list != null && list.size() > 0)
            return list.get(0);
        return null;
    }
}
