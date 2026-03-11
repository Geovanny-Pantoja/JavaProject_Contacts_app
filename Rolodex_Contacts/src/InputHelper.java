/************
 * Name: Geovanny Pantoja 
 * Date: 11 March 2026
 * Assigement: SDC 330 prokect week 1 inheritance and composition
 * Class: InputHelper to get string from user
 */

import java.util.Scanner;
public class InputHelper {
   private Scanner input;

   public InputHelper(){
    input = new Scanner(System.in);
   }

   public String getRequriedString(String prompt, String field){
    while(true){

        System.out.print(prompt);
        String value = input.nextLine();
        try{
          if(value == null || value.trim().isEmpty()){
              throw new IllegalArgumentException(field + " cannot be empty.");
          }
        return value;
        }catch (IllegalArgumentException e){
             System.err.println(e.getMessage());
        }
    }
  }

  public void waitForEnter() {
        input.nextLine(); 
    }
    

}
