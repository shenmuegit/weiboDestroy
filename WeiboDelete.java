package com.mmdr.house;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import okhttp3.Headers;

public class WeiboDelete {

    private static final HashMap<String,String> header = new HashMap<>() {{
        put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:103.0) Gecko/20100101 Firefox/103.0");
        put("Accept","application/json, text/plain, */*");
        put("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        put("X-Requested-With","XMLHttpRequest");
        put("client-version","v2.35.11");
        put("server-version","v2022.09.29.1");
        put("X-XSRF-TOKEN","_cwoBo3800jJlmR3ESsKAF19");
        put("traceparent","00-b0214f9bede2f23a87cc52e6347d7bc4-69408dbb311f9247-00");
        put("Referer","https://weibo.com/u/1230024682?tabtype=feed");
        put("Cookie","PC_TOKEN=9a7a934f51; SUB=_2A25OOBGJDeRhGedM6FIR8irKwz6IHXVtTARBrDV8PUNbmtAKLVX-kW9NWbrG1A4_M6mwm3rO_C7SOouAO2TKRGji; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWDWk2Ei.FFE5bKHJX6P4445JpX5KzhUgL.Fo2Ee057eoBc1hz2dJLoI7U_dgxEwGyR; XSRF-TOKEN=_cwoBo3800jJlmR3ESsKAF19; WBPSESS=M9WsNrPrWBca_ot7PafULd1dC8grSsAMy_OK7HbTCu6UcHVvlhQ26Ixipf6q0xxuyOiKHBbMIvHQEDQ4ICRv7Ir3p4OzVX8VZwfxAzzY_KWGLR9Y2miwm22gK4o1bN8et05j-xqcFw6tp4CWqqIpMQ==; ALF=1696437593; SSOLoginState=1664901593");
        put("Sec-Fetch-Dest","empty");
        put("Sec-Fetch-Mode","cors");
        put("Sec-Fetch-Site","same-origin");
        put("Host","weibo.com");
    }};

    private static final HashMap<String,String> tmp = new HashMap<>() {{
        put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:103.0) Gecko/20100101 Firefox/103.0");
        put("Accept","application/json, text/plain, */*");
        put("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        put("X-Requested-With","XMLHttpRequest");
        put("client-version","v2.35.11");
        put("server-version","v2022.09.29.1");
        put("X-XSRF-TOKEN","_cwoBo3800jJlmR3ESsKAF19");
        put("traceparent","00-b0214f9bede2f23a87cc52e6347d7bc4-69408dbb311f9247-00");
        put("Referer","https://weibo.com/u/1230024682?tabtype=feed");
        put("Cookie","PC_TOKEN=9a7a934f51; SUB=_2A25OOBGJDeRhGedM6FIR8irKwz6IHXVtTARBrDV8PUNbmtAKLVX-kW9NWbrG1A4_M6mwm3rO_C7SOouAO2TKRGji; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9WWDWk2Ei.FFE5bKHJX6P4445JpX5KzhUgL.Fo2Ee057eoBc1hz2dJLoI7U_dgxEwGyR; XSRF-TOKEN=_cwoBo3800jJlmR3ESsKAF19; WBPSESS=M9WsNrPrWBca_ot7PafULd1dC8grSsAMy_OK7HbTCu6UcHVvlhQ26Ixipf6q0xxuyOiKHBbMIvHQEDQ4ICRv7Ir3p4OzVX8VZwfxAzzY_KWGLR9Y2miwm22gK4o1bN8et05j-xqcFw6tp4CWqqIpMQ==; ALF=1696437593; SSOLoginState=1664901593");
        put("Sec-Fetch-Dest","empty");
        put("Sec-Fetch-Mode","cors");
        put("Sec-Fetch-Site","same-origin");
        put("Host","weibo.com");
        put("Content-Type","application/json;charset=utf-8");
        put("TE","trailers");
        put("Origin","https://weibo.com");
        put("Content-Length","25");
    }};

    public static void main(String[] args) throws InterruptedException {
        String url = "https://weibo.com/ajax/statuses/mymblog?uid=1230024682&feature=0&since_id=3881508756460592&page=1";
        for (int i = 1; i <= 75; i++) {
            String res = OkHttpUtil.get(url, Headers.of(header));
            JSONObject resJson = JSONObject.parseObject(res);
            if(resJson.getInteger("ok") == 1){
                JSONArray array = resJson.getJSONObject("data").getJSONArray("list");
                for (int j = 0; j < array.size(); j++) {
                    JSONObject ob = array.getJSONObject(j);
                    String id = ob.getString("idstr");
                    JSONObject param = new JSONObject();
                    param.put("id",id);
                    String deleteRes = OkHttpUtil.postByJson("https://weibo.com/ajax/statuses/destroy",param.toJSONString(),Headers.of(tmp));
                    System.out.println(deleteRes);
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(300));
                }
            }else{
                System.out.println("GG");
                return;
            }
        }
        System.out.println("success");
    }
}
