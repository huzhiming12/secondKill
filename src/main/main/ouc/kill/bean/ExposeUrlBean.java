package ouc.kill.bean;

import java.util.Date;

/**
 * Created by huzhiming on 2017/7/30.
 * Description:
 */
public class ExposeUrlBean
{
    private boolean isBegin;
    private Date beginTime;
    private Date endTime;
    private Date now;
    private String md5;

    public boolean isBegin()
    {
        return isBegin;
    }

    public void setBegin(boolean begin)
    {
        isBegin = begin;
    }

    public Date getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getNow()
    {
        return now;
    }

    public void setNow(Date now)
    {
        this.now = now;
    }

    public String getMd5()
    {
        return md5;
    }

    public void setMd5(String md5)
    {
        this.md5 = md5;
    }
}
