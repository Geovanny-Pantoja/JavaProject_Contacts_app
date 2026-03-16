import java.util.ArrayList;

/************
 * Name: Geovanny Pantoja 
 * Date: 11 March 2026
 * Assigement: SDC 330 prokect week 1 inheritance and composition
 * Class: Main controls flow and calss methods from other clases to display output 
 */

public class App {
    public static void main(String[] args) throws Exception {
        
        OutputHelper output = new OutputHelper(); 
        InputHelper input = new InputHelper();
        Address address1 = new Address();
        Address address2 = new Address();
        BusinessContact businessContact = new BusinessContact();
        PersonalContact personalContact = new PersonalContact();
        ArrayList<SummaryInfo> contacts = new ArrayList<SummaryInfo>();
        boolean running = true;

        while(running){
            output.clearScreen();
            output.printHeader();
            output.printInstructions();
            output.printMenu();

            String choice = input.getRequriedString("Select an option: ",  "Menu choice");

            switch (choice) {
                case "1":
                    output.clearScreen();
                    output.printSection("Businees Contact Entry");
                    collectBusinessContact(input, businessContact, address1, contacts);
                    System.out.println("BusinessContact Added Succesfully");
                    output.pause();
                    input.waitForEnter();
                    break;
                case "2":
                    output.clearScreen();
                    output.printSection("Personal Contact Entry");
                    collectPersonalContact(input, personalContact, address2, contacts);
                    System.out.println("Personnal Contact Added Succesfully");
                    output.pause();
                    input.waitForEnter();
                    break; 
                case "3":
                    output.clearScreen();
                    output.printSection("Business Contact");
                    System.out.println(businessContact.toString());
                    output.printSection("Personal Contact");
                    System.out.println(personalContact.toString());
                    output.pause();
                    input.waitForEnter();    
                    break;
                case "4":
                    output.clearScreen();
                     output.printSection("Summary Info");
                    for (SummaryInfo c : contacts){
                        System.out.println(c.getSummary());
                    }
                    output.pause();
                    input.waitForEnter();  
                    break;
                case "5":
                    running = false;
                    System.out.println("Hope you enjoy the demo. App Closing... ");
                    break;                      
                default:
                    System.err.println("Invalid option");
                    output.pause();
                    input.waitForEnter();

                    break;
            }
        } 

    }

    public static void collectBusinessContact(InputHelper input, BusinessContact bc, Address address, ArrayList<SummaryInfo> contacts){
        bc.setfName(input.getRequriedString("First Name: ", "First Name"));            
        bc.setlName(input.getRequriedString("Last Name: ", "Last Name"));
        bc.setEmail(input.getRequriedString("EMail: ", "Email"));
        bc.setCellNumber(input.getRequriedString("Cell Number: ", "Cell Number"));
        address.setStreet(input.getRequriedString("Street and Name: ", "Stret"));
        address.setCity(input.getRequriedString("City: ", "City"));
        address.setState(input.getRequriedString("State: ", "State"));
        address.setZipCode(input.getRequriedString("Zip Code: ", "Zip Code"));
        bc.setAddress(address);
        bc.setCompanyName(input.getRequriedString("Company Name: ", "Company"));
        bc.setJobTitle(input.getRequriedString("Job title: ", "Job title")); 
        bc.setWorkPhone(input.getRequriedString("Work Phone: ", "Work Phone"));
        contacts.add(bc);

    }
    
     public static void collectPersonalContact(InputHelper input, PersonalContact pc, Address address, ArrayList<SummaryInfo> contacts){
        pc.setfName(input.getRequriedString("First Name: ", "First Name"));            
        pc.setlName(input.getRequriedString("Last Name: ", "Last Name"));
        pc.setEmail(input.getRequriedString("EMail: ", "Email"));
        pc.setCellNumber(input.getRequriedString("Cell Number: ", "Cell Number"));
        address.setStreet(input.getRequriedString("Street and Name: ", "Stret"));
        address.setCity(input.getRequriedString("City: ", "City"));
        address.setState(input.getRequriedString("State: ", "State"));
        address.setZipCode(input.getRequriedString("Zip Code: ", "Zip Code"));
        pc.setAddress(address);
        pc.setRelationship(input.getRequriedString("Relationship: ", "Relationship"));
        pc.setBirthday(input.getRequriedString("Birthday: ", "Birthday"));  
        contacts.add(pc);       
    }


    
}
