package com.wanghao.reflection;/**
 * Created by Administrator on 2018/1/12.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * 反射的主方法
 * 前提:必须的代带便的字节码的Class 
 * 
 * java反射机制在运行状态中,对于任意一个类,都能够知道这个类的所有属性,方法;对于任意一个对象,都能够调用它的任意一个方法和属性,这种动态获取的信息以及动态调用对象的方法
 * 要想解剖一个类,必须要先获取到该类的字节码文件对象, 而剖析使用的就是Class类中的方法,所以先要获取到每一个字节码文件对应的Class类型的对象.
 * 
 * 反射就是把java类中的各种成分 映射成一个个的java对象
 * 
 * 获取Class对象的三种方式
 * 1. Object   getClass()
 * 2. 任何一个对象都有一个静态的class 属性
 * 3.通过Class的静态方法  Class.forName("com.wanghao.test")
 * 
 * 
 * @author WangH
 * @create 2018-01-12 16:42
 **/
public class ReflectionMain {

    public static void main(String[] args) throws Exception{
        
        //第一种获取方式
        Student student1=new Student();
        Class clz1=student1.getClass();
        System.out.println(clz1);
        
        //第二种获取方式
        Class clz2=Student.class;
        System.out.println(clz1==clz2);
        //第三种方式
        
        Class clz3=Class.forName("com.wanghao.reflection.Student");
        System.out.println(clz1==clz3);





        Constructor[] cons=clz3.getConstructors();
        System.out.println("************getConstructors 得到所有的public 的构造方法***************");
        for (Constructor con:cons) {
            System.out.println(con);
        }


         cons=clz3.getDeclaredConstructors();
        System.out.println("************getDeclaredConstructors 得到所有的的构造方法***************");
        for (Constructor con:cons) {
            System.out.println(con);
        }


    /*    Constructor con=clz3.getConstructor(int.class);
        System.out.println("************getConstructor 得到所有的的int的构造方法***************");
        con.setAccessible(true);
        con.newInstance(1);*/
        
        
        
        //-----------------获取成员变量--------------------------
        System.out.println("-------获取成员变量--------------");
        Field[] fields=clz3.getFields();
        System.out.println("-------获取public成员变量--------------");
        for(Field field:fields){
            System.out.println(field);
        }

        Field[] fields1=clz3.getDeclaredFields();
        System.out.println("-------获取所有成员变量--------------");
        Student stu= (Student) clz3.newInstance();
        for(Field field:fields1){
            field.setAccessible(true);
            System.out.println(field);
        }


        Field fields2=clz3.getDeclaredField("id");
        stu= (Student) clz3.getConstructor().newInstance();
        stu= (Student) clz3.newInstance();
        System.out.println("-------通过名字获取成员变量--------------");
        fields2.setAccessible(true);
        fields2.setInt(stu,2);
        System.out.println(stu.getId());

//http://blog.csdn.net/sinat_38259539/article/details/71799078


        System.out.println("-----------------获取成员方法---------------------");

        Method[] methods=clz3.getMethods();
        System.out.println("获取所有的public method");
        for(Method method:methods){
            System.out.println(method);
        }


        System.out.println("获取所有的 All  method ");
        
        methods = clz3.getDeclaredMethods();
        for(Method method:methods){
            System.out.println(method);
        }
        
        
        
        Method m=clz3.getMethod("show1",String.class);
        m.invoke(stu,"hello");
        
        m=clz3.getMethod("show3",null);
        m.invoke(stu);

        System.out.println("----------获取私有的方法-----------");
        
        m=clz3.getDeclaredMethod("show4",int.class);
        m.setAccessible(true);
        m.invoke(stu,43);
        
        
    }
    
    
}
