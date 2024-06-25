//Author: Andrea C. Sherry
//Class: CS 320 - 3-2 Milestone
//Date: 05/23/2024
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test creating a contact with valid inputs
    @Test
    public void testContactCreationSuccess() {
        Contact contact = new Contact("76984", "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        assertEquals("76984", contact.getContactID());
        assertEquals("Gabriel", contact.getFirstName());
        assertEquals("Navarrete", contact.getLastName());
        assertEquals("2667823451", contact.getPhoneNumber());
        assertEquals("1517 St E, Arlington, USA", contact.getAddress());
    }

    // Test creating a contact with invalid contact ID
    @Test
    public void testContactCreationFailureContactID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        });
        assertEquals("Contact ID cannot be null and must be 10 characters or less.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("769847144267", "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        });
        assertEquals("Contact ID cannot be null and must be 10 characters or less.", exception.getMessage());
    }

    // Test creating a contact with invalid first name
    @Test
    public void testContactCreationFailureFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", null, "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        });
        assertEquals("First name cannot be null and must be 10 characters or less.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabrieldelacruzsantos", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        });
        assertEquals("First name cannot be null and must be 10 characters or less.", exception.getMessage());
    }

    // Test creating a contact with invalid last name
    @Test
    public void testContactCreationFailureLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabriel", null, "2667823451", "1517 St E, Arlington, USA");
        });
        assertEquals("Last name cannot be null and must be 10 characters or less.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabriel", "NavarretePrieto", "2667823451", "1517 St E, Arlington, USA");
        });
        assertEquals("Last name cannot be null and must be 10 characters or less.", exception.getMessage());
    }

    // Test creating a contact with invalid phone number
    @Test
    public void testContactCreationFailurePhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabriel", "Navarrete", null, "1517 St E, Arlington, USA");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabriel", "Navarrete", "2667823", "1517 St E, Arlington, USA");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabriel", "Navarrete", "26678234518642", "1517 St E, Arlington, USA");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());
    }

    // Test creating a contact with invalid address
    @Test
    public void testContactCreationFailureAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabriel", "Navarrete", "2667823451", null);
        });
        assertEquals("Address cannot be null and must be 30 characters or less.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("76984", "Gabriel", "Navarrete", "2667823451", "1517 188th St E, Arlington, United States of America");
        });
        assertEquals("Address cannot be null and must be 30 characters or less.", exception.getMessage());
    }

    // Test setting a valid first name
    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("76984", "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        contact.setFirstName("Gabriell");
        assertEquals("Gabriell", contact.getFirstName());
        
        // Test null first name - Invalid
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertEquals("First name cannot be null and must be no longer than 10 characters.", exception.getMessage());

        // Test too long first name - Invalid
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("GabrielaNavarretePrieto");
        });
        assertEquals("First name cannot be null and must be no longer than 10 characters.", exception.getMessage());
    }

    // Test setting a valid last name
    @Test
    public void testSetLastName() {
        Contact contact = new Contact("76984", "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        contact.setLastName("Prieto");
        assertEquals("Prieto", contact.getLastName());
        
        // Test null last name - Invalid
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertEquals("Last name cannot be null and must be no longer than 10 characters.", exception.getMessage());

        // Test too long last name - Invalid
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("NavarretePrietoGabriel");
        });
        assertEquals("Last name cannot be null and must be no longer than 10 characters.", exception.getMessage());
    }

    // Test setting a valid phone number
    @Test
    public void testSetPhoneNumber() {
        Contact contact = new Contact("76984", "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        contact.setPhoneNumber("2667823422");
        assertEquals("2667823422", contact.getPhoneNumber());
        
        // Test too short phone number - Invalid
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("266782");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());

        // Test too long phone number - Invalid
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhoneNumber("266782345156654");
        });
        assertEquals("Phone number cannot be null and must be exactly 10 digits.", exception.getMessage());
    }

    // Test setting a valid address
    @Test
    public void testSetAddress() {
        Contact contact = new Contact("76984", "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        contact.setAddress("277 Ct E, Harlem, USA");
        assertEquals("277 Ct E, Harlem, USA", contact.getAddress());
        
        // Test setting null address - Invalid
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
        assertEquals("Address cannot be null and must be no longer than 30 characters.", exception.getMessage());

        // Test too long address - Invalid
        exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1517 133th Street East, Arlington, United States of America");
        });
        assertEquals("Address cannot be null and must be no longer than 30 characters.", exception.getMessage());
    }

    // Test the getters
    @Test
    public void testGetters() {
        Contact contact = new Contact("76984", "Gabriel", "Navarrete", "2667823451", "1517 St E, Arlington, USA");
        assertEquals("76984", contact.getContactID());
        assertEquals("Gabriel", contact.getFirstName());
        assertEquals("Navarrete", contact.getLastName());
        assertEquals("2667823451", contact.getPhoneNumber());
        assertEquals("1517 St E, Arlington, USA", contact.getAddress());
    }
}