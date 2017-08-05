package ouc.kill.bean;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
public interface Status
{
    public final static int OK = 200;
    //客户端请求错误
    public final static int BADREQUEST = 400;
    //服务器内部错误
    public final static int INTERNAL_ERROR = 500;
}
