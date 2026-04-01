package edu.pantoja.rolodex.model;
/************
 * Name: Geovanny Pantoja 
 * Date: 26 March 2026
 * Class: BusinessContact extends Contact class demonstrating inheritance and implements SummaryInfo,
 * demonstrating abstraction.  
 */
public class BusinessContact extends Contact{

    private String companyName;
    private String jobTitle;
    private String workPhone;

    public BusinessContact(){
        super();
        setType("BUSINESS");
    }
    
    public BusinessContact(int id, String fName, String lName, String email, String cellNumber, Address address, String companyName, String jobTitle, String workPhone){
        super(id, fName, lName, email, cellNumber, address);
        setType("BUSINESS");
        setCompanyName(companyName);
        setJobTitle(jobTitle);
        setWorkPhone(workPhone);

    }

    public BusinessContact(String fName, String lName, String email, String cellNumber, Address address, String companyName, String jobTitle, String workPhone){
        super(fName, lName, email, cellNumber, address);
        setType("BUSINESS");
        setCompanyName(companyName);
        setJobTitle(jobTitle);
        setWorkPhone(workPhone);

    }


    
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
       
        this.companyName = companyName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
       
        this.jobTitle = jobTitle;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public void setWorkPhone(String workPhone) {
      
        this.workPhone = workPhone;
    }
      
    @Override
    public String toString(){
        return String.format("%s%s%n%s%s%n%s%n%s%s",
        "Company Name: ", (companyName == null ? "N/A" : companyName),
         "Job Title: ", (jobTitle == null ?  "N/A" : jobTitle),
         super.toString(),
         "Work Phone: ", (workPhone == null ? "N/A" : workPhone)        
         );
    }


}
