package ouc.kill.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ouc.kill.anotation.DataSource;
import ouc.kill.dao.UserDao;
import ouc.kill.bean.Pager;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;

/**
 * Created by huzhiming on 2017/7/23.
 * Description:
 */
@Service
public class BgUserSer
{
    @Autowired
    private UserDao userDao;

    @DataSource(type = "slave")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResultBean loadUserList(Pager pager)
    {
        ResultBean result = new ResultBean();
        result.setStatus(Status.OK);
        result.setData(userDao.userList(pager));
        return result;
    }
}
