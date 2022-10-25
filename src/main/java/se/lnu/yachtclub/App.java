package se.lnu.yachtclub;

import se.lnu.yachtclub.controller.Controller;
import se.lnu.yachtclub.model.MemberRegistration;
import se.lnu.yachtclub.view.EngConsole;
import se.lnu.yachtclub.view.IConsole;

public class App {

    public static void main(String[] args) {
        // make an instance of MemberRegistration class
        MemberRegistration memberRegistration = new MemberRegistration();
        // call controller
        Controller controller = new Controller();
        // call view
        IConsole iConsole = new EngConsole();

        // the while loop should run until user ask to exit!
        while(controller.start(iConsole, memberRegistration));
    }
}
