package com.example.mockitofirst.MyManager.Animals.wide;

import com.example.mockitofirst.Enemy;

public class TigerTeam {
    int countTeam;
    String local;
    Enemy enemy;

    private TigerTeam() {
        enemy.createInstance();
    }

    public TigerTeam(int countTeam, String local, Enemy enemy) {
        this.countTeam = countTeam;
        this.local = local;
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getCountTeam() {
        return countTeam;
    }

    public void setCountTeam(int countTeam) {
        this.countTeam = countTeam;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

}
