package crawler.test;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpConfigTest {

    public static void main(String[] args) {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet("https://www.baidu.com");

        //配置请求信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(100)    //创建连接的最长时间，单位ms
                .setConnectionRequestTimeout(500)   //设置获取链接的最长时间，单位ms
                .setSocketTimeout(10*1000)  //设置数据传输的最长时间，单位ms
                .build();

        //给Get请求设置请求信息
        httpGet.setConfig(config);

        CloseableHttpResponse response = null;

        try {
            //使用HttpClient发起请求，获取response
            response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");
//              输出content的长度来表示程序执行成功
                System.out.println(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            关闭response和httpClient
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


