package se.lnu.yachtclub.model.sequencer;

public class MemberSequencer {
    private int memberSequencer = 10000;

    public int nextMemberId() {
        return memberSequencer++;
    }

    public void setMemberSequencer(int memberSequencer) {
        this.memberSequencer = memberSequencer;
    }
}
