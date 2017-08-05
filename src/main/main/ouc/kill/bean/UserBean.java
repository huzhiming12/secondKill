package ouc.kill.bean;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */
public class UserBean
{
    private String userToken;
    private String username;
    private String mobilePhone;
    private String email;
    private String realName;
    private String address;
    private String password;

    public static String[] baseColumn = {"u.userToken", "u.username", "u.mobilePhone", "u.email",
            "u.realName", "u.address", "u.password"};

    public UserBean(String userToken, String username, String mobilePhone, String email, String realName, String address, String password)
    {
        this.userToken = userToken;
        this.username = username;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.realName = realName;
        this.address = address;
        this.password = password;
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

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
