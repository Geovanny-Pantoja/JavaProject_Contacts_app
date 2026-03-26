package edu.pantoja.rolodex.model;
/************
 * Name: Geovanny Pantoja 
 * Date: 26 March 2026
 * Class: Address is used as a property in the contact class demonstrating the has a relationship
 * which satifies the composition requirement.
 */
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(){}

    public Address(String street, String city, String state, String zipCode){
        setStreet(street);
        setCity(city);
        setState(state);
        setZipCode(zipCode);

    }    


    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        
         this.street = street;        
    }
    public String getCity() {        
        return city;
    }
    public void setCity(String city) {
       
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
     
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
               
        this.zipCode = zipCode;
    }

    // keeping in case debugging is needed.
    @Override    
    public String toString() {
        return String.format(
           "Street: %s%nCity: %s%nState: %s%nZip Code: %s",
            (street == null ? "N/A" : street),
            (city == null ? "N/A" : city),
            (state == null ? "N/A" : state),
            (zipCode == null ? "N/A" : zipCode)
        );
    }


}
