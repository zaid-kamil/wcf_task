package com.wipro.automobile.ship;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
public class CompartmentTest {

	private Compartment compartment;

    @Before
    public void setUp() {
        compartment = new Compartment(10, 20, 30);
    }

    @Test
    public void testGetHeight() {
        assertEquals(10, compartment.getHeight(),0.0);
    }

    @Test
    public void testGetWidth() {
        assertEquals(20, compartment.getWidth(),0.0);
    }

    @Test
    public void testGetBreadth() {
        assertEquals(30, compartment.getBreadth(),0.0);
    }

    @Test
    public void testSetHeight() {
        compartment.setHeight(15);
        assertEquals(15, compartment.getHeight(),0.0);
    }

    @Test
    public void testSetWidth() {
        compartment.setWidth(25);
        assertEquals(25, compartment.getWidth(),0.0);
    }

    @Test
    public void testSetBreadth() {
        compartment.setBreadth(35);
        assertEquals(35, compartment.getBreadth(),0.0);
    }

}
