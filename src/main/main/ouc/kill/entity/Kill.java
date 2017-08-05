package ouc.kill.entity;

import ouc.kill.bean.KillBean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by huzhiming on 2017/7/23.
 * Description:
 */
@Entity
@Table(name = "t_kill")
public class Kill
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    //秒杀的商品
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodsId", referencedColumnName = "goodsId")
    private Goods goods;
    //秒杀的状态
    private int state;

    public Kill()
    {
    }

    public Kill(int killId)
    {
        this.killId = killId;
    }

    public Kill(KillBean bean)
    {
        this.killId = bean.getKillId();
        this.killPrice = bean.getKillPrice();
        this.beginTime = bean.getBeginTime();
        this.endTime = bean.getEndTime();
        this.limitNum = bean.getLimitNum();
        this.selled = bean.getSelled();
        this.state = bean.getState();
        this.goods = new Goods(bean.getGoodsId());
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

    public Goods getGoods()
    {
        return goods;
    }

    public void setGoods(Goods goods)
    {
        this.goods = goods;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }
}
