package ouc.kill.bean;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
public class GoodsBean
{
    private int goodsId;
    private String goodsName;
    private float goodsPrice;
    private String imgURL;
    private String description;

    public static String[] baseColumns = {"g.goodsId", "g.goodsName", "g.goodsPrice",
            "g.imgURL", "g.description"};

    public GoodsBean(int goodsId, String goodsName, float goodsPrice, String imgURL, String description)
    {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.imgURL = imgURL;
        this.description = description;
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
