package com.example.springboot.jackson;

import com.example.springboot.doamin.Car;
import com.example.springboot.doamin.ExtendableBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @Description 基础json demo
 * @Author lktbz
 * @Date 2021/07/19
 */
public class JacksonBaseDemo {
    @Test
    public void ObjectToJSON() throws JsonProcessingException {
        String s = new ObjectMapper().writeValueAsString(new Car("yellow", "renault"));
        System.out.println("转换后的json 为:"+s);
    }

    /**
     * 反序列化必须有空构造
     * @throws JsonProcessingException
     */
    @Test
    public void JSONToObject() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car car = new ObjectMapper().readValue(json, Car.class);
        System.out.println(car.toString());
    }

    @Test
    public void JSONToJsonNode() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        JsonNode node = new ObjectMapper().readTree(json);
        String color = node.get("color").asText();
        System.out.println(color);
    }
    @Test
    public void JSONArrayToJavaList() throws JsonProcessingException {
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
          List<Car> cars=new ObjectMapper().readValue(jsonCarArray, new TypeReference<List<Car>>() {
          });

        System.out.println(cars);
    }
    @Test
    public void JSONStringToJavaMap() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map =new ObjectMapper().readValue(json, new TypeReference<Map<String,Object>>() {
        });
        System.out.println(map);
    }

    @Test
    public void vde() throws JsonProcessingException {

        String jsonStrA = "{" +
                "            \"comCodeA\": \"YTO\"," +
                "            \"postNoA\": \"M0101065279\"," +
                "            \"successA\": true," +
                "            \"failReasonA\": \"\"," +
                "            \"stateA\": 3," +
                "            \"tracesA\": [" +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-10 20:01:04\"," +
                "                    \"acceptStationA\": \"【上海市德玛西亚公司】 已收件\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-10 22:20:33\"," +
                "                    \"acceptStationA\": \"【上海市德玛西亚公司】 已打包\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-10 22:23:13\"," +
                "                    \"acceptStationA\": \"【上海市德玛西亚公司】 已发出 下一站 【上海转运中心】\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 03:07:34\"," +
                "                    \"acceptStationA\": \"【上海转运中心】 已收入\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 03:14:21\"," +
                "                    \"acceptStationA\": \"【上海转运中心】 已发出 下一站 【杭州转运中心】\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 10:37:02\"," +
                "                    \"acceptStationA\": \"【杭州转运中心】 已收入\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 13:11:00\"," +
                "                    \"acceptStationA\": \"【杭州转运中心】 已发出 下一站 【石桥转运中心】\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-11 22:45:20\"," +
                "                    \"acceptStationA\": \"【石桥转运中心】 已收入\"" +
                "                }," +
                "                {" +
                "                    \"acceptTimeA\": \"2018-09-12 13:19:39\"," +
                "                    \"acceptStationA\": \"客户 签收人: 圆通代签 已签收 感谢使用圆通速递，期待再次为您服务\"" +
                "                }" +
                "            ]" +
                "        }" +
                "}";
        LogisticsInfo logisticsInfo = new ObjectMapper().readValue(jsonStrA, LogisticsInfo.class);
        System.out.println(logisticsInfo);
    }
}
