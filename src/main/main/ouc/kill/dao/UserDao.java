package ouc.kill.dao;

import ouc.kill.base.BaseDao;
import ouc.kill.bean.UserBean;
import ouc.kill.bean.Pager;

import java.util.List;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
public interface UserDao extends BaseDao<UserBean>
{
    UserBean findUserByUserName(String username);

    List<UserBean> userList(Pager pager);

    UserBean findUserByUserToken(String token);
}
