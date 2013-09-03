package org.xander.springByExample.Part_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/org/xander/springByExample/Part_1/defaultMessageTest-context.xml"})
public class MessageTest {
    final static Logger logger = Logger.getLogger(String.valueOf(MessageRunner.class));

    @Autowired
    private Message message = null;

    @Test
    public void testMessage() {
        assertNotNull("Constructor message instance is null.", message);
        String msg = message.getMessage();

        assertNotNull("Message is null.", msg);
        String expectedMessage = "Spring is fun";

        assertEquals("Message should be '" + expectedMessage + "'.", expectedMessage, msg);
        logger.info("message='{}'" + msg);
    }
}
