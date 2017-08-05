package ouc.kill.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by huzhiming on 2017/8/4.
 * Description:
 */
@Entity
@Table(name = "t_order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private Date createTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodsId", referencedColumnName = "goodsId")
    private Goods goods;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userToken", referencedColumnName = "userToken")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "killId", referencedColumnName = "killId")
    private Kill kill;

    public Order()
    {
    }

    public Order(int killId, String userToken, int goodsId)
    {
        this.goods = new Goods(goodsId);
        this.kill = new Kill(killId);
        this.user = new User(userToken);
        this.createTime = new Date();
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

    public Goods getGoods()
    {
        return goods;
    }

    public void setGoods(Goods goods)
    {
        this.goods = goods;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Kill getKill()
    {
        return kill;
    }

    public void setKill(Kill kill)
    {
        this.kill = kill;
    }
}
