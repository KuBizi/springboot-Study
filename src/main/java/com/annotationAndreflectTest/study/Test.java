package com.annotationAndreflectTest.study;

@MyAnnotation(name = "MyAnnotation",age = 24,sex = {SEX.MEN,SEX.WOMEN})
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.annotationAndreflectTest.study.ReflectStudentTest");
        Class<?> aClass1 = Class.forName("com.annotationAndreflectTest.study.ReflectStudentTest");
        Class<?> aClass2 = Class.forName("com.annotationAndreflectTest.study.ReflectStudentTest");
        System.out.println(aClass);
        // 一个java文件只有一个class对象实例 
        System.out.println(aClass1.hashCode()==aClass2.hashCode());

        // 通过实例对象获取 class对象
        ReflectStudentTest stu = new ReflectStudentTest();
        Class<? extends ReflectStudentTest> sutclass = stu.getClass();

        // 通过包名 获取 class对象
        Class<?> sutclass2 = Class.forName("com.annotationAndreflectTest.study.ReflectStudentTest");

        // 通过类名
        Class<ReflectStudentTest> sutclass3 = ReflectStudentTest.class;

        System.out.println(sutclass2.hashCode()==sutclass3.hashCode());
        
        // 获取父类类型
        Class<?> superclass = sutclass.getSuperclass();
        System.out.println(superclass );
    }
}
