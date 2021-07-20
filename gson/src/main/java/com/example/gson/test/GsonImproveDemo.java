package com.example.gson.test;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import sun.reflect.generics.tree.TypeTree;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 完善demo
 * @Author lktbz
 * @Date 2021/07/20
 */
public class GsonImproveDemo {
    @Test
    public void setToJson(){
        Set<String> userSet = new HashSet<String>();
        userSet.add("Alex");
        userSet.add("Brian");
        userSet.add("Charles");
        Gson gson=new Gson();
        String s = gson.toJson(userSet);
        System.out.println(s);
    }
    @Test
    public void JsonToset(){
        String jsonString = "['Alex','Brian','Charles','Alex']";
        Gson gson=new Gson();
        Type type = new TypeToken<HashSet<String>>() {
        }.getType();
        Set<String> userSet = gson.fromJson(jsonString,type);
        System.out.println(userSet);
    }

    /**
     *  没有数据头，纯数据解析
     */
    @Test
    public void JsonInAcationDemo01(){
        String json="[\n" +
                "  {\n" +
                "    \"name\": \"zhangsan\",\n" +
                "    \"age\": \"10\",\n" +
                "    \"phone\": \"11111\",\n" +
                "    \"email\": \"11111@11.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"lisi\",\n" +
                "    \"age\": \"20\",\n" +
                "    \"phone\": \"22222\",\n" +
                "    \"email\": \"22222@22.com\"\n" +
                "  },\n" +
                "]";
        JsonParser parser=new JsonParser();
        JsonArray asJsonArray = parser.parse(json).getAsJsonArray();
        Gson gson=new Gson();
        List<UserBean> beanList=new ArrayList<>();
        for (JsonElement user:asJsonArray) {
            UserBean userBean = gson.fromJson(user, UserBean.class);
            beanList.add(userBean);
        }
        beanList.forEach(System.out::println);
    }

    /**
     *  根据接送数据全部解析出来
     */
    @Test
    public void JsonInAcationDemo02(){
        String json="{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"OK\",\n" +
                "  \"muser\": [\n" +
                "    {\n" +
                "      \"name\": \"zhangsan\",\n" +
                "      \"age\": \"10\",\n" +
                "      \"phone\": \"11111\",\n" +
                "      \"email\": \"11111@11.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"lisi\",\n" +
                "      \"age\": \"20\",\n" +
                "      \"phone\": \"22222\",\n" +
                "      \"email\": \"22222@22.com\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        ResultBean resultBean = new Gson().fromJson(json, ResultBean.class);
        for (UserBean userBean : resultBean.getMuser()) {
            System.out.println(userBean);
        }

    }

    /**
     *  只想解析部分数据 比如数据中的数据
     */
    @Test
    public void JsonInAcationDemo03() {
        String json = "{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"OK\",\n" +
                "  \"muser\": [\n" +
                "    {\n" +
                "      \"name\": \"zhangsan\",\n" +
                "      \"age\": \"10\",\n" +
                "      \"phone\": \"11111\",\n" +
                "      \"email\": \"11111@11.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"lisi\",\n" +
                "      \"age\": \"20\",\n" +
                "      \"phone\": \"22222\",\n" +
                "      \"email\": \"22222@22.com\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
        if (asJsonObject.isJsonObject()) {
            JsonArray muser = asJsonObject.getAsJsonArray("muser");
            muser.forEach(jsonElement -> {
                UserBean userBean = new Gson().fromJson(jsonElement, new TypeToken<UserBean>() {
                }.getType());
                System.out.println("解析出的数据为：" + userBean);
            });
        }
    }

    /**
     *  根据响应的信息
     */
        @Test
        public void JsonInAcationDemo04(){
            String json = "{\n" +
                    "  \"code\": 200,\n" +
                    "  \"msg\": \"OK\",\n" +
                    "  \"muser\": [\n" +
                    "    {\n" +
                    "      \"name\": \"zhangsan\",\n" +
                    "      \"age\": \"10\",\n" +
                    "      \"phone\": \"11111\",\n" +
                    "      \"email\": \"11111@11.com\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"name\": \"lisi\",\n" +
                    "      \"age\": \"20\",\n" +
                    "      \"phone\": \"22222\",\n" +
                    "      \"email\": \"22222@22.com\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";
            JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
            if(asJsonObject.get("code").getAsInt()==200){
                if (asJsonObject.isJsonObject()) {
                    JsonArray muser = asJsonObject.getAsJsonArray("muser");
                    muser.forEach(jsonElement -> {
                        UserBean userBean = new Gson().fromJson(jsonElement, new TypeToken<UserBean>() {
                        }.getType());
                        System.out.println("解析出的数据为：" + userBean);
                    });
                }
            }else {
                int code = asJsonObject.get("code").getAsInt();
                String msg = asJsonObject.get("msg").getAsString();
                ResultBean resultBean=new ResultBean();
                resultBean.setCode(code);
                resultBean.setMsg(msg);
                System.out.println("解析出的对象为:"+resultBean);
            }
        }
    }

