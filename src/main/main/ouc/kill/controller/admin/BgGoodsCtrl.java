package ouc.kill.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ouc.kill.base.BaseCtrl;
import ouc.kill.bean.ResultBean;
import ouc.kill.entity.Goods;
import ouc.kill.service.admin.BgGoodsSer;
import ouc.kill.util.ConfigUtil;
import ouc.kill.util.HttpUtil;
import ouc.kill.util.JsonUtil;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */

@Controller
@RequestMapping(value = "/admin/")
public class BgGoodsCtrl extends BaseCtrl
{
    @Autowired
    private BgGoodsSer bgGoodsSer;

    //商品列表
    @RequestMapping(value = "goodsManager")
    public String goodList(Model model)
    {
        ResultBean result = bgGoodsSer.loadGoodsList();
        model.addAttribute("result", result);
        return ADMIN_PREFIX + "goods_list";
    }

    //添加商品UI
    @RequestMapping(value = "addGoodsUI")
    public String addGoodsUI()
    {
        return ADMIN_PREFIX + "add_goods";
    }


    //图片上传
    @RequestMapping(value = "uploadPic")
    @ResponseBody
    public String uploadPic(MultipartFile file)
    {
        ResultBean result = bgGoodsSer.uploadPic(file);
        return JsonUtil.objectToJson(result);
    }

    //添加商品
    @RequestMapping(value = "addGoods")
    public String addGoods(MultipartFile file, Goods goods, Model model)
    {
        String uploadImagePath = ConfigUtil.getInstance().getConstantVarByKey("center_server") + "admin/uploadPic";
        ResultBean result = HttpUtil.getInstance().uploadFile(file, uploadImagePath);
        if (result.getStatus() == 200)
        {
            goods.setImgURL((String) result.getData());
            result = bgGoodsSer.addGoods(goods);
        }
        model.addAttribute("result", result);
        return ADMIN_PREFIX + "add_goods";
    }
}
