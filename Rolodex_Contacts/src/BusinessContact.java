/************
 * Name: Geovanny Pantoja 
 * Date: 11 March 2026
 * Assigement: SDC 330 prokect week 1 inheritance and composition
 * Class: BusinessContact extends Contact class 
 */
public class BusinessContact extends Contact implements SummaryInfo{

    private String companyName;
    private String jobTitle;
    private String workPhone;
    
   

    
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        if(companyName == null || companyName.trim().isEmpty()){
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        this.companyName = companyName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        if(jobTitle == null || jobTitle.trim().isEmpty()){
            throw new IllegalArgumentException("Job Title cannot be empty");
        }
        this.jobTitle = jobTitle;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public void setWorkPhone(String workPhone) {
        if(workPhone == null || workPhone.trim().isEmpty()){
            throw new IllegalArgumentException("Work Phone cannot be empty");
        }
        this.workPhone = workPhone;
    }

    

    @Override
    public String getSummary() {
        
        return String.format("Business Contact: %s %s\tCompany: %s%n",getfName(), getlName(), (companyName == null ? "Invalid" : companyName));
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
