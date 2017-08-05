package ouc.kill.entity;

import javax.persistence.*;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */

@Entity
@Table(name = "t_goods")
public class Goods
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodsId;

    @Column(length = 256)
    private String goodsName;

    private float goodsPrice;

    @Column(length = 128)
    private String imgURL;

    private String description;

    public Goods()
    {
    }

    public Goods(int goodsId)
    {
        this.goodsId = goodsId;
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
}
