package com.annotationAndreflectTest.study;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
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

        // 通过反射获取class对象  class获取实例对象
        ReflectStudentTest reflectStudentTest = (ReflectStudentTest) sutclass2.newInstance();
        Field name;
        // 获取字段属性
        name = sutclass2.getSuperclass().getDeclaredField("name");
        // name = sutclass2.getField("name"); // 可以获取父类public 属性，
        // name = sutclass2.getDeclaredField("name"); // 私有属性不会被子类继承所以 getDeclaredField无法访问
        // 设置是否允许访问
        name.setAccessible(true);
        name.set(reflectStudentTest,"fjl");
        System.out.println(reflectStudentTest.getName());

        // 返回一个方法   方法名，方法参数类型（避免方法重载不知道是哪个方法）
        Method setName = sutclass2.getDeclaredMethod("getName", String.class);
        setName.invoke(reflectStudentTest,"fjl");
        System.out.println(reflectStudentTest.getName());
        
        // 获取父类类型
        Class<?> superclass = sutclass.getSuperclass();
        System.out.println(superclass );

        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // 扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        // 根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        
    }

    public static void annotationTest() throws NoSuchFieldException {
        ReflectPersonTest p = new ReflectPersonTest();
        Class<? extends ReflectPersonTest> pClass = p.getClass();
        MyAnnotation annotation = pClass.getAnnotation(MyAnnotation.class);
        SEX sex = annotation.sex();
        int age = annotation.age();
        String name = annotation.name();

        Field field = pClass.getField("name");
        FildAnnotation fieldAnnotation = field.getAnnotation(FildAnnotation.class);
        int len = fieldAnnotation.len();
        String type = fieldAnnotation.type();
        String name1 = fieldAnnotation.name();
    }
}
