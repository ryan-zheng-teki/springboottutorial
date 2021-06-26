package com.qiusuo;

import com.qiusuo.annotations.Hookie;

import java.lang.annotation.Annotation;

@Hookie
public class AnnotationParseDemo {
    public static void main(String[] args) {
        Annotation[] annotations = AnnotationParseDemo.class.getDeclaredAnnotations();
        System.out.println("hello world");
    }
}
