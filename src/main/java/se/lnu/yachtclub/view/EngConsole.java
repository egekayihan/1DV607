package se.lnu.yachtclub.view;

import se.lnu.yachtclub.model.Type;

import java.util.*;

public class EngConsole implements IConsole {

    // constructor
    public EngConsole() {

    }

    public void welcomeMessage() {
        System.out.println("Welcome!");
        System.out.println("Type 'Exit' to quit the game.\n");

    }

    public void showMenu() {
        for (Option option : Option.values()) {
            System.out.println(option.getValue() + " " + option.getOption());
        }
    }


    // get user menu selection
    public Option userOption() {
        Option option = null;
        int action = getMenuAction();
        return option.values()[action - 1];

    }

    // check user menu selection
    public int getMenuAction() {
        Scanner scanner;
        int chosenMenu;

        while (true) {
            scanner = new Scanner(System.in);
            String selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("Exit")) {
                System.out.println("Bye bye!");
                System.exit(0);
            }

            // exception handling
            try {
                chosenMenu = Integer.valueOf(selection);
                // check if the user selected the right option
                if (chosenMenu < 1 || chosenMenu > 9) {
                    System.err.println("Please enter a number between 1 & 8.");
                } else
                    return chosenMenu;
            } catch (NumberFormatException n) {
                // check if the user input is an Integer
                System.out.println("\nNot a number, please enter an Integer\n");
            }
        }
    }

    // method to give user option to choose numbers between 2 numbers we want
    public int getUserInput(int min, int max) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int number = scanner.nextInt();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Wrong input please try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please choose an Integer");
            }
        }
    }

    // Member implementation

    // show member info after registration
    public void showMember(String memberName, String memberPersonalNumber, int memberId) {
        System.out.println("**Logged in**");
        System.out.println("Your Name: " + memberName + "\nYour Personal Number: " + memberPersonalNumber + "\nYour ID: " + memberId);
        System.out.println("**Member ID is needed to have access to your account so please keep it in mind!**");
    }

    public int editMemberInfo() {
        System.out.println("What do you want to edit?\n" +
                "1. Name\n2. Personal number");
        return getUserInput(1, 2);
    }

    public String getMemberName() {
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            if (name.length() < 2) {
                System.out.println("Your name should contain at least 2 characters!");
            } else {
                return name;
            }
        }
    }

    public String getPersonalNumber() {
        while (true) {
            try {
                System.out.println("Please enter 6 or 8 digit Personal Number(Your date of birth (YYYYMMDD)/(YYMMDD)):");
                while (true) {
                    String personalNumber = new Scanner(System.in).nextLine();
                    if (personalNumber.length() == 6 || personalNumber.length() == 8) {
                        return personalNumber;
                    } else {
                        System.out.println("Please put a valid social security number!");
                    }
                }
            } catch (InputMismatchException i) {
                System.out.println("That is not a number, please try again.");
            }
        }
    }

    public int getMemberId() {
        while (true) {
            try {
                System.out.println("Please enter your Member ID:");
                return new Scanner(System.in).nextInt();
            } catch (InputMismatchException i) {
                // TODO: 11/7/2020 check if it is just checking the number is integer.  
                System.out.println("That is not a number, please try again.");
            }
        }
    }

    // message to show the user does not exist
    public void memberNotExist() {
        System.err.println("There is no member with this id!");
    }


    // Boat implementation

    // show the list od member's boat
    public int getBoatList(int lastId) {
        System.out.println("Enter the boat id:");
        return getUserInput(1, lastId);
    }

    public int getBoatLength() {
        System.out.println("Please enter boat length in cm: ");
        return getUserInput(1, 20000);
    }

    public int editBoatInfo() {
        System.out.println("What do you wanna edit?\n" +
                "1. Boat type \n2. Boat Length");
        return getUserInput(1, 2);
    }

    public void showMemberBoats(int boatId, String boatType, double boatLength) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Boat ID: " + boatId + "\nBoat type: " + boatType + "\nBoat Length: " + boatLength);
    }

    // get boat type and check if it's between the options
    public int getBoatType() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Type> types = Arrays.asList(Type.values());
        for (int i = 1; i <= types.size(); i++) {
            stringBuilder.append(i).append(") ")
                    .append(types.get(i - 1).getValue());
            if (i != types.size()) {
                stringBuilder.append(", ");
            }
        }

        System.out.println(stringBuilder.toString());

        return getUserInput(1, types.size()) - 1;
    }

    public void compactList(int memberId, String memberName, int numberOfBoats) {
        System.out.println("####################################");
        System.out.println("Member ID: " + memberId + "\nYour name: " + memberName + "\nNumber of boats: " + numberOfBoats);

    }

    public void verboseList(String memberName, String memberPersonalNumber, int memberId) {
        System.out.println("************************************");
        System.out.println("Member ID: " + memberId + "\nYour Name: " + memberName + "\nYour Personal Number: " + memberPersonalNumber);

    }

}
