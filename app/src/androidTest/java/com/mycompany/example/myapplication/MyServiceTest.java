package com.mycompany.example.myapplication;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.RequiresDevice;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class MyServiceTest {

    @Rule
    public ServiceTestRule myServiceTestRule = new ServiceTestRule();


    @Test
    @RequiresDevice //tells the framework to run this test only on a physical device and not an emulator
    public void testService() throws TimeoutException{
        myServiceTestRule.startService(new Intent(InstrumentationRegistry.getTargetContext(), MyService.class));
    }

    @Test
    @SdkSuppress(minSdkVersion = 30) //tells the framework to run this test on the specified minSDK
    public void testBoundService() throws TimeoutException{
        IBinder binder = myServiceTestRule.bindService(new Intent(InstrumentationRegistry.getTargetContext(), MyService.class));

        MyService service = ((MyService.LocalBinder) binder).getSerVice();

        assertNotNull("Bound Service is null", service);
    }

}
