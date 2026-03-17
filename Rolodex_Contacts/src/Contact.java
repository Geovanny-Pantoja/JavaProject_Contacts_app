/************
 * Name: Geovanny Pantoja 
 * Date: 17 March 2026
 * Assigement: SDC 330 prokect week 1 inheritance and composition
 * Class: Contact Class is a superclass that is inherited by BusinessContact and PersonalContact.
 * The subclasses inherited the properties and can utilize its concret methods.  The class also has the Address class 
 * as a property demonstrating composition. 
 */
public class Contact {
    private String fName;
    private String lName;
    private String email;
    private String cellNumber;
    private Address address;

    public Contact(){}

    public Contact(String fName, String lName, String email, String cellnumber, Address address){
        setfName(fName);
        setlName(lName);
        setEmail(email);
        setCellNumber(cellnumber);
        setAddress(address);

    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Email cannot be empty");
        }
        this.email = email;
    }
    public String getCellNumber() {
        return cellNumber;
    }
    public void setCellNumber(String cellNumber) {
        if(cellNumber == null || cellNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Cell number cannot be empty");
        }
        this.cellNumber = cellNumber;
    }  

    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        if(fName == null || fName.trim().isEmpty()){
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        if(lName == null || lName.trim().isEmpty()){
            throw new IllegalArgumentException("Last Name cannot be empty");
        }
        this.lName = lName;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
       this.address = address;
    }
   

    @Override
    public String toString(){
        return String.format("%s%s%n%s%s%n%s%s%n%s%s%n%s",
        "First Name: ", (fName == null ? "N/A": fName),
         "Last Name: ", (lName == null ? "N/A": lName),
        "Email: ", (email == null ? "N/A": email),
        "Cell Phone: ", (cellNumber == null ? "N/A": cellNumber),
         (address == null ? "Address: N/A" : address.toString()));
    }


}
