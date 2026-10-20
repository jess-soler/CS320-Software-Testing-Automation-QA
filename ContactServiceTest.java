/************************************************************************************************
 * Name: Jessica Soler
 * Course: CS 320
 * Assignment: Contact Service, Module Three
 * This class tests adding, deleting, and updating contacts through the ContactService class.
 ************************************************************************************************/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("contact")
@Tag("service")
@DisplayName("Contact Service Tests")
class ContactServiceTest
{
    private static final int MAX_NAME_LENGTH = 10;
    private static final int MAX_ADDRESS_LENGTH = 30;

    private ContactService service;
    private Contact alice;
    private Contact bob;

    // creates a new service and contacts before each test
    @BeforeEach
    void setUp()
    {
        service = new ContactService();

        alice = new Contact(
                "1",
                "Alice",
                "Cipher",
                "3085550101",
                "1 Encryption Ln");

        bob = new Contact(
                "2",
                "Bob",
                "Hash",
                "3085550102",
                "2 Firewall Ave");
    }



    @Nested
    @Tag("add")
    @DisplayName("Add Contact")
    class AddContactTests
    {
        @Test
        @DisplayName("Adds a valid contact")
        void testAddContact()
        {
            assertDoesNotThrow(
                    () -> service.addContact(alice));
        }

        @Test
        @DisplayName("Rejects a null contact")
        void testAddNullContact()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.addContact(null));
        }

        @Test
        @DisplayName("Rejects a duplicate contact ID")
        void testAddDuplicateContactId()
        {
            service.addContact(alice);

            Contact duplicate = new Contact(
                    "1",
                    "Bob",
                    "Hash",
                    "3085550102",
                    "2 Firewall Ave");

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.addContact(duplicate));
        }
    }



    @Nested
    @Tag("delete")
    @DisplayName("Delete Contact")
    class DeleteContactTests
    {
        @Test
        @DisplayName("Deletes a contact by ID")
        void testDeleteContact()
        {
            service.addContact(alice);

            service.deleteContact("1");

            assertDoesNotThrow(
                    () -> service.addContact(alice));
        }

        @Test
        @DisplayName("Rejects deleting a null contact ID")
        void testDeleteContactNull()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.deleteContact(null));
        }

        @Test
        @DisplayName("Rejects deleting an empty contact ID")
        void testDeleteContactEmpty()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.deleteContact(""));
        }

        @Test
        @DisplayName("Rejects deleting a contact ID that does not exist")
        void testDeleteContactNotFound()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.deleteContact("99"));
        }
    }



    @Nested
    @Tag("update")
    @DisplayName("Valid Contact Updates")
    class ValidContactUpdateTests
    {
        @Test
        @DisplayName("Updates a contact first name")
        void testUpdateFirstName()
        {
            service.addContact(alice);

            service.updateFirstName("1", "Bob");

            assertEquals("Bob", alice.getFirstName());
        }

        @Test
        @DisplayName("Updates a contact last name")
        void testUpdateLastName()
        {
            service.addContact(alice);

            service.updateLastName("1", "Hash");

            assertEquals("Hash", alice.getLastName());
        }

        @Test
        @DisplayName("Updates a contact phone number")
        void testUpdatePhoneNumber()
        {
            service.addContact(alice);

            service.updatePhoneNumber(
                    "1",
                    "3085550102");

            assertEquals(
                    "3085550102",
                    alice.getPhoneNumber());
        }

        @Test
        @DisplayName("Updates a contact address")
        void testUpdateAddress()
        {
            service.addContact(alice);

            service.updateAddress(
                    "1",
                    "2 Firewall Ave");

            assertEquals(
                    "2 Firewall Ave",
                    alice.getAddress());
        }

        @Test
        @DisplayName("Updates only the contact matching the specified ID")
        void testUpdateCorrectContactById()
        {
            service.addContact(alice);
            service.addContact(bob);

            service.updateFirstName(
                    "2",
                    "Robert");

            assertAll(
                    () -> assertEquals(
                            "Alice",
                            alice.getFirstName()),
                    () -> assertEquals(
                            "Robert",
                            bob.getFirstName())
            );
        }
    }



    @Nested
    @Tag("update")
    @DisplayName("Invalid Contact Updates")
    class InvalidContactUpdateTests
    {
        @Test
        @DisplayName("Rejects a null first name during a service update")
        void testUpdateNullFirstName()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateFirstName(
                            "1",
                            null));
        }

        @Test
        @DisplayName("Rejects an empty first name during a service update")
        void testUpdateEmptyFirstName()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateFirstName(
                            "1",
                            ""));
        }

        @Test
        @DisplayName("Rejects a first name longer than 10 characters during a service update")
        void testUpdateInvalidFirstName()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateFirstName(
                            "1",
                            "A".repeat(MAX_NAME_LENGTH + 1)));
        }

        @Test
        @DisplayName("Rejects a null last name during a service update")
        void testUpdateNullLastName()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateLastName(
                            "1",
                            null));
        }

        @Test
        @DisplayName("Rejects an empty last name during a service update")
        void testUpdateEmptyLastName()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateLastName(
                            "1",
                            ""));
        }

        @Test
        @DisplayName("Rejects a last name longer than 10 characters during a service update")
        void testUpdateInvalidLastName()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateLastName(
                            "1",
                            "A".repeat(MAX_NAME_LENGTH + 1)));
        }

        @Test
        @DisplayName("Rejects a null phone number during a service update")
        void testUpdateNullPhoneNumber()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updatePhoneNumber(
                            "1",
                            null));
        }

        @Test
        @DisplayName("Rejects an empty phone number during a service update")
        void testUpdateEmptyPhoneNumber()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updatePhoneNumber(
                            "1",
                            ""));
        }

        @Test
        @DisplayName("Rejects an invalid phone number during a service update")
        void testUpdateInvalidPhoneNumber()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updatePhoneNumber(
                            "1",
                            "12345"));
        }

        @Test
        @DisplayName("Rejects a null address during a service update")
        void testUpdateNullAddress()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateAddress(
                            "1",
                            null));
        }

        @Test
        @DisplayName("Rejects an empty address during a service update")
        void testUpdateEmptyAddress()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateAddress(
                            "1",
                            ""));
        }

        @Test
        @DisplayName("Rejects an address longer than 30 characters during a service update")
        void testUpdateInvalidAddress()
        {
            service.addContact(alice);

            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateAddress(
                            "1",
                            "A".repeat(MAX_ADDRESS_LENGTH + 1)));
        }

        @Test
        @DisplayName("Rejects an update when the contact ID does not exist")
        void testUpdateContactNotFound()
        {
            assertThrows(
                    IllegalArgumentException.class,
                    () -> service.updateFirstName(
                            "99",
                            "Bob"));
        }
    }
}