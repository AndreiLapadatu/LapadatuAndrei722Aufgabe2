import Controller.*;
import Model.*;
import Repository.*;
import Service.*;
import View.ConsoleView;

public class Main {
    public static void main(String[] args) {

        MedikamentRepository medikamentRepository = new MedikamentRepository();
        PatientenRepository patientenRepository = new PatientenRepository();

        MedikamentenService medikamentenService = new MedikamentenService(medikamentRepository);
        PatientenService patientenService = new PatientenService(patientenRepository);

        MedikamenteController productController = new MedikamenteController(medikamentenService);
        PatientenController customerController = new Patienten(patientenService);
        ConsoleView consoleView = new ConsoleView(productController, customerController);

        consoleView.start();
    }
}