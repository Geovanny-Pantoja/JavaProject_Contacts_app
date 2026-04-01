package edu.pantoja.rolodex.model;
/************
 * Name: Geovanny Pantoja 
 * Date: 26 March 2026
 * Class: Contact Class is the abstract superclass that is inherited by BusinessContact and PersonalContact.
 * The subclasses inherited the properties and can utilize its concret methods.  The class also has the Address class 
 * as a property demonstrating composition. 
 */
public abstract class Contact {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String cellNumber;
    private Address address;
    private String type;

    public Contact(){
        this.address = new Address();

    }

    public Contact(int id, String fName, String lName, String email, String cellNumber, Address address){
        setId(id);
        setfName(fName);
        setlName(lName);
        setEmail(email);
        setCellNumber(cellNumber);
        setAddress(address);

    }
   

    public Contact(String fName, String lName, String email, String cellNumber, Address address) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.cellNumber = cellNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
      
        this.email = email;
    }
    public String getCellNumber() {
        return cellNumber;
    }
    public void setCellNumber(String cellNumber) {
        
        this.cellNumber = cellNumber;
    }  

    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
       
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {        
        this.lName = lName;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
       this.address = address;
    }

    public String getType() {
        return type;
    }
    protected void setType(String type) {
        this.type = type;
    }
   
   
    // keeping in case debugging is needed.
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
