package se.lnu.yachtclub.model;

import java.util.Objects;

public class Boat {

    private int id;
    private String type;
    private double length;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return id == boat.id &&
                Double.compare(boat.length, length) == 0 &&
                Objects.equals(type, boat.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, length);
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", length=" + length +
                '}';
    }
}
