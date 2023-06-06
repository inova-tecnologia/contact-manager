package contactManager;

import java.util.Scanner;

public class Main {

	   public static void main(String[] args) {
		   
			ContactManager manager = new ContactManager();
			Scanner scanner = new Scanner(System.in);

			while (true) {
			    System.out.println("\nSelect an option:");
			    System.out.println("");
			    System.out.println("1 - Add contact");
			    System.out.println("2 - Remove contact");
			    System.out.println("3 - Search by phone number");
			    System.out.println("4 - Display the contacts list");
			    System.out.println("5 - Save contacts into a file");
			    System.out.println("6 - Read contacts from a file");
			    System.out.println("0 - Exit");

			    int option = scanner.nextInt();
			    scanner.nextLine();

			    switch (option) {
			        case 1:
			            System.out.println("Enter the contact´s name:");
			            String name = scanner.nextLine();
			            System.out.println("Enter the contact´s phone number:");
			            String phoneNumber = scanner.nextLine();
			            manager.addContact(name, phoneNumber);
			            System.out.println("Contact added successfully!");
			            break;
			        case 2:     
			            System.out.println("Enter the contact´s name to be removed:");
			            name = scanner.nextLine();
			            manager.removeContact(name);
			            System.out.println("Contact removed successfully!");
			            break;
			        case 3:
			            System.out.println("Enter the contact´s name to be searched:");
			            name = scanner.nextLine();
			            String number = manager.searchPhoneNumber(name);
			            if (number != null) {
			                System.out.println("Phone number: " + number);
			            } else {
			                System.out.println("The contact was not found.");
			            }
			            break;
			        case 4:
			            manager.displayContacts();
			            break;
			        case 5:
			            System.out.println("Enter the file directory name to save the contact´s list:");
			            String saveFile = scanner.nextLine();
			            manager.saveContactsToFile(saveFile);
			            break;
			        case 6:
			            System.out.println("Enter the file directory name to read the contacts from:");
			            String readFile = scanner.nextLine();
			            manager.readContactsFromFile(readFile);
			            break;
			        case 0:
			            System.out.println("Exiting the program...");
			            return;
			        default:
			            System.out.println("Invalid option. Please try again.");
			            break;
			    }     
			}
	    }
}
