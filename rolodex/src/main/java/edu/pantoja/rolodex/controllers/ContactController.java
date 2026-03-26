/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Controller for managing contact CRUD operations and navigation demonstrating abstraction.
*/
package edu.pantoja.rolodex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pantoja.rolodex.model.BusinessContact;
import edu.pantoja.rolodex.model.Contact;
import edu.pantoja.rolodex.model.FamilyContact;
import edu.pantoja.rolodex.model.FriendContact;
import edu.pantoja.rolodex.service.ContactService;
import edu.pantoja.rolodex.storage.ContactSerializer;
import edu.pantoja.rolodex.storage.EntitySerializer;
import edu.pantoja.rolodex.storage.FileStorage;
import edu.pantoja.rolodex.storage.Storage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController() {
        EntitySerializer<Contact> serializer = new ContactSerializer();
        Storage<Contact> storage = new FileStorage<>(serializer);
        this.contactService = new ContactService(storage);
    }

    @GetMapping()
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactService.loadContacts());
        return "contacts";
    }

    // get method to go to a page to select the type of contact to add
    @GetMapping("/add")
    public String chooseType(Model model) {
        return "choose-contact-type";
    }

    // post method to go to the form to add the selected type of contact
    @PostMapping("/add")
    public String typeContactForm(@RequestParam String entity, Model model) {

        switch (entity.toLowerCase()) {
            case "family":
                model.addAttribute("contact", new FamilyContact());
                return "add-family-contact";
            case "business":
                model.addAttribute("contact", new BusinessContact());
                return "add-business-contact";
            case "friend":
                model.addAttribute("contact", new FriendContact());
                return "add-friend-contact";
            default:
                return "redirect:/contacts/add"; // Redirect back to the form if an invalid type is provided
        }

    }

    // get method to show the form to add a family contact
    @GetMapping("/add-family")
    public String showFamilyForm(Model model) {
        if (!model.containsAttribute("contact")) {
            model.addAttribute("contact", new FamilyContact());
        }
        return "add-family-contact";
    }

    // post method to save the family contact
    @PostMapping("/save-family")
    public String saveFamily(@ModelAttribute("contact") FamilyContact contact,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (!contactService.validate(contact)) {
            model.addAttribute("error", "Invalid contact information.");
            model.addAttribute("contact", contact);
            return "add-family-contact";
        }

        contactService.addContact(contact);
        model.addAttribute("success", "Family contact added!");
        model.addAttribute("contact", new FamilyContact()); // Clear the form
        return "add-family-contact";
    }

    // get method to show the form to add a business contact
    @GetMapping("/add-business")
    public String showBusinessForm(Model model) {
        if (!model.containsAttribute("contact")) {
            model.addAttribute("contact", new BusinessContact());
        }
        return "add-business-contact";
    }

    // post method to save the business contact
    @PostMapping("/save-business")
    public String saveBusiness(@ModelAttribute("contact") BusinessContact contact,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (!contactService.validate(contact)) {
            model.addAttribute("error", "Invalid contact information.");
            model.addAttribute("contact", contact);
            return "add-business-contact";
        }

        contactService.addContact(contact);
        redirectAttributes.addFlashAttribute("success", "Business contact added!");
        return "redirect:/contacts/add-business";
    }

    
    //get method to show add friend form 
    @GetMapping("/add-friend")
    public String showFriendForm(Model model) {
        if (!model.containsAttribute("contact")) {
            model.addAttribute("contact", new FriendContact());
        }
        return "add-friend-contact";
    }

    // post method to save the friend contact
    @PostMapping("/save-friend")
    public String saveFriend(@ModelAttribute("contact") FriendContact contact,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (!contactService.validate(contact)) {
            model.addAttribute("error", "Invalid contact information.");
            model.addAttribute("contact", contact);
            return "add-friend-contact";
        }

        contactService.addContact(contact);
        redirectAttributes.addFlashAttribute("success", "Friend contact added!");
        return "redirect:/contacts/add-friend";
    }

    // get method to show the table with family contacts and options to edit and
    // delete

    @GetMapping("/family")
    public String showFamilyContacts(Model model) {

        model.addAttribute("contacts", contactService.getFamilyContacts());
        return "family-contacts";
    }

    // get method to show the table with business contacts and options to edit and
    // delete
    @GetMapping("/business")
    public String showBusinessContacts(Model model) {

        model.addAttribute("contacts", contactService.getBusinessContacts());
        return "business-contact";
    }

    @GetMapping("/friend")
    public String showFriendContacts(Model model) {
        model.addAttribute("contacts", contactService.getFriendContacts());
        return "friend-contacts";
    }
    

    // get method to show the form to edit a contact based on its type
    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable int id, Model model) {
        Contact contact = contactService.getContactById(id);

        if (contact instanceof FamilyContact) {
            model.addAttribute("contact", contact);
            return "edit-family-contact";
        }
        if (contact instanceof BusinessContact) {
            model.addAttribute("contact", contact);
            return "edit-business-contact";
        }
        if (contact instanceof FriendContact) {
            model.addAttribute("contact", contact);
            return "edit-friend-contact";
        }
        return "redirect:/contacts";
    }

    @PostMapping("/edit/family")
    public String updateFamilyContact(@ModelAttribute FamilyContact contact,
            RedirectAttributes redirectAttributes, Model model) {

        if (!contactService.validate(contact)) {
            model.addAttribute("error", "Invalid contact information.");
            model.addAttribute("contact", contact);
            return "edit-family-contact";
        }

        contactService.updateContact(contact.getId(), contact);
        redirectAttributes.addFlashAttribute("success", "Contact updated successfully.");

        return "redirect:/contacts/family";

    }
    @PostMapping("/edit/business")
    public String updateBusinessContac(@ModelAttribute BusinessContact contact, RedirectAttributes redirectAttributes, Model model) {
        if (!contactService.validate(contact)) {
            model.addAttribute("error", "Invalid contact information.");
            model.addAttribute("contact", contact);
            return "edit-business-contact";
        }
        contactService.updateContact(contact.getId(), contact);
        redirectAttributes.addFlashAttribute("success", "Contact updated successfull");
        return "redirect:/contacts/business";
    }  

     @PostMapping("/edit/friend")
    public String updateFriendContac(@ModelAttribute FriendContact contact, RedirectAttributes redirectAttributes, Model model) {
        if (!contactService.validate(contact)) {
            model.addAttribute("error", "Invalid contact information.");
            model.addAttribute("contact", contact);
            return "edit-friend-contact";
        }
        contactService.updateContact(contact.getId(), contact);
        redirectAttributes.addFlashAttribute("success", "Contact updated successfull");
        return "redirect:/contacts/friend";
    }
    

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable int id,
            RedirectAttributes redirectAttributes) {

        Contact contact = contactService.getContactById(id);

        if (contact == null) {
            redirectAttributes.addFlashAttribute("error", "Contact not found.");
            return "redirect:/";
        }

        contactService.deleteContact(id);
        redirectAttributes.addFlashAttribute("success", "Contact deleted successfully!");

        if (contact instanceof FamilyContact) {
            return "redirect:/contacts/family";
        }
        if (contact instanceof BusinessContact) {
            return "redirect:/contacts/business";
        }
        if (contact instanceof FriendContact) {
            return "redirect:/contacts/friend";
        }
        return "redirect:/";
    }
}
