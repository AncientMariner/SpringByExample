package org.xander.springByExample.Part_1.RIF_Code_vs_DI_Code;

public class VotingBoothDI {
    VoteRecorder recorder = null;

    public void setVoteRecorder(VoteRecorder recorder) {
        this.recorder = recorder;
    }

    public void vote(Candidate candidate) {
        recorder.record(candidate);
    }
}
