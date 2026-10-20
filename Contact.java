/*************************************************************************************
 * Name: Jessica Soler
 * Course: CS 320
 * Assignment: Contact Service, Module Three
 * This class represents a contact.
 * Each contact has a unique ID, first name, last name, phone number, and address.
 *************************************************************************************/


public class Contact
{
    // once the constructor assigns contactId
    // it cannot be updated
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;


    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address)
    {
        // reject null, empty, or more than 10 characters
        if (contactId == null || contactId.isEmpty() || contactId.length() > 10)
        {
            throw new IllegalArgumentException(
                    "Invalid Contact ID: cannot be null, empty, or longer than 10 characters");
        }

        this.contactId = contactId;

        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }


    // Setters
    public void setFirstName(String firstName)
    {
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10)
        {
            throw new IllegalArgumentException(
                    "Invalid First Name: cannot be null, empty, or longer than 10 characters");
        }

        this.firstName = firstName;
    }


    public void setLastName(String lastName)
    {
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10)
        {
            throw new IllegalArgumentException(
                    "Invalid Last Name: cannot be null, empty, or longer than 10 characters");
        }

        this.lastName = lastName;
    }


    public void setPhoneNumber(String phoneNumber)
    {
        if (phoneNumber == null || phoneNumber.isEmpty() || !phoneNumber.matches("\\d{10}"))
        {
            throw new IllegalArgumentException(
                    "Invalid Phone Number: cannot be null or empty and must be exactly 10 digits");
        }

        this.phoneNumber = phoneNumber;
    }


    public void setAddress(String address)
    {
        if (address == null || address.isEmpty() || address.length() > 30)
        {
            throw new IllegalArgumentException(
                    "Invalid Address: cannot be null, empty, or longer than 30 characters");
        }

        this.address = address;
    }


    // Getters
    public String getContactId()
    {
        return contactId;
    }


    public String getFirstName()
    {
        return firstName;
    }


    public String getLastName()
    {
        return lastName;
    }


    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    public String getAddress()
    {
        return address;
    }
}