package com.example.gson.test;

import com.example.gson.domain.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/19
 */
public class GsonTestDemo {
    @Test
    public void helloWold() {
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        Gson gson = new Gson();
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student.toString());
    }

    /**
     * 美化json
     */
    @Test
    public void helloWoldPretty() {
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        Gson builder = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Student student = builder.fromJson(jsonString, Student.class);
        System.out.println(student.toString());
    }

    @Test
    public void objectToJson() {
        Student student = new Student();
        student.setName("lk");
        student.setAge(20);
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
    }

    /**
     * 复杂树形解析
     */
    @Test
    public void readTrueDemo() {
        String jsonString =
                "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        JsonParser parser = new JsonParser();
        JsonElement rootNode = parser.parse(jsonString);
        if (rootNode.isJsonObject()) {
            JsonObject asJsonObject = rootNode.getAsJsonObject();
            JsonElement name = asJsonObject.get("name");
            System.out.println("属性name为：" + name.getAsString());
            JsonElement age = asJsonObject.get("age");
            System.out.println("属性age为：" + age.getAsInt());
            JsonElement verifiedNode = asJsonObject.get("verified");
            System.out.println("Verified: " + (verifiedNode.getAsBoolean() ? "Yes" : "No"));
            JsonArray marks = asJsonObject.getAsJsonArray("marks");
            //遍历数组
            System.out.print("marks:");
            for (int i = 0; i < marks.size(); i++) {
                JsonPrimitive asJsonPrimitive = marks.get(i).getAsJsonPrimitive();
                System.out.print(" -" + asJsonPrimitive.getAsInt());
            }
            System.out.println(" ");
        }
    }

    @Test
    public void arrayTOJson() {
        Gson gson = new Gson();
        int[] marks = {100, 90, 85};
        String[] names = {"Ram", "Shyam", "Mohan"};
        String s = gson.toJson(marks);
        String s1 = gson.toJson(names);
        System.out.println(s);
        System.out.println(s1);
        //反序列化
        int[] ints = gson.fromJson(s, int[].class);
        System.out.println(Arrays.toString(ints));
        String[] strings = gson.fromJson(s1, String[].class);
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void listTOJson() {
        Gson gson = new Gson();
        Collection<Integer> marks = new ArrayList<Integer>();
        marks.add(100);
        marks.add(90);
        marks.add(85);
        String s = gson.toJson(marks);
        System.out.println(s);
        Type listType = new TypeToken<Collection<Integer>>() {
        }.getType();
        marks = (Collection<Integer>) gson.fromJson(s, listType);
        System.out.println(marks);
    }

    /**
     * 泛型处理
     */
    @Test
    public void GenerTest() {
        Shape<Circle> shape = new Shape<Circle>();
        Circle circle = new Circle(5.0);
        shape.setShape(circle);
        Gson gson = new Gson();
        Type type = new TypeToken<Shape<Circle>>() {
        }.getType();
        String s = gson.toJson(shape, type);
        System.out.println(s);
        Shape shape2 = gson.fromJson(s, type);
        System.out.println(shape2.toString());
        System.out.println(shape2.getArea());
        System.out.println(shape2.getClass());


    }

    /**
     * 嵌套类使用
     */
    @Test
    public void InnerClassTest() {
        InnerStudent student = new InnerStudent();
        student.setRollNo(1);
        InnerStudent.Name name = student.new Name();
        name.firstName = "mardk";
        name.lastName = "dockers";
        student.setName(name);
        Gson gson = new Gson();
        String s = gson.toJson(student);
        System.out.println("序列化成json：" + s);
        student = gson.fromJson(s, InnerStudent.class);

        System.out.println("反序列化成Object" + student);
        System.out.println("Roll No: " + student.getRollNo());
        System.out.println("First Name: " + student.getName().firstName);
        System.out.println("Last Name: " + student.getName().lastName);
        String nameString = gson.toJson(name);
        System.out.println(nameString);
        name = gson.fromJson(nameString, InnerStudent.Name.class);
        System.out.println(name.getClass());
        System.out.println("First Name: " + name.firstName);
        System.out.println("Last Name: " + name.lastName);
    }

    /**
     * 空值处理 ,不序列化
     */
    @Test
    public void checkNullValue() {
        Gson gson = new Gson();

        InnerStudent student = new InnerStudent();
        student.setRollNo(1);
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);

        InnerStudent student1 = gson.fromJson(jsonString, InnerStudent.class);
        System.out.println(student1);
    }

    /**
     * 空值一样序列化
     */
    @Test
    public void noCareNullValue() {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        InnerStudent student = new InnerStudent();
        student.setRollNo(1);
        String jsonString = gson.toJson(student);
        System.out.println(jsonString);

        InnerStudent student1 = gson.fromJson(jsonString, InnerStudent.class);
        System.out.println(student1);
    }

    /**
     * 版本支持
     */
    @Test
    public void versionOfSuppert() {
        GsonBuilder builder = new GsonBuilder();
        builder.setVersion(1.0);
        Gson gson = builder.create();
        VersionStudent student = new VersionStudent();
        student.setRollNo(1);
        student.setName("Mahesh Kumar");
        student.setVerified(true);

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);

        gson = new Gson();
        jsonString = gson.toJson(student);
        System.out.println(jsonString);

    }

    /**
     * gson 序列化默认排除 transient  static 字段
     */
    @Test
    public void excludingFieldsDemo() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ExtStudent student = new ExtStudent();
        student.setRollNo(1);
        student.setName("Mahesh Kumar");
        student.setVerified(true);
        student.setId(1);
        ExtStudent.className = "VI";

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }

    /**
     * 调整需要序列化的字段
     * STATIC TRANSIENT 存在一者，相互排斥
     */
    @Test
    public void includingFieldsDemo() {
        GsonBuilder builder = new GsonBuilder();
        //transient 类型的也映射进来
//        builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
        builder.excludeFieldsWithModifiers(Modifier.STATIC);
        Gson gson = builder.create();

        ExtStudent student = new ExtStudent();
        student.setRollNo(1);
        student.setName("Mahesh Kumar");
        student.setVerified(true);
        student.setId(1);
        ExtStudent.className = "VI";

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }

    /**
     * 注解的方式控制哪些字段需要显示
     */
    @Test
    public void exposeDemo() {

        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = builder.create();

        PoseStudent student = new PoseStudent();
        student.setRollNo(1);
        student.setName("Mahesh Kumar");
        student.setVerified(true);
        student.setId(1);
        PoseStudent.className = "VI";

        String jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}

