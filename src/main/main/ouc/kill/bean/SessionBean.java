package ouc.kill.bean;

/**
 * Created by huzhiming on 2017/7/28.
 * Description:
 */
public class SessionBean
{
    private String userToken;
    private String username;
    private int userType;

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

    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }
}
