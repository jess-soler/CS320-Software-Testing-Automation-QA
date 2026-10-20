/*************************************************************************************
 * Name: Jessica Soler
 * Course: CS 320
 * Assignment: Contact Service, Module Three
 * This class manages Contact objects
 * by adding, deleting, and updating contacts using unique contact IDs.
 *************************************************************************************/

import java.util.HashMap;
import java.util.Map;


public class ContactService
{
    // stores contacts using unique contact IDs as keys
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact)
    {
        if (contact == null)
        {
            throw new IllegalArgumentException(
                    "Invalid Contact: cannot be null");
        }

        if (contacts.containsKey(contact.getContactId()))
        {
            throw new IllegalArgumentException(
                    "Invalid Contact ID: already exists");
        }

        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId)
    {
        findContact(contactId);

        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName)
    {
        Contact contact = findContact(contactId);

        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName)
    {
        Contact contact = findContact(contactId);

        contact.setLastName(lastName);
    }

    public void updatePhoneNumber(String contactId, String phoneNumber)
    {
        Contact contact = findContact(contactId);

        contact.setPhoneNumber(phoneNumber);
    }

    public void updateAddress(String contactId, String address)
    {
        Contact contact = findContact(contactId);

        contact.setAddress(address);
    }

    private Contact findContact(String contactId)
    {
        if (contactId == null || contactId.isEmpty())
        {
            throw new IllegalArgumentException(
                    "Invalid Contact ID: cannot be null or empty");
        }

        Contact contact = contacts.get(contactId);

        if (contact == null)
        {
            throw new IllegalArgumentException(
                    "Invalid Contact ID: not found");
        }

        return contact;
    }
}