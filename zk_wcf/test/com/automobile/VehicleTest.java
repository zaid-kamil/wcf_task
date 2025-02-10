package com.automobile;

import static org.junit.Assert.*;

import org.junit.Test;

import com.automobile.twowheeler.Hero;
import com.automobile.twowheeler.Honda;
public class VehicleTest {

	@Test
    public void testHeroMethods() {
        Hero hero = new Hero("Splendor", "KA01AB1234", "John Doe");
        
        assertEquals("Splendor", hero.getModelName());
        assertEquals("KA01AB1234", hero.getRegistrationNumber());
        assertEquals("John Doe", hero.getOwnerName());
        assertEquals(0, hero.getSpeed());
        
        // Testing radio functionality (will print to console)
        hero.radio();
    }
    
    @Test
    public void testHondaMethods() {
        Honda honda = new Honda("City", "KA02CD5678", "Jane Doe");
        
        assertEquals("City", honda.getModelName());
        assertEquals("KA02CD5678", honda.getRegistrationNumber());
        assertEquals("Jane Doe", honda.getOwnerName());
        assertEquals(0, honda.getSpeed());
        
        // Testing CD player functionality (will print to console)
        honda.cdplayer();
    }

}
