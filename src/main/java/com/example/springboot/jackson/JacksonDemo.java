package com.example.springboot.jackson;

import com.example.springboot.doamin.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * @Description jackson 注解
 * @Author lktbz
 * @Date 2021/07/19
 */
public class JacksonDemo {
    /**
     * map 属性进行字段映射
     * 构建如下类型
     * {
     * "name":"My bean",
     * "attr2":"val2",
     * "attr1":"val1"
     * }
     */
    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("attr2", "val2");
        bean.add("attr1", "val1");
        String s = new ObjectMapper().writeValueAsString(bean);
        System.out.println(s.toString());
    }

    /**
     * 修改返回值属性值
     *
     * @throws JsonProcessingException
     */
    @Test
    public void whenSerializingUsingJsonGetter_thenCorrect()
            throws JsonProcessingException {
        MyBean bean = new MyBean(1, "My bean");
        String s = new ObjectMapper().writeValueAsString(bean);
        System.out.println(s);
    }

    /**
     * 调整映射字段的属性顺序
     *
     * @throws JsonProcessingException
     */
    @Test
    public void whenSerializingUsingJsonPropertyOrder_thenCorrect()
            throws JsonProcessingException {
        MyBeanOrder bean = new MyBeanOrder(1, "My bean");
        String s = new ObjectMapper().writeValueAsString(bean);
        System.out.println(s);
    }

    /**
     * 原样子序列化
     *
     * @throws JsonProcessingException
     */
    @Test
    public void whenSerializingUsingJsonRawValue_thenCorrect()
            throws JsonProcessingException {
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    /**
     * 使用类名进行序列化
     *
     * @throws JsonParseException
     * @throws IOException
     */
    @Test
    public void whenSerializingUsingJsonValue_thenCorrect()
            throws JsonParseException, IOException {

        String enumAsString = new ObjectMapper()
                .writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println(enumAsString);
    }

    /**
     * 一般json 格式如下:
     * {
     * "id": 1,
     * "name": "John"
     * }
     * <p>
     * 现在我们想序列化成这样的？
     * {
     * "User": {
     * "id": 1,
     * "name": "John"
     * }
     * }
     *
     * @throws JsonProcessingException
     */

    @Test
    public void whenSerializingUsingJsonRootName_thenCorrect()
            throws JsonProcessingException {
        UserWithRoot root = new UserWithRoot(1, "lktbz");
        ObjectMapper objectMapper = new ObjectMapper();
        //对返回的对象进行修改
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = objectMapper.writeValueAsString(root);
        System.out.println(result);
    }

    /**
     * 自定义序列化格式
     *
     * @throws JsonProcessingException
     * @throws ParseException
     */
    @Test
    public void whenSerializingUsingJsonSerialize_thenCorrect()
            throws JsonProcessingException, ParseException {
        SimpleDateFormat df
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        EventWithSerializer event = new EventWithSerializer("party", date);

        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }

    /**
     * json 串与实体类字段不匹配解决方案
     *
     * @throws IOException
     */
    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect()
            throws IOException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
        BeanWithCreator creator = new ObjectMapper().readerFor(BeanWithCreator.class)
                .readValue(json);
        System.out.println(creator.toString());
    }

    /**
     * 额外注入字段
     *
     * @throws IOException
     */
    @Test
    public void whenDeserializingUsingJsonInject_thenCorrect()
            throws IOException {

        String json = "{\"name\":\"My bean\"}";
        InjectableValues inject = new InjectableValues.Std()
                .addValue(int.class, 1);
        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);
        System.out.println(bean.toString());

    }

    @Test
    public void whenDeserializingUsingJsonAnySetter_thenCorrect()
            throws IOException {
        String json
                = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
        ExtendableBean o = new ObjectMapper().readerFor(ExtendableBean.class)
                .readValue(json);
        System.out.println(o.toString());
    }

    /**
     * 别名映射
     *
     * @throws IOException
     */
    @Test
    public void whenDeserializingUsingJsonAlias_thenCorrect() throws IOException {
        String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";
        AliasBean aliasBean = new ObjectMapper().readerFor(AliasBean.class).readValue(json);
        System.out.println(aliasBean.toString());
    }

    /**
     * 字段的忽略
     *
     * @throws JsonProcessingException
     */
    @Test
    public void whenSerializingUsingJsonIgnoreProperties_thenCorrect()
            throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");
        String s = new ObjectMapper().writeValueAsString(bean);
        System.out.println(s);
    }

    /**
     * 细粒度的控制忽略字段
     *
     * @throws JsonProcessingException
     */
    @Test
    public void whenSerializingUsingJsonIgnore_thenCorrect()
            throws JsonProcessingException {

        BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");

        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);


    }

    /**
     * 忽略整个类
     *
     * @throws JsonProcessingException
     * @throws ParseException
     */
    @Test
    public void whenSerializingUsingJsonIgnoreType_thenCorrect()
            throws JsonProcessingException, ParseException {

        User.Name name = new User.Name("John", "Doe");
        User user = new User(1, name);

        String result = new ObjectMapper()
                .writeValueAsString(user);
        System.out.println(result);
    }

    /**
     *
     * @throws JsonProcessingException
     */
    @Test
    public void whenSerializingUsingJsonInclude_thenCorrect()
            throws JsonProcessingException {

        MyBean bean = new MyBean(1, null);

        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
    }
    @Test
    public void whenSerializingUsingJsonAutoDetect_thenCorrect()
            throws JsonProcessingException {

        PrivateBean bean = new PrivateBean(1, "My bean");

        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
}

    @Test
    public void whenSerializingUsingJsonFormat_thenCorrect()
            throws JsonProcessingException, ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        EventWithFormat event = new EventWithFormat("party", date);

        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }
    @Test
    public void whenSerializingUsingJsonView_thenCorrect()
            throws JsonProcessingException {
        Item item = new Item(2, "book", "John");

        String result = new ObjectMapper()
                .writerWithView(Views.Public.class)
                .writeValueAsString(item);

        System.out.println(result);
    }
}