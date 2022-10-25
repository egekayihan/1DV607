package se.lnu.yachtclub.controller;

import se.lnu.yachtclub.model.*;
import se.lnu.yachtclub.view.IConsole;
import se.lnu.yachtclub.view.Option;

public class Controller {
    private IConsole console;
    private MemberRegistration memberRegistration;
    private BoatRegistration boatRegistration;

    public boolean start(IConsole console, MemberRegistration memberRegistration) {
        this.console = console;
        this.memberRegistration = memberRegistration;
        console.welcomeMessage();
        console.showMenu();
        return getMenu();
    }

    private boolean getMenu() {
        Option option = console.userOption();

        switch (option) {
            case SIGNUPMEMBER:
                return getMemberInfo();
            case COMPACTLIST:
                return compactList();
            case EDITMEMBER:
                return editMember();
            case DELETEMEMBER:
                return deleteMember();
            case VERBOSELIST:
                return verboseList();
            case REGISTERBOAT:
                return addBoat();
            case EDITBOAT:
                return editBoatInfo();
            case DELETEBOAT:
                return deleteBoat();
            case SHOWMEMBERINFO:
                return showMemberInfo();
            default:
                return false;
        }
    }

    private boolean getMemberInfo() {
        Member member = new Member();
        member.setName(console.getMemberName());
        member.setPersonalNumber(console.getPersonalNumber());
        memberRegistration = new MemberRegistration(member);
        console.showMember(member.getName(), member.getPersonalNumber(), member.getId());
        return true;

    }

    private boolean addBoat() {
        int memberId = console.getMemberId();
        Member member = memberRegistration.findMemberById(memberId);
        if (member == null) {
            console.memberNotExist();
            return start();
        } else {
            Boat boat = new Boat();
            boat.setType(Type.values()[console.getBoatType()].getValue());
            boat.setLength(console.getBoatLength());
            boatRegistration = new BoatRegistration(member, boat);
        }
        return true;
    }

    private boolean deleteMember() {
        int memberId = console.getMemberId();
        Member member = memberRegistration.findMemberById(memberId);
        if (member != null) {
            memberRegistration.deleteMember(member);
            return true;
        } else {
            console.memberNotExist();
            return start();
        }
    }

    private boolean editMember() {
        int memberId = console.getMemberId();
        Member member = memberRegistration.findMemberById(memberId);
        if (member != null) {
            int userInput = console.editMemberInfo();

            if (userInput == 1) {
                memberRegistration.updateName(memberId, console.getMemberName());
                return true;
            } else if (userInput == 2) {
                memberRegistration.updatePersonalNumber(memberId, console.getPersonalNumber());
                return true;
            } else {
                return false;
            }
        } else {
            console.memberNotExist();
            return start();
        }
    }

    private boolean editBoatInfo() {
        int memberId = console.getMemberId();
        Member member = memberRegistration.findMemberById(memberId);
        if (member == null) {
            console.memberNotExist();
            return start();
        }
        for (Boat boat : member.getBoats()) {
            console.showMemberBoats(boat.getId(), boat.getType().toString(), boat.getLength());
        }
        int size = member.getBoats().size();
        int boatId = console.getBoatList(member.getBoats().get(size - 1).getId());
        boatRegistration = new BoatRegistration(member);
        Boat boat = boatRegistration.findBoatById(boatId);
        int userInput = console.editBoatInfo();
        if (userInput == 1) {
            int newType = console.getBoatType();
            boat.setType(Type.values()[newType].getValue());
        } else if (userInput == 2) {
            double newLength = console.getBoatLength();
            boat.setLength(newLength);
        }
        System.out.println(boat.toString() + "\n" + member.toString());
        boatRegistration.updateBoat(boat, member);
        return true;
    }

    private boolean deleteBoat() {
        int memberId = console.getMemberId();
        Member member = memberRegistration.findMemberById(memberId);
        if (member == null) {
            console.memberNotExist();
            return start();
        }
        for (Boat boat : member.getBoats()) {
            console.showMemberBoats(boat.getId(), boat.getType().toString(), boat.getLength());
        }
        int size = member.getBoats().size();
        int boatId = console.getBoatList(member.getBoats().get(size - 1).getId());
        boatRegistration = new BoatRegistration(member);
        Boat boat = boatRegistration.findBoatById(boatId);
        boatRegistration.deleteBoat(member, boat);

        return true;
    }


    private boolean compactList() {
        for (Member member : memberRegistration.getMemberList()) {
            console.compactList(member.getId(), member.getName(), member.getBoats().size());
        }
        return true;
    }

    private boolean verboseList() {
        for (Member member : memberRegistration.getMemberList()) {
            console.verboseList(member.getName(), member.getPersonalNumber(), member.getId());
            for (Boat boat : member.getBoats()) {
                console.showMemberBoats(boat.getId(), boat.getType().toString(), boat.getLength());
            }
        }
        return true;
    }

    private boolean showMemberInfo() {
        int memberId = console.getMemberId();
        Member member = memberRegistration.findMemberById(memberId);
        if (member == null) {
            console.memberNotExist();
            return start();
        }
        console.showMember(member.getName(), member.getPersonalNumber(), member.getId());
        for (Boat boat : member.getBoats()) {
            console.showMemberBoats(boat.getId(), boat.getType(), boat.getLength());
        }
        return true;
    }


    public boolean start() {
        return start(this.console, this.memberRegistration);
    }

}
