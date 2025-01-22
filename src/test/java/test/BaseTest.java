package test;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method m){
        System.out.println("Method Name: "+ m.getName());
        System.out.println("Thread Number" + Thread.currentThread().getId());
    }
}
