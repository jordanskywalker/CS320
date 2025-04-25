import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(new Contact("001", "Jane", "Doe", "1234567890", "456 Street"));
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.deleteContact("001");
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("001", "NewName");
        });
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("001", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);

        service.updateFirstName("001", "NewFirst");
        service.updateLastName("001", "NewLast");
        service.updatePhoneNumber("001", "0987654321");
        service.updateAddress("001", "456 Avenue");

        assertEquals("NewFirst", contact.getFirstName());
        assertEquals("NewLast", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertEquals("456 Avenue", contact.getAddress());
    }
}
