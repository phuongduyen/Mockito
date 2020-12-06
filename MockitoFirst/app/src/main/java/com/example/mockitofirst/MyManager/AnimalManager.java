package com.example.mockitofirst.MyManager;

import com.example.mockitofirst.MyManager.Animals.Animal;
import com.example.mockitofirst.MyManager.Animals.Pet.Cat;
import com.example.mockitofirst.MyManager.Animals.Pet.Dog;

import java.util.ArrayList;
import java.util.List;

public class AnimalManager {
    private ArrayList<Animal> animalList;
    public AnimalManager(){
        animalList = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }
    public Animal getAnimal(int index){
        return animalList.get(index);
    }

    public void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public int getSize(){
        return animalList.size();
    }

    public AnimalManager(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }
    public boolean manager(){
        for(Animal animal : animalList){
            System.out.println(animal.getInfor());
        }
        return true;
    }
}
