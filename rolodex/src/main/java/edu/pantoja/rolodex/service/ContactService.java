/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Service that handles contact loading, validation, and CRUD operations using Storage.
*/
package edu.pantoja.rolodex.service;

import edu.pantoja.rolodex.Database.ContactDAO;
import edu.pantoja.rolodex.model.Address;
import edu.pantoja.rolodex.model.BusinessContact;
import edu.pantoja.rolodex.model.Contact;
import edu.pantoja.rolodex.model.FamilyContact;
import edu.pantoja.rolodex.model.FriendContact;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private final ContactDAO contactDAO;

    public ContactService(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> getAllContacts() {
        return contactDAO.findAll();
    }

    public List<Contact> getContactsByType(String type) {
        return contactDAO.findByType(type);
    }

    public Contact getContactById(int id) {
        return contactDAO.findById(id);
    }

    public List<String> addContact(Contact contact) {
        List<String> errors = validate(contact);
        if (!errors.isEmpty()) {
            return errors;
        }
        contactDAO.insert(contact);
        return List.of("SUCCESS"); // Return an empty list to indicate success
    }

    public List<String> updateContact(Contact contact) {
        List<String> errors = validate(contact);
        if (!errors.isEmpty()) {
            return errors;
        }
        contactDAO.update(contact);
        return List.of("SUCCESS");
    }

    public boolean deleteContact(int id) {
        contactDAO.delete(id);
        return true;
    }

    public List<String> validate(Contact contact) {
        List<String> errors = new ArrayList<>();

        // -------------------------
        // COMMON CONTACT VALIDATION
        // -------------------------
        if (contact.getEmail() == null
                || contact.getEmail().trim().isEmpty()
                || !contact.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            errors.add("Invalid email address.");
        }

        if (contact.getCellNumber() == null
                || contact.getCellNumber().trim().isEmpty()
                || !contact.getCellNumber().matches("^(\\+?1[- ]?)?\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$")) {
            errors.add("Invalid cell phone number.");
        }

        if (contact.getfName() == null || contact.getfName().trim().isEmpty()) {
            errors.add("First name is required.");
        }

        if (contact.getlName() == null || contact.getlName().trim().isEmpty()) {
            errors.add("Last name is required.");
        }

        // -------------------------
        // ADDRESS VALIDATION
        // -------------------------
        Address addr = contact.getAddress();

        if (addr == null) {
            errors.add("Address is required.");

        }

        if (addr.getStreet() == null || addr.getStreet().trim().isEmpty()) {
            errors.add("Street is required.");

        }

        if (addr.getCity() == null || addr.getCity().trim().isEmpty()) {
            errors.add("City is required.");

        }

        if (addr.getState() == null || addr.getState().trim().isEmpty()) {
            errors.add("State is required.");
        }

        if (addr.getZipCode() == null
                || addr.getZipCode().trim().isEmpty()
                || !addr.getZipCode().matches("^\\d{5}(-\\d{4})?$")) {
            errors.add("Invalid ZIP code.");
        }

        // -------------------------
        // FAMILY CONTACT VALIDATION
        // -------------------------
        if (contact instanceof FamilyContact pc) {

            if (pc.getRelationship() == null || pc.getRelationship().trim().isEmpty()) {
                errors.add("Relationship is required.");

            }

            if (pc.getBirthday() == null
                    || pc.getBirthday().trim().isEmpty()
                    || LocalDate.parse(pc.getBirthday()).isAfter(LocalDate.now())) {
                errors.add("Invalid birthday. Cannot be in the future.");
            }
        }

        // -------------------------
        // BUSINESS CONTACT VALIDATION
        // -------------------------
        if (contact instanceof BusinessContact bc) {

            if (bc.getCompanyName() == null || bc.getCompanyName().trim().isEmpty()) {
                errors.add("Company name is required.");

            }

            if (bc.getJobTitle() == null || bc.getJobTitle().trim().isEmpty()) {
                errors.add("Job title is required.");

            }
            if (bc.getWorkPhone() == null
                    || bc.getWorkPhone().trim().isEmpty()
                    || !bc.getWorkPhone().matches("^(\\+?1[- ]?)?\\(?\\d{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$")) {
                errors.add("Invalid work phone number.");
            }
        }

        // -------------------------
        // SERVICE CONTACT VALIDATION
        // -------------------------
        if (contact instanceof FriendContact sc) {

            if (sc.getHowWeMet() == null || sc.getHowWeMet().trim().isEmpty()) {
                errors.add("How we met is required.");

            }
        }

        return errors; // Return the list of validation errors
    }

}