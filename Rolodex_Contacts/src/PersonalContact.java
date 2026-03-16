/************
 * Name: Geovanny Pantoja 
 * Date: 11 March 2026
 * Assigement: SDC 330 prokect week 1 inheritance and composition
 * Class: PersonalContac extends Contact class 
 */
public class PersonalContact extends Contact implements SummaryInfo{
    private String relationship;
    private String birthday;

    public PersonalContact(){}
    
    public PersonalContact(String fName, String lName, String email, String cellnumber, Address address,
            String relationship, String birthday) {
        super(fName, lName, email, cellnumber, address);
        setRelationship(relationship);
        setBirthday(birthday);
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        if(relationship == null || relationship.trim().isEmpty()){
            throw new IllegalArgumentException("Relationship cannot be empty");
        }
        this.relationship = relationship;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        if(birthday == null || birthday.trim().isEmpty()){
            throw new IllegalArgumentException("Birthday cannot be empty");
        }
        this.birthday = birthday;
    }

    

    @Override
    public String getSummary() {
        
        return String.format("Personal Contact: %s %s\tRelationship: %s%n",getfName(), getlName(), (relationship == null ? "Invalid" : relationship));
    }

    @Override
    public String toString(){
        return String.format("%s%s%n%s%s%n%s",
        "Relationship: ", (relationship == null ? "N/A": relationship),
         "Birthday: ", (birthday == null ? "N/A" : birthday),
         super.toString()
        
         );
    }





}
