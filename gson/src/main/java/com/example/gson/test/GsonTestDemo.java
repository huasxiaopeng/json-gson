package com.example.gson.test;

import com.example.gson.domain.Student;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

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
    public  void helloWold(){
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        Gson gson=new Gson();
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student.toString());
    }

    /**
     *  美化json
     */
    @Test
    public  void helloWoldPretty(){
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        Gson builder=new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Student student = builder.fromJson(jsonString, Student.class);
        System.out.println(student.toString());
    }
    @Test
    public  void objectToJson(){
        Student student=new Student();
        student.setName("lk");
        student.setAge(20);
        Gson gson=new Gson();
        String s = gson.toJson(student);
        System.out.println(s);
    }

    /**
     *  复杂树形解析
     */
    @Test
    public void readTrueDemo(){
        String jsonString =
                "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        JsonParser parser = new JsonParser();
        JsonElement rootNode  = parser.parse(jsonString);
        if(rootNode.isJsonObject()){
            JsonObject asJsonObject = rootNode.getAsJsonObject();
            JsonElement name = asJsonObject.get("name");
            System.out.println("属性name为："+name.getAsString());
            JsonElement age = asJsonObject.get("age");
            System.out.println("属性age为："+age.getAsInt());
            JsonElement verifiedNode = asJsonObject.get("verified");
            System.out.println("Verified: " + (verifiedNode.getAsBoolean() ? "Yes":"No"));
            JsonArray marks = asJsonObject.getAsJsonArray("marks");
            //遍历数组
            System.out.print("marks:");
            for (int i = 0; i < marks.size(); i++) {
                JsonPrimitive asJsonPrimitive = marks.get(i).getAsJsonPrimitive();
                System.out.print(" -"+asJsonPrimitive.getAsInt());
            }
            System.out.println(" ");
            }
    }

    @Test
    public void arrayTOJson(){
        Gson gson = new Gson();
        int[] marks = {100,90,85};
        String[] names = {"Ram","Shyam","Mohan"};
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
    public void listTOJson(){
        Gson gson = new Gson();
        Collection<Integer> marks = new ArrayList<Integer>();
        marks.add(100);
        marks.add(90);
        marks.add(85);
        String s = gson.toJson(marks);
        System.out.println(s);
        Type listType = new TypeToken<Collection<Integer>>(){}.getType();
        marks= (Collection<Integer>)gson.fromJson(s, listType);
        System.out.println(marks);
    }

}

