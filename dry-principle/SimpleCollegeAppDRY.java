   import java.util.*;
    
   // Main class
   public class SimpleCollegeAppDRY {
    
       // Method 1
       // For cse department
       public void CSE()
       {
    
           // Print statement
           System.out.println("This is computer science");
    
           // Calling method
           college();
       }
    
       // Method 2
       // For ece dept method
       public void ECE()
       {
           System.out.println("This is electronics");
    
           // Calling method
           college();
       }
    
       // Method 3
       // For IT dept
       public void IT()
       {
    
           // Print statement
           System.out.println(
               "This is Information Technology");
    
           // Calling method
           college();
       }
    
       // Method 4
       // For college dept
       public void college()
       {
    
           // Print statement
           System.out.println("IIT - Madras");
       }
    
       // Method 5
       // Main driver method
       public static void main(String[] args)
       {
    
           // Creating object of class in main() method
           GFG s = new GFG();
    
           // Calling the methods one by one
           // as created above
           s.CSE();
           s.ECE();
           s.IT();
       }
   }
