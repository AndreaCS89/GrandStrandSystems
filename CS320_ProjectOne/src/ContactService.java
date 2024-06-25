//Author: Andrea C. Sherry
//Class: CS 320 - 3-2 Milestone
//Date: 05/24/2024
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;  //Create map to store contacts with string contactID

    //Start ContactService
    public ContactService() {
        contacts = new HashMap<>();
    }

    //Method: add contact to service
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("This contact ID already exists. Try again.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    //Method: delete contact through contactID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("This contact ID already exists. Try again.");
        }
        contacts.remove(contactID);
    }

    //Method: update contact details through contactID
    public void updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("This contact ID was not found. Try again.");
        }
        Contact contact = contacts.get(contactID);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contact.setAddress(address);
    }

    //Method: retrieve contact through contactID
    public Contact getContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("This contact ID was not found. Try again.");
        }
        return contacts.get(contactID);
    }

    //Method: print contacts
    public void printAllContacts() {
        for (Contact contact : contacts.values()) {
            System.out.println("Contact ID: " + contact.getContactID());
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Address: " + contact.getAddress());
            System.out.println();
        }
    }
}