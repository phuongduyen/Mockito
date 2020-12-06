package com.example.mockitofirst.MyManager.Animals.Pet;

import com.example.mockitofirst.MyManager.IAnimalInfor.PetInforTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat cat = new Cat();

    @Test
    public void testSetLevel(){
        cat.setPrice(-1);
        assertEquals(0, cat.getLevel());
        cat.setPrice(9);
        assertEquals(0, cat.getLevel());
        cat.setName("a");
        cat.setPrice(9);
        assertEquals(11, cat.getLevel());
        cat.setName("bdf");
        cat.setPrice(9);
        assertEquals(12, cat.getLevel());
        cat.setName("cfe");
        cat.setPrice(9);
        assertEquals(13, cat.getLevel());
        cat.setName("hger");
        cat.setPrice(9);
        assertEquals(14, cat.getLevel());
        cat.setPrice(12);
        assertEquals(24, cat.getLevel());
        cat.setPrice(22);
        assertEquals(34, cat.getLevel());
    }

}
