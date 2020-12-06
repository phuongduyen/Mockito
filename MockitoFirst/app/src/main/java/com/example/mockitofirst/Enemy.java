package com.example.mockitofirst;

import com.example.mockitofirst.MyManager.Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Enemy {
    private ArrayList<Animal> enemyList;
    private Enemy(){
        enemyList = new ArrayList<>();
    }
    public void createInstance(){
        new Enemy();
    }
    public int getCount(){
        return enemyList.size();
    }
    public ArrayList<Animal> getEnemyList(){
        return enemyList;
    }
    public Animal getEnemy(int index){
        return enemyList.get(index);
    }

}
