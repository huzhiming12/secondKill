package ouc.kill.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;
import ouc.kill.bean.ResultBean;
import ouc.kill.bean.Status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by huzhiming on 2017/7/22.
 * Description:
 */
public class HttpUtil
{
    private static HttpUtil instance;

    private HttpUtil()
    {
    }

    public static HttpUtil getInstance()
    {
        if (instance == null)
        {
            synchronized (HttpUtil.class)
            {
                if (instance == null)
                    instance = new HttpUtil();
            }
        }
        return instance;
    }

    /**
     * 文件中转上传
     *
     * @param file
     * @param url
     * @return
     */
    public ResultBean uploadFile(MultipartFile file, String url)
    {
        ResultBean result = new ResultBean();
        CloseableHttpClient client = HttpClients.createDefault();
        try
        {
            HttpPost httpPost = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("file", file.getInputStream(), ContentType.MULTIPART_FORM_DATA, file.getOriginalFilename());
            builder.addTextBody("filename", file.getOriginalFilename());
            HttpEntity reqEntity = builder.build();
            httpPost.setEntity(reqEntity);

            CloseableHttpResponse httpResponse = client.execute(httpPost);
            HttpEntity resEntity = httpResponse.getEntity();
            if (resEntity != null)
            {
                result = JsonUtil.jsonToObject(EntityUtils.toString(resEntity), ResultBean.class);
            }
            httpResponse.close();
        } catch (IOException e)
        {
            result.setStatus(Status.BADREQUEST);
            result.setMsg("图片上传失败!");
            e.printStackTrace();
        } finally
        {
            try
            {
                client.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static ResultBean doPost(String path, Map<String, String> params)
    {
        ResultBean result = new ResultBean();
        CloseableHttpClient client = HttpClients.createDefault();
        try
        {
            HttpPost httpPost = new HttpPost(path);
            //构造参数
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            Iterator iterator = params.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
                pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
            //发送post请求
            CloseableHttpResponse httpResponse = client.execute(httpPost);
            HttpEntity resEntity = httpResponse.getEntity();
            if (resEntity != null)
            {
                result = JsonUtil.jsonToObject(EntityUtils.toString(resEntity), ResultBean.class);
            }
            httpResponse.close();
        } catch (IOException e)
        {
            result.setStatus(Status.BADREQUEST);
            result.setMsg("请求出错!");
            e.printStackTrace();
        } finally
        {
            try
            {
                client.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
}





















