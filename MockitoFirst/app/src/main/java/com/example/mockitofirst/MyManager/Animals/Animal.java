package com.example.mockitofirst.MyManager.Animals;

import android.util.Log;

import com.example.mockitofirst.MyManager.IAnimalInfor.InforAnimal;

public class Animal implements InforAnimal {
    private static String TAG = "Animal$";
    private static String TAG_Name = "ntp_";

    String name;
    int age;

    public Animal() {

    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void setName(String name) {
 //       Log.d(TAG + TAG_Name, "setName: " + name);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
    //    Log.d(TAG + TAG_Name, "setAge: " + age);
        this.age = age;

    }

    @Override
    public String getInfor() {
        String getInfor = "animal: name: " + getName() + "/ age: " + getAge();
 //       Log.d(TAG + TAG_Name, "getInfor: " + getInfor);
        return getInfor;
    }
}
