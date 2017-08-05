package ouc.kill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ouc.kill.base.BaseCtrl;
import ouc.kill.bean.*;
import ouc.kill.service.KillSer;
import ouc.kill.service.UserSer;
import ouc.kill.util.JsonUtil;
import ouc.kill.util.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by huzhiming on 2017/7/24.
 * Description:
 */

@Controller
public class KillCtrl extends BaseCtrl
{
    @Autowired
    private KillSer killSer;
    @Autowired
    private UserSer userSer;

    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model)
    {
        SessionBean session = userSer.getSession(request);
        model.addAttribute("killList", killSer.loadKillList());
        model.addAttribute("session", session);
        return USER_PREFIX + "index";
    }

    @RequestMapping("detail")
    public String detail(int killId, Model model, HttpServletResponse response)
    {
        model.addAttribute("kill", killSer.loadKillById(killId));
        return USER_PREFIX + "detail";
    }

    //暴露秒杀接口
    @RequestMapping(value = "exposeUrl", method = RequestMethod.POST)
    @ResponseBody
    public String exposeUrl(int killId)
    {
        KillBean bean = killSer.loadKillById(killId);
        Date now = new Date();
        ExposeUrlBean urlBean = new ExposeUrlBean();
        if (now.getTime() > bean.getBeginTime().getTime())
        {
            urlBean.setBegin(true);
            urlBean.setNow(new Date());
            urlBean.setBeginTime(bean.getBeginTime());
            urlBean.setEndTime(bean.getEndTime());
            urlBean.setMd5(SecurityUtil.md5(killId + ""));
        } else
            urlBean.setBegin(false);
        return JsonUtil.objectToJson(urlBean);
    }

    //秒杀接口
    @RequestMapping(value = "kill", method = RequestMethod.POST)
    @ResponseBody
    public String kill(int killId, String md5, HttpServletRequest request)
    {
        ResultBean result = new ResultBean();
        if (md5.equals(SecurityUtil.md5(killId + "")))
        {
            KillBean bean = killSer.loadKillById(killId);
            Date now = new Date();
            if (bean.getBeginTime().getTime() > now.getTime())
            {
                result.setStatus(Status.BADREQUEST);
                result.setMsg("秒杀未开始");
            } else if (bean.getEndTime().getTime() < now.getTime())
            {
                result.setStatus(Status.BADREQUEST);
                result.setMsg("秒杀已结束");
            } else
            {
                //执行秒杀逻辑
                result = killSer.kill(killId, request);
            }
        } else
        {
            result.setStatus(Status.BADREQUEST);
            result.setMsg("链接错误!");
        }
        return JsonUtil.objectToJson(result);
    }
}
