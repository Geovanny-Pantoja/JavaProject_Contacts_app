/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Service that handles contact loading, validation, and CRUD operations using Storage.
*/
package edu.pantoja.rolodex.service;
import edu.pantoja.rolodex.model.Address;
import edu.pantoja.rolodex.model.BusinessContact;
import edu.pantoja.rolodex.model.Contact;
import edu.pantoja.rolodex.model.FamilyContact;
import edu.pantoja.rolodex.model.FriendContact;
import edu.pantoja.rolodex.storage.Storage;


import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private final List<Contact> contacts = new ArrayList<>();
    private Storage<Contact> storage;

    public ContactService(Storage<Contact> storage) {
        this.storage = storage;
        loadContacts();
        
    }

    public ArrayList<Contact> loadContacts() {        
        contacts.clear(); // Clear the list before loading
        for (Contact c : storage.loadData()) {
            if(c != null) {
            contacts.add(c);
            }
        }
        return new ArrayList<>(contacts);
    }

    public List<FamilyContact> getFamilyContacts() {
        return contacts.stream()
                .filter(c -> c instanceof FamilyContact)
                .map(c -> (FamilyContact) c)
                .toList();
    }

    public List<BusinessContact> getBusinessContacts() {
        return contacts.stream()
                .filter(c -> c instanceof BusinessContact)
                .map(c -> (BusinessContact) c)
                .toList();
    }

    public List<FriendContact> getFriendContacts(){
        return contacts.stream()
               .filter(c -> c instanceof FriendContact)
               .map(c -> (FriendContact) c)
               .toList();
    }

    private void saveContacts() {
        storage.saveData(contacts);
   
    }      

    public Contact getContactById(int id) {
        return contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private int generateNewId() {
        return contacts.stream()
                .mapToInt(Contact::getId)
                .max()
                .orElse(0) + 1;
    }

    public void addContact(Contact contact) {
        contact.setId(generateNewId());
        contacts.add(contact);
        saveContacts();
    }

    public void updateContact(int id, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {
                updatedContact.setId(id); // Ensure the updated contact has the correct ID
                contacts.set(i, updatedContact);
                saveContacts();
                return;
            }
        }        
    }

    public void deleteContact(int id) {
        contacts.removeIf(c -> c.getId() == id);
        saveContacts();
    }

    public boolean validate(Contact contact) {

    // -------------------------
    // COMMON CONTACT VALIDATION
    // -------------------------
    if (contact.getEmail() == null || contact.getEmail().trim().isEmpty()) {
        return false;
    }

    if (contact.getCellNumber() == null || contact.getCellNumber().trim().isEmpty()) {
        return false;
    }

    if(contact.getfName() == null || contact.getfName().trim().isEmpty()) {
        return false;
    }
    if(contact.getlName() == null || contact.getlName().trim().isEmpty()) {
        return false;
    }   

    // -------------------------
    // ADDRESS VALIDATION
    // -------------------------
    Address addr = contact.getAddress();

    if (addr == null) {
        return false;
    }

    if (addr.getStreet() == null || addr.getStreet().trim().isEmpty()) {
        return false;
    }

    if (addr.getCity() == null || addr.getCity().trim().isEmpty()) {
        return false;
    }

    if (addr.getState() == null || addr.getState().trim().isEmpty()) {
        return false;
    }

    if (addr.getZipCode() == null || addr.getZipCode().trim().isEmpty()) {
        return false;
    }

    // -------------------------
    // FAMILY CONTACT VALIDATION
    // -------------------------
    if (contact instanceof FamilyContact pc) {        
        

        if (pc.getRelationship() == null || pc.getRelationship().trim().isEmpty()) {
            return false;
        }

        if (pc.getBirthday() == null || pc.getBirthday().trim().isEmpty()) {
            return false;
        }
    }

    // -------------------------
    // BUSINESS CONTACT VALIDATION
    // -------------------------
    if (contact instanceof BusinessContact bc) {        

        if (bc.getCompanyName() == null || bc.getCompanyName().trim().isEmpty()) {
            return false;
        }

        if (bc.getJobTitle() == null || bc.getJobTitle().trim().isEmpty()) {
            return false;
        }
        if (bc.getWorkPhone() == null || bc.getWorkPhone().trim().isEmpty()) {
            return false;
        }
    }

    // -------------------------
    // SERVICE CONTACT VALIDATION
    // -------------------------
    if (contact instanceof FriendContact sc) {

        if (sc.getHowWeMet() == null || sc.getHowWeMet().trim().isEmpty()) {
            return false;
        }        
    }

    return true; // VALID
}


}
