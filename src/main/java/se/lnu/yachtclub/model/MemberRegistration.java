package se.lnu.yachtclub.model;

import se.lnu.yachtclub.model.sequencer.MemberSequencer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRegistration {

    private final JsonIO jsonIO = new JsonIO();
    private final File file = new File("members.json");
    private List<Member> members;

    // fill in the members arrayList by data in members.json
    public MemberRegistration() {
        members = jsonIO.convertJSONToMember(file);
    }

    public MemberRegistration(Member member) {
        members = jsonIO.convertJSONToMember(file);
        int size = members.size();
        MemberSequencer memberSequencer = new MemberSequencer();
        if (size != 0) {
            memberSequencer.setMemberSequencer(members.get(size - 1).getId() + 1);
        }
        member.setId(memberSequencer.nextMemberId());
        List<Boat> boats = new ArrayList<>();
        member.setBoats(boats);
        members.add(member);
        jsonIO.updateJSON(members, file);
    }

    public List<Member> getMemberList() {
        members = jsonIO.convertJSONToMember(file);
        return members;
    }

    public void deleteMember(Member currentMember) {
        members = jsonIO.convertJSONToMember(file);
        members.remove(currentMember);
        jsonIO.updateJSON(members, file);
    }

    public void updateName(int memberId, String name) {
        members = jsonIO.convertJSONToMember(file);
        for (Member member : members) {
            if (member.getId() == memberId) {
                member.setName(name);
            }
        }
        jsonIO.updateJSON(members, file);
    }

    public void updatePersonalNumber(int memberId, String personalNumber) {
        members = jsonIO.convertJSONToMember(file);
        for (Member member : members) {
            if (member.getId() == memberId) {
                member.setPersonalNumber(personalNumber);
            }
        }
        jsonIO.updateJSON(members, file);
    }


    public Member findMemberById(int id) {
        members = jsonIO.convertJSONToMember(file);
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

}

