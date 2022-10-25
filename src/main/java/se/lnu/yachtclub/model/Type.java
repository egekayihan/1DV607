package se.lnu.yachtclub.model;

public enum Type {
    MOTORBOAT("Motor Boat"),
    SAILOR("Sailor"),
    KAYAK("Kayak"),
    OTHER("Other");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}