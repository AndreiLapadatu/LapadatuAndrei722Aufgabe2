package View;

import Controller.MedikamenteController;
import Controller.PatientenController;
import Model.Medikamente;
import Model.Patienten;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;
    private PatientenController patientenController;
    private MedikamenteController medikamenteController;

    public ConsoleView(PatientenController patientenController, MedikamenteController medikamenteController) {
        this.scanner = new Scanner(System.in);
        this.patientenController = patientenController;
        this.medikamenteController = medikamenteController;
    }

    public void start(){
        boolean running = true;
        while(running){
            System.out.println("\n--- KrankenHaus Management ---");
            System.out.println("1. Manage Medicament");
            System.out.println("2. Manage Patient");
            System.out.println("3. Filter Customers by Location");
            System.out.println("4. Find Customers by Product Season");
            System.out.println("5. Sort Customer's Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    manageProducts();
                    break;
                case 2:
                    manageCustomers();
                    break;
                case 3:
                    filterCustomersByLocation();
                    break;
                case 4:
                    sortClientMedicament();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        }
    }

    private void addProduct() {
        System.out.print("Enter medikament name: ");
        String name = scanner.nextLine();
        System.out.print("Enter medikament price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter illnes: ");
        String krank = scanner.nextLine();

        medikamenteController.addMedikament(name, price, krank);
        System.out.println("Product added successfully.");
    }

    private void updateProduct() {
        System.out.print("Enter medikament name to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter  price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter illnes: ");
        String season = scanner.nextLine();

        medikamenteController.updateMedikament(name, price, season);
        System.out.println("Product updated successfully.");
    }

    private void deleteProduct() {
        System.out.print("Enter medikament name to delete: ");
        String name = scanner.nextLine();

        medikamenteController.deleteMedikament(name);
        System.out.println("Medikament deleted successfully.");
    }

    private void viewProduct() {
        System.out.print("Enter product name to view: ");
        String name = scanner.nextLine();

        Medikamente medikament = medikamenteController.getMedikament(name);
        if (medikament != null) {
            System.out.println(medikament);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void viewAllProducts() {
        List<Medikamente> medikamente = medikamenteController.getAllMedikamente();
        if (medikamente.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Medikamente medikament : medikamente) {
                System.out.println(medikament);
            }
        }
    }

    private void manageProducts() {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Manage Products ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product");
            System.out.println("5. View All Products");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    viewProduct();
                    break;
                case 5:
                    viewAllProducts();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageCustomers() {
        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Manage Customers ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. View Customer");
            System.out.println("5. View All Customers");
            System.out.println("6. Add Product to Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    updateCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    viewCustomer();
                    break;
                case 5:
                    viewAllCustomers();
                    break;
                case 6:
                    addProductToCustomer();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void addCustomer() {
        System.out.print("Enter patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter diagnose: ");
        String diagnose = scanner.nextLine();



        patientenController.addPatient(id, name, age, diagnose);
        System.out.println("Patient added successfully.");
    }

    private void updateCustomer() {
        System.out.print("Enter patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        System.out.print("Enter new diagnose: ");
        String diagnose = scanner.nextLine();

        patientenController.updatePatient(id, name, age, diagnose);
        System.out.println("Customer updated successfully.");
    }

    private void deleteCustomer() {
        System.out.print("Enter patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        patientenController.deletePatient(id);
        System.out.println("Patient deleted successfully.");
    }

    private void viewCustomer() {
        System.out.print("Enter patient ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Patienten patienten = patientenController.getPatient(id);
        if (patienten != null) {
            System.out.println(patienten);
        } else {
            System.out.println("Patienten not found.");
        }
    }

    private void viewAllCustomers() {
        List<Patienten> patienten = patientenController.getAllPatienten();
        if (patienten.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Patienten customer : patienten) {
                System.out.println(customer);
            }
        }
    }

    private void addProductToCustomer() {
        System.out.print("Enter patient ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter medikament name: ");
        String productName = scanner.nextLine();

        Medikamente medikament = medikamenteController.getMedikament(productName);
        if (medikament != null) {
            patientenController.addMedikamentToPatient(customerId, medikament);
            System.out.println("Product added to customer successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void filterCustomersByLocation() {
        System.out.print("Enter illness to filter customers: ");
        String krank = scanner.nextLine();

        List<Patienten> filteredCustomers = patientenController.filterClientsByKrank(krank);
        if (filteredCustomers.isEmpty()) {
            System.out.println("No customers found in the specified location.");
        } else {
            for (Patienten customer : filteredCustomers) {
                System.out.println(customer);
            }
        }
    }



    private void sortClientMedicament() {
        System.out.print("Enter patient ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Sort ascending? (true/false): ");
        boolean ascending = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        List<Medikamente> sortedProducts = patientenController.sortPatientenMedikamente(customerId, ascending);
        if (sortedProducts.isEmpty()) {
            System.out.println("No products found for the specified customer.");
        } else {
            for (Medikamente product : sortedProducts) {
                System.out.println(product);
            }
        }
    }
}
