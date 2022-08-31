package com.ui.api.qagenes.util.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.ui.api.qagenes.enums.Browsers;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.ui.api.qagenes.drivers.DriverManager.createDriver;
import static com.ui.api.qagenes.drivers.DriverManager.getDriver;

public class CollectLoginCookies {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        try {
            // Create a local instance of cookie store
            CookieStore cookieStore = new BasicCookieStore();

            // Create local HTTP context
            HttpClientContext localContext = HttpClientContext.create();
            // Bind custom cookie store to the local context
            localContext.setCookieStore(cookieStore);

            HttpGet httpget = new HttpGet("https://api.picsart.com/user-account/signin.json");
            System.out.println("Executing request " + httpget.getRequestLine());

            httpclient.start();

            // Pass local context as a parameter
            Future<HttpResponse> future = httpclient.execute(httpget, localContext, null);

            // Please note that it may be unsafe to access HttpContext instance
            // while the request is still being executed

            System.out.println("Shutting down");

            HttpPost httpPost = new HttpPost("https://picsart.com/explore");
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("email", "mujamil87@gmail.com"));
            params.add(new BasicNameValuePair("password", "Picsart@123"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            future = httpclient.execute(httpPost,localContext,null);
            HttpResponse response = future.get();
            System.out.println("Response: " + response.getStatusLine());
            List<Cookie> cookies = cookieStore.getCookies();
            cookies = cookieStore.getCookies();


            //System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
           // WebDriver driver = new ChromeDriver();
            createDriver (Browsers.CHROME);
            getDriver().navigate().to("https://picsart.com/explore/");

            org.openqa.selenium.Cookie c;
            for (int i = 0; i < cookies.size(); i++) {
                System.out.println("Local cookie: " + cookies.get(i));
                c = new org.openqa.selenium.Cookie(cookies.get(i).getName(),cookies.get(i).getValue());
                getDriver().manage().addCookie(c);
            }
            getDriver().navigate().to("https://picsart.com/explore/");


        } finally {
            httpclient.close();
        }

    }
}
