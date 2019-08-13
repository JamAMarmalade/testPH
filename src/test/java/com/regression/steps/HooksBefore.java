package com.regression.steps;

import com.regression.EnvironmentRead;
import org.junit.Before;
import org.omg.CORBA.Environment;

public class HooksBefore {
    private EnvironmentRead credentials = new EnvironmentRead();

    @Before
    public void setCredentials(){
        credentials.setEnvironment();
        System.out.println("Setting up url");
    }
}
