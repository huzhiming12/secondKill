package ouc.kill.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ouc.kill.base.BaseCtrl;
import ouc.kill.service.admin.BgUserSer;
import ouc.kill.bean.Pager;
import ouc.kill.bean.ResultBean;

/**
 * Created by huzhiming on 2017/7/23.
 * Description:
 */
@Controller
@RequestMapping("/admin/")
public class BgUserCtrl extends BaseCtrl
{
    @Autowired
    private BgUserSer bgUserSer;

    @RequestMapping("userManage")
    public String userList(Model model, Pager pager)
    {
        ResultBean result = bgUserSer.loadUserList(pager);
        model.addAttribute("result", result);
        return ADMIN_PREFIX + "user_list";
    }
}
