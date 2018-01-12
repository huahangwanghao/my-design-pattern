package com.wanghao.reflection;/**
 * Created by Administrator on 2018/1/12.
 */

/**
 * @author WangH
 * @create 2018-01-12 17:28
 **/
public class Student {
    
    
    private int id;
    
    private String name;
    
    private boolean sex;

    public String text;
    

    public Student(String name) {
        System.out.println("调用有有有有有参构造方法");
        this.name = name;
    }

    public Student() {
        System.out.println("public调用无参构造方法");
    }

    private Student (int id){
        System.out.println("private调用int构造方法   id: "+id);
    }
    
    protected  Student (int id,String name){
        System.out.println("protected调用无参构造方法");
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    
}
