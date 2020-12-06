package com.example.mockitofirst.MyManager.Animals;

import com.example.mockitofirst.MyManager.AnimalManager;
import com.example.mockitofirst.MyManager.Animals.Pet.Cat;
import com.example.mockitofirst.MyManager.Animals.Pet.Dog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class AnimalManagerTest {
    private AnimalManager mTarget = new AnimalManager();

    @Test
    public void testManager_notMock(){
        // object k mock, set thuoc tinh va goi ham, cho ket qua nhu binh thuong
        Dog dog = (Dog) new Dog();
        dog.setName("DOGG");
        dog.setPrice(12);


        Cat cat = (Cat) new Cat();
        cat.setName("catt");
        cat.setPrice(56);
        cat.setOwner("Jame");

        mTarget.addAnimal(dog);
        mTarget.addAnimal(cat);

        assertEquals(2, mTarget.getSize());
        assertTrue(mTarget.manager());
//        verify(dog).getInfor();
    }

    @Test
    public void testManager_Mock(){
        // object k mock, set thuoc tinh va goi ham, cho ket qua nhu binh thuong
        Dog dog = mock(Dog.class);
        dog.setName("mDOGG_MOCK");
        dog.setPrice(2);
        dog.setOwner("");

        Cat cat = mock(Cat.class);
        cat.setName("acatt_mock");
        cat.setPrice(86);
        cat.setOwner("Nacy");

        mTarget.addAnimal(dog);
        mTarget.addAnimal(cat);

        assertEquals(2, mTarget.getSize());
        assertTrue(mTarget.manager());
//        verify(dog).getInfor();
    }



}
