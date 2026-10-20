/************************************************************************************************
 * Name: Jessica Soler
 * Course: CS 320
 * Assignment: Contact Service, Module Three
 * This class tests Contact creation, validation, boundary values, and update behavior.
 ************************************************************************************************/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("contact")
@DisplayName("Contact Class Tests")
class ContactTest
{
    private static final int MAX_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 10;
    private static final int PHONE_LENGTH = 10;
    private static final int MAX_ADDRESS_LENGTH = 30;

    // creates a valid contact for setter and update tests
    private Contact createValidContact()
    {
        return new Contact(
                "1",
                "Alice",
                "Cipher",
                "3085550101",
                "1 Encryption Ln");
    }

    // creates a contact using the ID passed in
    private Contact createContactWithID(String contactId)
    {
        return new Contact(
                contactId,
                "Alice",
                "Cipher",
                "3085550101",
                "1 Encryption Ln");
    }

    // creates a contact using the first name passed in
    private Contact createContactWithFirstName(String firstName)
    {
        return new Contact(
                "1",
                firstName,
                "Cipher",
                "3085550101",
                "1 Encryption Ln");
    }

    // creates a contact using the last name passed in
    private Contact createContactWithLastName(String lastName)
    {
        return new Contact(
                "1",
                "Alice",
                lastName,
                "3085550101",
                "1 Encryption Ln");
    }

    // creates a contact using the phone number passed in
    private Contact createContactWithPhoneNumber(String phoneNumber)
    {
        return new Contact(
                "1",
                "Alice",
                "Cipher",
                phoneNumber,
                "1 Encryption Ln");
    }

    // creates a contact using the address passed in
    private Contact createContactWithAddress(String address)
    {
        return new Contact(
                "1",
                "Alice",
                "Cipher",
                "3085550101",
                address);
    }

    @Test
    @DisplayName("Creates a valid contact and stores all required values")
    void testContactCreation()
    {
        Contact contact = createValidContact();

        assertAll(
                () -> assertEquals("1", contact.getContactId()),
                () -> assertEquals("Alice", contact.getFirstName()),
                () -> assertEquals("Cipher", contact.getLastName()),
                () -> assertEquals("3085550101", contact.getPhoneNumber()),
                () -> assertEquals("1 Encryption Ln", contact.getAddress())
        );
    }



    @Nested
    @Tag("validation")
    @DisplayName("Contact ID Validation")
    class ContactIdTests
    {
        @Test
        @DisplayName("Rejects a null contact ID")
        void testContactIdNull()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithID(null));
        }

        @Test
        @DisplayName("Rejects an empty contact ID")
        void testContactIdEmpty()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithID(""));
        }

        @Test
        @DisplayName("Rejects a contact ID longer than 10 characters")
        void testContactIdLong()
        {
            String contactId = "1".repeat(MAX_ID_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithID(contactId));
        }

        @Test
        @DisplayName("Accepts a contact ID with exactly 10 characters")
        void testContactIdBoundary()
        {
            String contactId = "1".repeat(MAX_ID_LENGTH);

            Contact contact = createContactWithID(contactId);

            assertEquals(contactId, contact.getContactId());
        }
    }



    @Nested
    @Tag("validation")
    @DisplayName("First Name Validation")
    class FirstNameTests
    {
        @Test
        @DisplayName("Rejects a null first name in the constructor")
        void testFirstNameNull()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithFirstName(null));
        }

        @Test
        @DisplayName("Rejects an empty first name in the constructor")
        void testFirstNameEmpty()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithFirstName(""));
        }

        @Test
        @DisplayName("Rejects a first name longer than 10 characters")
        void testFirstNameLong()
        {
            String firstName = "A".repeat(MAX_NAME_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithFirstName(firstName));
        }

        @Test
        @DisplayName("Rejects a null first name during an update")
        void testSetFirstNameNull()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setFirstName(null));
        }

        @Test
        @DisplayName("Rejects an empty first name during an update")
        void testSetFirstNameEmpty()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setFirstName(""));
        }

        @Test
        @DisplayName("Rejects a first name longer than 10 characters during an update")
        void testSetFirstNameLong()
        {
            Contact contact = createValidContact();
            String firstName = "A".repeat(MAX_NAME_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setFirstName(firstName));
        }

        @Test
        @DisplayName("Accepts a 10-character first name during an update")
        void testSetFirstNameBoundary()
        {
            Contact contact = createValidContact();
            String firstName = "A".repeat(MAX_NAME_LENGTH);

            contact.setFirstName(firstName);

            assertEquals(firstName, contact.getFirstName());
        }
    }



    @Nested
    @Tag("validation")
    @DisplayName("Last Name Validation")
    class LastNameTests
    {
        @Test
        @DisplayName("Rejects a null last name in the constructor")
        void testLastNameNull()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithLastName(null));
        }

        @Test
        @DisplayName("Rejects an empty last name in the constructor")
        void testLastNameEmpty()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithLastName(""));
        }

        @Test
        @DisplayName("Rejects a last name longer than 10 characters")
        void testLastNameLong()
        {
            String lastName = "A".repeat(MAX_NAME_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithLastName(lastName));
        }

        @Test
        @DisplayName("Rejects a null last name during an update")
        void testSetLastNameNull()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setLastName(null));
        }

        @Test
        @DisplayName("Rejects an empty last name during an update")
        void testSetLastNameEmpty()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setLastName(""));
        }

        @Test
        @DisplayName("Rejects a last name longer than 10 characters during an update")
        void testSetLastNameLong()
        {
            Contact contact = createValidContact();
            String lastName = "A".repeat(MAX_NAME_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setLastName(lastName));
        }

        @Test
        @DisplayName("Accepts a 10-character last name during an update")
        void testSetLastNameBoundary()
        {
            Contact contact = createValidContact();
            String lastName = "A".repeat(MAX_NAME_LENGTH);

            contact.setLastName(lastName);

            assertEquals(lastName, contact.getLastName());
        }
    }



    @Nested
    @Tag("validation")
    @DisplayName("Phone Number Validation")
    class PhoneNumberTests
    {
        @Test
        @DisplayName("Rejects a null phone number in the constructor")
        void testPhoneNumberNull()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithPhoneNumber(null));
        }

        @Test
        @DisplayName("Rejects an empty phone number in the constructor")
        void testPhoneNumberEmpty()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithPhoneNumber(""));
        }

        @Test
        @DisplayName("Rejects a phone number shorter than 10 digits")
        void testPhoneNumberShort()
        {
            String phoneNumber = "1".repeat(PHONE_LENGTH - 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithPhoneNumber(phoneNumber));
        }

        @Test
        @DisplayName("Rejects a phone number longer than 10 digits")
        void testPhoneNumberLong()
        {
            String phoneNumber = "1".repeat(PHONE_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithPhoneNumber(phoneNumber));
        }

        @Test
        @DisplayName("Rejects a phone number containing letters")
        void testPhoneNumberWithLetters()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithPhoneNumber("12345abcde"));
        }

        @Test
        @DisplayName("Rejects a null phone number during an update")
        void testSetPhoneNumberNull()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setPhoneNumber(null));
        }

        @Test
        @DisplayName("Rejects an empty phone number during an update")
        void testSetPhoneNumberEmpty()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setPhoneNumber(""));
        }

        @Test
        @DisplayName("Rejects a phone number shorter than 10 digits during an update")
        void testSetPhoneNumberShort()
        {
            Contact contact = createValidContact();
            String phoneNumber = "1".repeat(PHONE_LENGTH - 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setPhoneNumber(phoneNumber));
        }

        @Test
        @DisplayName("Rejects a phone number longer than 10 digits during an update")
        void testSetPhoneNumberLong()
        {
            Contact contact = createValidContact();
            String phoneNumber = "1".repeat(PHONE_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setPhoneNumber(phoneNumber));
        }

        @Test
        @DisplayName("Rejects letters in a phone number during an update")
        void testSetPhoneNumberWithLetters()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setPhoneNumber("12345abcde"));
        }

        @Test
        @DisplayName("Accepts a valid 10-digit phone number during an update")
        void testSetPhoneNumberValid()
        {
            Contact contact = createValidContact();

            contact.setPhoneNumber("3085550102");

            assertEquals("3085550102", contact.getPhoneNumber());
        }
    }



    @Nested
    @Tag("validation")
    @DisplayName("Address Validation")
    class AddressTests
    {
        @Test
        @DisplayName("Rejects a null address in the constructor")
        void testAddressNull()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithAddress(null));
        }

        @Test
        @DisplayName("Rejects an empty address in the constructor")
        void testAddressEmpty()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithAddress(""));
        }

        @Test
        @DisplayName("Rejects an address longer than 30 characters")
        void testAddressLong()
        {
            String address = "A".repeat(MAX_ADDRESS_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> createContactWithAddress(address));
        }

        @Test
        @DisplayName("Rejects a null address during an update")
        void testSetAddressNull()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setAddress(null));
        }

        @Test
        @DisplayName("Rejects an empty address during an update")
        void testSetAddressEmpty()
        {
            Contact contact = createValidContact();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setAddress(""));
        }

        @Test
        @DisplayName("Rejects an address longer than 30 characters during an update")
        void testSetAddressLong()
        {
            Contact contact = createValidContact();
            String address = "A".repeat(MAX_ADDRESS_LENGTH + 1);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.setAddress(address));
        }

        @Test
        @DisplayName("Accepts a 30-character address during an update")
        void testSetAddressBoundary()
        {
            Contact contact = createValidContact();
            String address = "A".repeat(MAX_ADDRESS_LENGTH);

            contact.setAddress(address);

            assertEquals(
                    address,
                    contact.getAddress());
        }
    }



    @Nested
    @Tag("boundary")
    @DisplayName("Constructor Boundary Values")
    class BoundaryValueTests
    {
        @Test
        @DisplayName("Accepts values at each maximum allowed boundary")
        void testContactBoundaryValues()
        {
            String contactId = "1".repeat(MAX_ID_LENGTH);
            String firstName = "A".repeat(MAX_NAME_LENGTH);
            String lastName = "B".repeat(MAX_NAME_LENGTH);
            String phoneNumber = "1".repeat(PHONE_LENGTH);
            String address = "A".repeat(MAX_ADDRESS_LENGTH);

            Contact contact = new Contact(
                    contactId,
                    firstName,
                    lastName,
                    phoneNumber,
                    address);

            assertAll(
                    () -> assertEquals(contactId, contact.getContactId()),
                    () -> assertEquals(firstName, contact.getFirstName()),
                    () -> assertEquals(lastName, contact.getLastName()),
                    () -> assertEquals(phoneNumber, contact.getPhoneNumber()),
                    () -> assertEquals(address, contact.getAddress())
            );
        }
    }



    @Nested
    @Tag("update")
    @DisplayName("Valid Contact Updates")
    class ContactUpdateTests
    {
        @Test
        @DisplayName("Updates contact information without changing contact ID")
        void testContactUpdates()
        {
            Contact contact = createValidContact();

            contact.setFirstName("Bob");
            contact.setLastName("Hash");
            contact.setPhoneNumber("3085550102");
            contact.setAddress("2 Firewall Ave");

            assertAll(
                    () -> assertEquals("1", contact.getContactId()),
                    () -> assertEquals("Bob", contact.getFirstName()),
                    () -> assertEquals("Hash", contact.getLastName()),
                    () -> assertEquals("3085550102", contact.getPhoneNumber()),
                    () -> assertEquals("2 Firewall Ave", contact.getAddress())
            );
        }
    }
}