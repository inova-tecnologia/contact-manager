package contactManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;    
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ContactManager implements Serializable {
	private Map<String, String> contacts;

	public ContactManager() {
	    contacts = new HashMap<>();
	}

	public void addContact(String name, String phoneNumber) {
	    contacts.put(name, phoneNumber);
	}

	public void removeContact(String name) {
	    contacts.remove(name);
	}

	public String searchPhoneNumber(String name) {
	    return contacts.get(name);
	}

	public void displayContacts() {
	    System.out.println("Contacts:");
	    for (Map.Entry<String, String> contact : contacts.entrySet()) {
	        System.out.println(contact.getKey() + ": " + contact.getValue());
	    }
	}

	public void saveContactsToFile(String fileName) {
	    try (FileOutputStream fileOut = new FileOutputStream(fileName); ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
	        objOut.writeObject(contacts);
	        System.out.println("Contacts saved successfully!");
	    } catch (IOException e) {
	        System.out.println("Error while saving contacts: " + e.getMessage());
	    }
	}

	public void readContactsFromFile(String fileName) {
	    try (FileInputStream fileIn = new FileInputStream(fileName); ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
	        contacts = (Map<String, String>) objIn.readObject();
	        System.out.println("Contacts read successfully!");
	    } catch (IOException | ClassNotFoundException e) {
	        System.out.println("Error while reading contacts: " + e.getMessage());
	    }
	}
}
