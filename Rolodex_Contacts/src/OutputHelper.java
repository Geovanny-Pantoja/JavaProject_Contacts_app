/************
 * Name: Geovanny Pantoja 
 * Date: 11 March 2026
 * Assigement: SDC 330 prokect week 1 inheritance and composition
 * Class: OutputHelper has methods to displaus meny and messages and instructions
 */
public class OutputHelper {

    public void printDivider(){
        System.out.println("*".repeat(70));
    }

    public void printHeader(){
        printDivider();
        System.out.println("Week 1 Geovanny Pantoja");
        System.out.println("Inheratance, Composition and User Interaction");
        printDivider();
    }

    public void printSection(String title){
        System.out.println("\n=== " + title + " ===\n");
    }

    public void printMenu(){
        System.out.println("1. Add/Update Business Contact Information");
        System.out.println("2. Add/Update Personal Contact Information");
        System.out.println("3. Display Contacts");
        System.out.println("4. Display Contacts Summary");
        System.out.println("5. Exit Application\n");
    }

    public void pause(){
        System.out.print("\nPress Enter to continue....");
    }

    public void printInstructions(){
        System.out.println("\nWelcome! This demo will collect and print information for:");
        System.out.println(" - One Business Contact");
        System.out.println(" - One Personal Contact\n");
    }

    public void clearScreen() {
         System.out.print("\033[H\033[2J");
         System.out.flush();
    }

}
