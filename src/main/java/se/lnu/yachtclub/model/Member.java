package se.lnu.yachtclub.model;

import java.util.List;
import java.util.Objects;

public class Member {

    private int id;
    private String name;
    private String personalNumber;
    private List<Boat> boats;


    public Member() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public List<Boat> getBoats() {
        return boats;
    }

    public void setBoats(List<Boat> boats) {
        this.boats = boats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name) &&
                Objects.equals(personalNumber, member.personalNumber) &&
                Objects.equals(boats, member.boats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, personalNumber, boats);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", boats=" + boats +
                '}';
    }
}