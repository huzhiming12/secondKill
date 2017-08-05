package ouc.kill.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ouc.kill.base.BaseCtrl;
import ouc.kill.bean.Status;
import ouc.kill.entity.Kill;
import ouc.kill.service.admin.BgGoodsSer;
import ouc.kill.service.admin.BgKillSer;
import ouc.kill.bean.ResultBean;
import ouc.kill.util.JsonUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huzhiming on 2017/7/23.
 * Description:
 */

@Controller
@RequestMapping("/admin/")
public class BgKillCtr extends BaseCtrl
{
    @Autowired
    private BgGoodsSer bgGoodsSer;
    @Autowired
    private BgKillSer bgKillSer;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping("killManage")
    public String killManage(Model model)
    {
        model.addAttribute("result", bgKillSer.loadKillList());
        return ADMIN_PREFIX + "kill_list";
    }

    @RequestMapping("addKillUI")
    public String addKillUI(Model model)
    {
        ResultBean result = bgGoodsSer.loadGoodsList();
        model.addAttribute("result", result);
        return ADMIN_PREFIX + "add_kill";
    }

    @RequestMapping("addKill")
    public String addKill(Model model, Kill kill)
    {
        System.out.println(kill.toString());
        model.addAttribute("addResult", bgKillSer.addKill(kill));
        model.addAttribute("result", bgGoodsSer.loadGoodsList());
        return ADMIN_PREFIX + "add_kill";
    }

    @RequestMapping("delKill")
    @ResponseBody
    public String delKill(int killId)
    {
        bgKillSer.updateKill(killId);
        ResultBean result = new ResultBean();
        result.setStatus(Status.OK);
        result.setMsg("更新成功!");
        return JsonUtil.objectToJson(result);
    }

}

