package ouc.center.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;
import ouc.kill.util.JsonUtil;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 * 中心服务器处理秒杀逻辑
 */

@Controller
@RequestMapping(value = "center/")
public class CenterCtrl
{
    @Autowired
    private CenterSer centerSer;

    @RequestMapping(value = "kill", method = RequestMethod.POST)
    @ResponseBody
    public String kill(int killId, String userToken)
    {
        ResultBean result = centerSer.kill(killId, userToken);
        return JsonUtil.objectToJson(result);
    }
}
