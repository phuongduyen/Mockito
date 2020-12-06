package com.example.mockitofirst.MyManager.Animals.Pet;

import android.util.Log;

import com.example.mockitofirst.MyManager.Animals.Animal;
import com.example.mockitofirst.MyManager.IAnimalInfor.PetInfor;

public class Cat extends Animal implements PetInfor {
    private static String TAG = "Cat$";
    private static String TAG_Name = "ntp_";

    private String owner;
    private int price;
    private boolean stautus;
    private int ilevel = 0;

    public Cat() {
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
        setLevel();
    }
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
        if(this.owner != null && this.owner != ""){
            setStautus(true);
        } else setStautus(false);
    }
    @Override
    public String getOwner() {
        return owner;
    }

    public int getLevel() {
        return ilevel;
    }
    private int setLevel() {
        int level = 0;
        if(getPrice() > 0 && getName() != null){
            if(getPrice() < 10){
                level += 10;
            }else if(getPrice() < 20){
                level += 20;
            }else {
                level += 30;
            }
            if(getName().startsWith("a")){
                level += 1;
            }else if (getName().startsWith("b")){
                level += 2;
            }else if (getName().startsWith("c")){
                level += 3;
            }else {
                level += 4;
            }
        }
        ilevel = level;
        return level;
    }

    @Override
    public Boolean getStatus() {
        return stautus;
    }

    private boolean setStautus(boolean stautus){
        this.stautus = stautus;
        if(checkOw())
            return true;
        return false;
    }

    public boolean checkOw(){
        if(this.owner != null && this.owner != "" ){ // owner have
            if(stautus == true)
                return true;
            else return false;
        }else { // owner null
            if (stautus == false){
                return true;
            } else return false;
        }
    }

    @Override
    public String getInfor() {
        String getInfor = "CAT: owner: " + getOwner() + "/ status: " + getStatus() + "/ price: " + getPrice() + "/ level: " + getLevel();
//        Log.d(TAG + TAG_Name, "\n" + getInfor);
        return getInfor;
    }
}
