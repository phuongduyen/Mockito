package com.example.mockitofirst.MyManager.Animals.wide;

import com.example.mockitofirst.Enemy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;
import static org.powermock.configuration.ConfigurationType.PowerMock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Enemy.class)
public class AntTeamTest {


    @Before
    public void init() {
        PowerMockito.mockStatic(Enemy.class);
    }



    @Test
    public void testM(){

        Enemy mockEnemy = PowerMockito.mock(Enemy.class);
        TigerTeam tigerTeam = mock(TigerTeam.class);

    }



}
