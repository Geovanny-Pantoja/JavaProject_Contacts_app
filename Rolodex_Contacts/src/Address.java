/************
 * Name: Geovanny Pantoja 
 * Date: 11 March 2026
 * Assigement: SDC 330 prokect week 1 inheritance and composition
 * Class: Address will be usused inside contact to demonstrate composition
 */
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    


    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        if(street == null || street.trim().isEmpty()){
            throw new IllegalArgumentException("Street cannot be empty");
        }
         this.street = street;        
    }
    public String getCity() {        
        return city;
    }
    public void setCity(String city) {
        if(city == null || city.trim().isEmpty()){
            throw new IllegalArgumentException("City cannot be empty");
        }
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        if(state == null || state.trim().isEmpty()){
            throw new IllegalArgumentException("State cannot be empty");
        }
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        if(zipCode == null || zipCode.trim().isEmpty()){
            throw new IllegalArgumentException("ZipCode cannot be empty");
        }
        this.zipCode = zipCode;
    }

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
