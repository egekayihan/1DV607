package se.lnu.yachtclub.view;

public enum Option {
    // Options
    SIGNUPMEMBER(1, "Sign Up"),
    EDITMEMBER(2, "Edit Member"),
    DELETEMEMBER(3, "Delete Member"),
    REGISTERBOAT(4, "Register Boat"),
    EDITBOAT(5, "Edit Boat"),
    DELETEBOAT(6, "Delete Boat"),
    COMPACTLIST(7, "Compact List"),
    VERBOSELIST(8, "Verbose List"),
    SHOWMEMBERINFO(9,"Show Member Information");


    private final int value;
    private final String option;

    Option(int value, String option) {
        this.value = value;
        this.option = option;
    }

    public String getOption() {
        return this.option;
    }

    public int getValue() {
        return value;
    }
}
