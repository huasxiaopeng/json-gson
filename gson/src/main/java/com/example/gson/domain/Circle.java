package com.example.gson.domain;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/20
 */
public class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "Circle";
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return (radius*radius*3.14);
    }
}
