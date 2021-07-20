package com.example.gson.domain;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/20
 */
public class Shape<T> {
    public T shape;

    public void setShape(T shape) {
        this.shape = shape;
    }
    public T get() {
        return shape;
    }
    public double getArea() {
        if(shape instanceof Circle) {
            return ((Circle) shape).getArea();
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Shape{" +
                "shape=" + shape +
                '}';
    }
}
