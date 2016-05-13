package com.example.shaunmesias.assignment_6_2.services.driver;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.shaunmesias.assignment_6_2.conf.util.App;
import com.example.shaunmesias.assignment_6_2.domain.driver.Driver;
import com.example.shaunmesias.assignment_6_2.services.driver.impl.FindAllDriversServiceImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Shaun Mesias on 2016/05/11.
 */
public class FindAllDriversTest extends AndroidTestCase{
    private Boolean isBound;
    private FindAllDriversServiceImpl myService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        myService = FindAllDriversServiceImpl.getInstance();
        Intent intent = new Intent(App.getAppContext(), FindAllDriversServiceImpl.class);
        App.getAppContext().bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            FindAllDriversServiceImpl.MyLocalBinder binder = (FindAllDriversServiceImpl.MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

    public void testService() throws Exception {
        Set<Driver> drivers = myService.getAll();
        Assert.assertTrue(" READ ALL", drivers.size() > 0);

    }
}
