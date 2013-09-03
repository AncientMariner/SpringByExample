package org.xander.springByExample.Part_1.RIF_Code_vs_DI_Code;

import java.util.HashMap;
import java.util.Map;

public class LocalVoteRecorder implements VoteRecorder {
    Map<Candidate, Integer> hVotes = new HashMap();

    public void record(Candidate candidate) {
        int count = 0;
        if (!hVotes.containsKey(candidate)) {
            hVotes.put(candidate, count);
        } else {
            count = hVotes.get(candidate);
        }
        count++;
        hVotes.put(candidate, count);
    }
}

