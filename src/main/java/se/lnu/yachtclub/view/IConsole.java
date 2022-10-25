package se.lnu.yachtclub.view;

public interface IConsole {

    void welcomeMessage();

    void showMenu();

    Option userOption();

    int getMenuAction();

    int getUserInput(int min, int max);

    void compactList(int memberId, String memberName, int numberOfBoats);

    void verboseList(String memberName, String memberPersonalNumber, int memberId);

    // MemberView

    int editMemberInfo();

    String getMemberName();

    String getPersonalNumber();

    void memberNotExist();

    int getMemberId();

    void showMember(String memberName, String memberPersonalNumber, int memberId);


    // Boats


    int getBoatList(int lastBoatId);

    void showMemberBoats(int boatId, String boatType, double boatLength);

    int getBoatType();

    int getBoatLength();

    int editBoatInfo();

}
