package com.wanghao.factory;/**
 * Created by Administrator on 2018/1/11.
 */

import javax.annotation.Resource;

/**
 * @author WangH
 * @create 2018-01-11 14:18
 **/
@Resource
public class UserInfo {
    
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
