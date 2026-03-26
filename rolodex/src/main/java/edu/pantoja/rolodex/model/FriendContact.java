package edu.pantoja.rolodex.model;
/************
 * Name: Geovanny Pantoja 
 * Date: 17 March 2026
 * Class: Friend extends Contact class demonstrating inheritance and implements required Getid method,
 * demonstrating abstraction via extending the abstract class.  The method getSummary is implemented to fullfill the contract.
 */

public class FriendContact extends Contact{
    private String howWeMet;
    

    public FriendContact() {
        super();
    }   

    public FriendContact(
            int id,
            String fName, 
            String lName,
            String email,
            String cellNumber,
            Address address,
            String howWeMet
            ) {

        // Pass serviceName as fName, leave lName empty
        super(id, fName, lName, email, cellNumber, address);
        setHowWeMet(howWeMet);
        
        
    }

    public String getHowWeMet() {
        return howWeMet;
    }
    public void setHowWeMet(String howWeMet){
        this.howWeMet = howWeMet;

    }
   
    
    //keep in case of debugging 
    @Override
    public String toString() {
        return String.format(
            "How we Met: %s%n",
            howWeMet,           
            super.toString()
        );
    }

}
