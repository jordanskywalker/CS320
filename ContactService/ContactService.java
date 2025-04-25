import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private final List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getContactID().equals(contact.getContactID())) {
                throw new IllegalArgumentException("Duplicate contact ID");
            }
        }
        contacts.add(contact);
    }

    public void deleteContact(String contactID) {
        contacts.removeIf(c -> c.getContactID().equals(contactID));
    }

    public void updateFirstName(String contactID, String newFirstName) {
        for (Contact c : contacts) {
            if (c.getContactID().equals(contactID)) {
                c.setFirstName(newFirstName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updateLastName(String contactID, String newLastName) {
        for (Contact c : contacts) {
            if (c.getContactID().equals(contactID)) {
                c.setLastName(newLastName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updatePhoneNumber(String contactID, String newPhoneNumber) {
        for (Contact c : contacts) {
            if (c.getContactID().equals(contactID)) {
                c.setPhoneNumber(newPhoneNumber);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updateAddress(String contactID, String newAddress) {
        for (Contact c : contacts) {
            if (c.getContactID().equals(contactID)) {
                c.setAddress(newAddress);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }
}
