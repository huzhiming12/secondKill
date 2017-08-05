package ouc.kill.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by huzhiming on 2017/7/21.
 * Description:
 */

@Entity
@Table(name = "t_user")
public class User
{
    @Id
    @Column(length = 128, unique = true, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String userToken;

    @Column(length = 32, unique = true, nullable = false)
    private String username;

    @Column(length = 16)
    private String mobilePhone;

    @Column(length = 32)
    private String email;

    @Column(length = 32)
    private String realName;

    @Column(length = 256)
    private String address;

    @Column(length = 128)
    private String password;

    public User()
    {
    }

    public User(String userToken)
    {
        this.userToken = userToken;
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
