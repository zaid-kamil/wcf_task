package com.wipro.six;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.six.beans.Car;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	// Inversion of Control
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        
        
        Car c1 = ac.getBean("car", Car.class);
        System.out.println(c1);
        System.out.println("Color "+c1.getColor());
        System.out.println("Driver "+c1.getDriver());
        
        Car c2 = ac.getBean("car2", Car.class);
        System.out.println(c2);
        
        Car c3 = ac.getBean("car3", Car.class);
        System.out.println("Color: "+c3.getColor());
        System.out.println("Driver: "+c3.getDriver());
        
        Car c4 = ac.getBean("car4", Car.class);
        System.out.println("Color: "+c4.getColor());
        System.out.println("Driver: "+c4.getDriver());
        System.out.println((int)'l');
        // Dependency Injection
    }
}
