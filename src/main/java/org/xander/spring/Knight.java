package org.xander.spring;

public class Knight {
    public Knight() {
    }
    public Knight(Quest quest) {
        this.quest = quest;
    }

    private Quest quest;

    public void embarkOnQuest() {
        quest.embark();
    }
}
