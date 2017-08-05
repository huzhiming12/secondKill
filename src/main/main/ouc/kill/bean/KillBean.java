package ouc.kill.bean;

import java.util.Date;

/**
 * Created by huzhiming on 2017/7/23.
 * Description:
 */
public class KillBean
{
    private int killId;
    //秒杀价格
    private float killPrice;
    //秒杀开始的时间
    private Date beginTime;
    //秒杀结束时间
    private Date endTime;
    //限制的数量
    private int limitNum;
    //已经卖出的数量
    private int selled;
    //秒杀的状态
    private int state;
    //商品属性
    private int goodsId;
    private String goodsName;
    private float goodsPrice;
    private String imgURL;
    private String description;

    public static String[] baseColumns = {"k.killId", "k.killPrice", "k.beginTime", "k.endTime", "k.limitNum", "k.selled",
            "k.state", "k.goods.goodsId", "k.goods.goodsName", "k.goods.goodsPrice", "k.goods.imgURL", "k.goods.description"};

    public KillBean(int killId, float killPrice, Date beginTime, Date endTime, int limitNum, int selled, int state, int goodsId, String goodsName, float goodsPrice, String imgURL, String description)
    {
        this.killId = killId;
        this.killPrice = killPrice;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.limitNum = limitNum;
        this.selled = selled;
        this.state = state;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.imgURL = imgURL;
        this.description = description;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
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

    public Date getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public int getLimitNum()
    {
        return limitNum;
    }

    public void setLimitNum(int limitNum)
    {
        this.limitNum = limitNum;
    }

    public int getSelled()
    {
        return selled;
    }

    public void setSelled(int selled)
    {
        this.selled = selled;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public int getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(int goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public float getGoodsPrice()
    {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public String getImgURL()
    {
        return imgURL;
    }

    public void setImgURL(String imgURL)
    {
        this.imgURL = imgURL;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public static String[] getBaseColumns()
    {
        return baseColumns;
    }

    public static void setBaseColumns(String[] baseColumns)
    {
        KillBean.baseColumns = baseColumns;
    }
}
