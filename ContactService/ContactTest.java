import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Street");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Street");
        });
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123", "123 Street");
        });
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Street");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhoneNumber("0987654321");
        contact.setAddress("456 Avenue");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertEquals("456 Avenue", contact.getAddress());
    }
}

