package ouc.kill.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ouc.kill.base.BaseCtrl;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
@Controller
@RequestMapping(value = "/admin/")
public class IndexCtrl extends BaseCtrl
{
    @RequestMapping(value = "index")
    public String index()
    {
        return ADMIN_PREFIX + "index";
    }
}
