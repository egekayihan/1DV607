package se.lnu.yachtclub.model;

import se.lnu.yachtclub.model.sequencer.BoatSequencer;

import java.io.File;
import java.util.List;

public class BoatRegistration {

    private List<Boat> boats;
    private final List<Member> members;
    private final JsonIO jsonIO = new JsonIO();
    private final File file = new File("members.json");

    public BoatRegistration(Member member) {
        boats = member.getBoats();
        members = jsonIO.convertJSONToMember(file);
    }

    public BoatRegistration(Member member, Boat boat) {
        members = jsonIO.convertJSONToMember(file);
        boats = member.getBoats();
        int size = boats.size() - 1;
        BoatSequencer boatSequencer = new BoatSequencer();
        if (boats.size() != 0) {
            boatSequencer.setBoatSequencer(boats.get(size).getId() + 1);
        }
        boat.setId(boatSequencer.nextBoatId());
        boats.add(boat);
        for (Member member1 : members) {
            if (member1.getId() == member.getId()) {
                member1.setBoats(member.getBoats());
            }
        }
        jsonIO.updateJSON(members, file);
    }

    public Boat findBoatById(int id) {
        for (Boat boat : boats) {
            if (boat.getId() == id) {
                return boat;
            }
        }
        return null;
    }

    public void deleteBoat(Member member, Boat boat) {
        boats = member.getBoats();
        boats.remove(boat);
        for (Member member1 : members) {
            if (member1.getId() == member.getId()) {
                member1.setBoats(boats);
            }
        }
        jsonIO.updateJSON(members, file);
    }

    public void updateBoat(Boat boat, Member member) {
        for (Boat boat1 : boats) {
            if (boat.getId() == boat1.getId()) {
                boat1.setType(boat.getType());
                boat1.setLength(boat.getLength());
            }
            System.out.println(boat1.toString());
        }

        for (Member member1 : members) {
            if (member.getId() == member1.getId()) {
                member1.setBoats(boats);
            }
            System.out.println(member1.toString());
        }
        jsonIO.updateJSON(members, file);
    }

}
