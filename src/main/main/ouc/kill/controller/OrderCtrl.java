package ouc.kill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ouc.kill.base.BaseCtrl;
import ouc.kill.service.OrderSer;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
@Controller
public class OrderCtrl extends BaseCtrl
{
    @Autowired
    private OrderSer orderSer;

    @RequestMapping("orderList")
    public String orderList(HttpServletRequest request, Model model)
    {
        model.addAttribute("orders", orderSer.loadOrders(request));
        return USER_PREFIX + "order_list";
    }
}
