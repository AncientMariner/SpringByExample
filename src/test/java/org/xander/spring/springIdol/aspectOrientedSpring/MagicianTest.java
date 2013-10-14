package org.xander.spring.springIdol.aspectOrientedSpring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicianTest {
    @Test
    public void MagicianTest() {
        Volunteer volunteer = new Volunteer();
        volunteer.thinkOfSomething("Ace of Spades");

        Magician magician = new Magician(volunteer.getThoughts());

        assertEquals("Ace of Spades", magician.getThoughts());
    }

}
