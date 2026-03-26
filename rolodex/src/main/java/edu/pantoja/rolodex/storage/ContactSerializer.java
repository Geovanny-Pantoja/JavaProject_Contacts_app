/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Serialize and deserialize Contact objects to/from a delimited string for file persistence.
* demonstrates polyphormism by using the Contact class and create subclasses.
*/
package edu.pantoja.rolodex.storage;
import edu.pantoja.rolodex.model.*;


public class ContactSerializer implements EntitySerializer<Contact> {
    private static final String DELIM = "|";

    // -----------------------------
    // SERIALIZE
    // -----------------------------
    public String serialize(Contact c) {

        Address a = c.getAddress();

        if (c instanceof FamilyContact pc) {
            return String.join(DELIM,
                    "FAMILY",
                    String.valueOf(c.getId()),
                    c.getfName(),
                    c.getlName(),
                    c.getEmail(),
                    c.getCellNumber(),
                    a.getStreet(),
                    a.getCity(),
                    a.getState(),
                    a.getZipCode(),
                    pc.getBirthday(),
                    pc.getRelationship()
            );
        }

        if (c instanceof BusinessContact bc) {
            return String.join(DELIM,
                    "BUSINESS",
                    String.valueOf(c.getId()),
                    c.getfName(),
                    c.getlName(),
                    c.getEmail(),
                    c.getCellNumber(),
                    a.getStreet(),
                    a.getCity(),
                    a.getState(),
                    a.getZipCode(),
                    bc.getCompanyName(),
                    bc.getJobTitle(),
                    bc.getWorkPhone()
            );
        }

        if (c instanceof FriendContact sc) {
            return String.join(DELIM,
                    "FRIEND",
                    String.valueOf(c.getId()),
                    c.getfName(),
                    c.getlName(),
                    c.getEmail(),
                    c.getCellNumber(),
                    a.getStreet(),
                    a.getCity(),
                    a.getState(),
                    a.getZipCode(),
                    sc.getHowWeMet()
            );
        }

        throw new IllegalArgumentException("Unknown contact type: " + c.getClass());
    }

    // -----------------------------
    // DESERIALIZE
    // -----------------------------
    public Contact deserialize(String line) {

        String[] parts = line.split("\\|");

        String type = parts[0];
        int id = Integer.parseInt(parts[1]);

        switch (type) {

            case "FAMILY": {
                Address a = new Address(parts[6], parts[7], parts[8], parts[9]);
                return new FamilyContact(
                        id,
                        parts[2],  // fName
                        parts[3],  // lName
                        parts[4],  // email
                        parts[5],  // cell
                        a,
                        parts[10], //DOB
                        parts[11]  // relationship
                );
            }

            case "BUSINESS": {
                Address a = new Address(parts[6], parts[7], parts[8], parts[9]);
                return new BusinessContact(
                        id,
                        parts[2],  // fName
                        parts[3],  // lName
                        parts[4],  // email
                        parts[5],  // cell
                        a,
                        parts[10], // company
                        parts[11], // jobTitle
                        parts[12]  // workPhone
                );
            }

            case "FRIEND": {
                Address a = new Address(parts[6], parts[7], parts[8], parts[9]);
                return new FriendContact(
                        id,
                        parts[2],  // fName
                        parts[3],  // lName
                        parts[4],  // email
                        parts[5], //cell
                        a,
                        parts[10]  // howwemet                        
                );
            }

            default:
                throw new IllegalArgumentException("Unknown contact type: " + type);
        }
    }

}
