package edu.pantoja.rolodex.model;
/************
 * Name: Geovanny Pantoja 
 * Date: 17 March 2026
 * Class: FamilyContact extends Contact class demonstrating inheritance and implements required Getid method,
 * demonstrating abstraction via extending the abstract class.  The method getSummary is implemented to fullfill the contract.
 */
 
public class FamilyContact extends Contact{
    private String relationship;
    private String birthday;

    public FamilyContact(){
        super();
    }
        
    public FamilyContact(int id, String fName, String lName, String email, String cellnumber, Address address,
            String birthday, String relationship ) {
        super(id, fName, lName, email, cellnumber, address);        
        setBirthday(birthday);
        setRelationship(relationship);
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        
        this.relationship = relationship;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        
        this.birthday = birthday;
    }        

    // keeping in case debugging is needed.

    @Override
    public String toString(){
        return String.format("%s%s%n%s%s%n%s",
        "Relationship: ", (relationship == null ? "N/A": relationship),
         "Birthday: ", (birthday == null ? "N/A" : birthday),
         super.toString()
        
         );
    }

}
