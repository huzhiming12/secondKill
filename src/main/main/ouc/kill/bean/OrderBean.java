package ouc.kill.bean;

import java.util.Date;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
public class OrderBean
{
    private int orderId;
    private Date createTime;

    private int killId;
    private float killPrice;

    private int goodsId;
    private float goodsPrice;
    private String goodsName;
    private String imgURL;

    private String userToken;
    private String username;

    public static String[] baseColumn = {"o.orderId", "o.createTime", "o.kill.killId",
            "o.kill.killPrice", "o.goods.goodsId", "o.goods.goodsPrice", "o.goods.goodsName",
            "o.goods.imgURL", "o.user.userToken", "o.user.username"};

    public OrderBean(int orderId, Date createTime, int killId, float killPrice, int goodsId, float goodsPrice, String goodsName, String imgURL, String userToken, String username)
    {
        this.orderId = orderId;
        this.createTime = createTime;
        this.killId = killId;
        this.killPrice = killPrice;
        this.goodsId = goodsId;
        this.goodsPrice = goodsPrice;
        this.goodsName = goodsName;
        this.imgURL = imgURL;
        this.userToken = userToken;
        this.username = username;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public int getKillId()
    {
        return killId;
    }

    public void setKillId(int killId)
    {
        this.killId = killId;
    }

    public float getKillPrice()
    {
        return killPrice;
    }

    public void setKillPrice(float killPrice)
    {
        this.killPrice = killPrice;
    }

    public int getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(int goodsId)
    {
        this.goodsId = goodsId;
    }

    public float getGoodsPrice()
    {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getImgURL()
    {
        return imgURL;
    }

    public void setImgURL(String imgURL)
    {
        this.imgURL = imgURL;
    }

    public String getUserToken()
    {
        return userToken;
    }

    public void setUserToken(String userToken)
    {
        this.userToken = userToken;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public static String[] getBaseColumn()
    {
        return baseColumn;
    }

    public static void setBaseColumn(String[] baseColumn)
    {
        OrderBean.baseColumn = baseColumn;
    }
}
