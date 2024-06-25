//Author: Andrea C. Sherry
//Class: CS 320 - 3-2 Milestone
//Date: 05/25/2024
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        contact = new Contact("7698433542", "Gabriel", "Navarrete", "2667823451", "1517 188th St E");
    }

    @Test
    public void testAddContactSuccess() {
        service.addContact(contact);
        assertNotNull(service.getContact("7698433542"));
    }

    @Test
    public void testAddDuplicateContact() {
        service.addContact(contact);
        Contact duplicate = new Contact("7698433542", "Gabriela", "Navarrete", "2657883541", "456 St S");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
        assertEquals("This contact ID already exists. Try again.", exception.getMessage());
    }

    @Test
    public void testDeleteContactSuccess() {
        service.addContact(contact);
        assertNotNull(service.getContact("7698433542"));
        service.deleteContact("7698433542");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("7698433542");
        });
        assertEquals("This contact ID was not found. Try again.", exception.getMessage());
    }

    @Test
    public void testDeleteNonexistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("nonexistentId");
        });
        assertEquals("This contact ID already exists. Try again.", exception.getMessage());
    }

    @Test
    public void testUpdateContactSuccess() {
        service.addContact(contact);
        service.updateContact("7698433542", "Gabriela", "Prieto", "2657883541", "456 St S");
        Contact updatedContact = service.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Prieto", updatedContact.getLastName());
        assertEquals("2657883541", updatedContact.getPhoneNumber());
        assertEquals("456 St S", updatedContact.getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("nonexistentId", "Jane", "Prieto", "2657883541", "456 St S");
        });
        assertEquals("This contact ID was not found. Try again.", exception.getMessage());
    }

    @Test
    public void testGetNonexistentContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("nonexistentId");
        });
        assertEquals("This contact ID was not found. Try again.", exception.getMessage());
    }

    @Test
    public void testPrintAllContacts() {
        service.addContact(contact);
        service.printAllContacts();
        // No assertion needed, just verifying the method runs without errors
    }

    @Test
    public void testAddNullContact() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
        assertEquals("This contact ID already exists. Try again.", exception.getMessage());
    }

    @Test
    public void testDeleteNullContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact(null);
        });
        assertEquals("This contact ID already exists. Try again.", exception.getMessage());
    }

    @Test
    public void testUpdateNullContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(null, "Jane", "Prieto", "2657883541", "456 St S");
        });
        assertEquals("This contact ID was not found. Try again.", exception.getMessage());
    }

    @Test
    public void testGetNullContactId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.getContact(null);
        });
        assertEquals("This contact ID was not found. Try again.", exception.getMessage());
    }
}
