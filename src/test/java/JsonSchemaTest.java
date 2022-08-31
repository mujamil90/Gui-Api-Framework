
import static io.restassured.RestAssured.given;

import io.restassured.module.jsv.JsonSchemaValidator;
import com.ui.api.qagenes.util.api.JsonSchemaConfigurations;
import org.testng.annotations.Test;

import java.util.Map;

public class JsonSchemaTest {


  // @Test
   public void testJsonSchema(){

       given().
              baseUri("https://api.picsart.com/").
               when().
               get("localizations/en/messages?project=reusable_components,photo_editor")
               .then().assertThat()
               .body(JsonSchemaValidator.
                       matchesJsonSchemaInClasspath("testdata/ReusableComponents.json").using(JsonSchemaConfigurations.getJsonSchemaConfigs()));


    }


    @Test
    public void testToken(){
          String requestBody = "{\"username\":\"mujamil87@gmail.com\",\"password\":\"Picsart@123\",\"recaptchaToken\":\"03ANYolquiNa4ymVeXU9QeFUh5UVZiz-gUPQWgbb2ClWfR7V7IEftpG_Z6eFC8FNVCzjb98XFlOLfAGLmtQogN0XabOGX_RxyMXnRoauesUcgljxXBznWNCG8tdEbWIhxwdOgYDzvC3O5HxwNFGoxteW1ONuz-EpOPfCjUD2_oz4meBWpeG5pKgb0nLz2JXmTZ28Ou8khDpwuyq6sgPzV0lrxNv1bQs0mrp23CAveCYRCN3IQuwLgceKYhOZqU7aeh09JW4vr-3iKxnDKnHnSQgU9DllWYHOQENl-wKoPRy8zY09KFClwFjO1zhc47Gs79L2-zuh3NQgFSop5VfhlIP-2i5xlR0kY7kJs7B1evE8eBPMpdmkrL3cJTorHGdKdOrgsjUbzA2MtgL5XxpW_Lff2sChcpfSu0sIHJVxOdhUdn5zgEmB-am_4VO0s9ZocZVvzQXEmJflUGApC5qIwdA3LvdVj3yswrzdJ0090-LV0Qug5E6-qt1WNcUrEg22vHeDJ2Owil_fFShJYc-1IVPRSIjRCNatOlm-o3tkzPDT4_Jug3ja6KhPUko5jaGPDZLc16_iZU6zKiCqHd2UWb60S6pipHx8psnc-E__2viOiONK48rBVNUoYeBSeElEFQ2ykuT4z7arqtyy1wGVbgKdqn_1SAIsIK2fDzFO4JBdFlASKB0nZivdNbzyYMy7bos2mMlLFFKmB9Vpm8fCRcjgwlJvpxx0-uJ9uNNNHxC5wq6cIbRtl7c4fGKuIaW_awKw3IygfOG6Umco0RVQ_8Z9JTWolRD1jcslrpfd_8YbonU1GMY8ihnMXGjWlnFxW0b1Q6UiKvSjbrTCAISAPxWKz3aP927dSDLtIPHvZJWGJUDUowg-A4LZjUJFLN6DVo8P6XFOUm9THdUVmy0BGr7fdgxa_qpRlXoOnxbjcfitwbjvnlIk0fJqtf-EhZwY0ZBQUEoLGwfrrgyxjlxBkWHOQ2h0Swpj2KTQ5o44Snwg1uj4drH0hz5rNzC1sptn-C67smq5NcC0WfCxZTXPvLrHcQ36GejmBRw7dIzx-h-xh7LHSbie992zSwrO99QVOUKVDI8zxkGDIYLNHKlXLuGpXoKu8pUNf0tbH7XAL6R5ZrZOa19BQZBHgEwLCkg8TTqYJD_rTEAIMLp6y8G1sg9onHPiVABhJTShKy-h3OjAeM09jRcqG5JtXkNRzc4Ma-b54vwStQJUpwba3VIjKh8qViHT6cRWB1QXaifIOB2oRt6eUpYqQi8thxamZsiBuZ5vI1yyFsnshi6T48JQ0zI_iKyqVo44Vs6Gb69xWpMZ0HLYQ85iXb8uleCHFf0A0LESUDnvwj0P7ll_Hpi1AtNz_Hw1vccbf9zA\",\"isLocal\":false}";
       Map<String, String> cookies = given().
                baseUri("https://api.picsart.com").
                header("accept", "*/*").
                header("accept-encoding", "gzip, deflate, br").
                header("accept-language", "en-GB,en-US;q=0.9,en;q=0.8").
              //  header("content-length", "1475").
                header("content-type", "application/json").
                header("deviceid","a.c.l7c8t9x8.287a0a12-ac67-4c97-99d9-ae350d4bcfd1").
                    and().
        body(requestBody).
               // queryParam("deviceid", "null").
                when().log().all().
                post("/user-account/signin.json").
              then().extract().cookies();
        System.out.println("size of cookies : "+ cookies.size());
        for (var entry : cookies.entrySet()) {
            System.out.println("Cookies are : "+entry.getKey() + "/" + entry.getValue());
        }
//                //log().all().assertThat().statusCode(200);
               // .body(JsonSchemaValidator.
                 //       matchesJsonSchemaInClasspath("ReusableComponents.json").using(JsonSchemaConfigurations.getJsonSchemaConfigs()));


    }
}
