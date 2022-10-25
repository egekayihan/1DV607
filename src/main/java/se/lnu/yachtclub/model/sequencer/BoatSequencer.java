package se.lnu.yachtclub.model.sequencer;

public class BoatSequencer {

    private int boatSequencer = 1;

    public int nextBoatId() {
        return boatSequencer++;
    }

    public void setBoatSequencer(int boatSequencer) {
        this.boatSequencer = boatSequencer;
    }
}
