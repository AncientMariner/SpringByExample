package org.xander.spring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class BraveKnightTest {
    @Mock
    Quest quest;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void knightShouldEmbarkOnQuestTest() {
        Knight braveKnight = new Knight(quest);
        braveKnight.embarkOnQuest();

        verify(quest).embark();
    }
}
