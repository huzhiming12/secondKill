package ouc.kill.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ouc.kill.anotation.DataSource;
import ouc.kill.dao.GoodsDao;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;
import ouc.kill.entity.Goods;
import ouc.kill.util.ConfigUtil;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 */
@Service(value = "bgGoodsSer")
public class BgGoodsSer
{
    @Autowired
    private GoodsDao goodsDao;

    public ResultBean uploadPic(MultipartFile file)
    {
        ResultBean result = new ResultBean();
        String path = BgGoodsSer.class.getClassLoader().getResource("").getPath();
        path = path.substring(0, path.indexOf("/WEB-INF/"));
        path += "/upload";
        String realName = file.getOriginalFilename();
        String filename = System.currentTimeMillis() + "_" + new Random().nextInt(10000)
                + realName.substring(realName.lastIndexOf("."));
        File target = new File(path, filename);
        if (!target.exists())
        {
            target.mkdirs();
        }
        try
        {
            file.transferTo(target);
            result.setStatus(200);
            String realPath = ConfigUtil.getInstance().getConstantVarByKey("image_server") + "/upload/" + filename;
            result.setData(realPath);
        } catch (IOException e)
        {
            result.setStatus(400);
            result.setMsg("文件上传失败");
            e.printStackTrace();
        }
        return result;
    }

    @DataSource()
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResultBean addGoods(Goods goods)
    {
        boolean res = goodsDao.addItem(goods);
        ResultBean result = new ResultBean();
        if (res)
        {
            result.setStatus(Status.OK);
            result.setMsg("商品添加成功!");
        } else
        {
            result.setStatus(Status.BADREQUEST);
            result.setMsg("商品添加失败!");
        }
        return result;
    }

    @DataSource(type = "slave")
    @Transactional()
    public ResultBean loadGoodsList()
    {
        ResultBean result = new ResultBean();
        result.setStatus(Status.OK);
        result.setData(goodsDao.loadGoods());
        return result;
    }

}
