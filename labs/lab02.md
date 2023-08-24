# 2 - Reviewing Code
In this lab you will identify issues with code and provide reviews to rectify them.
> Duration: 15-20 minutes

## 2.1 Review Tight Coupling

1. Open the java file [Database.java](../codeReview/Database.java)
2. Notice database class is tied to using SQL Server. To accept any other type of database it would require hard coded change.
3. Edit the file and copy and replace contents of file with below code:
   ```
   public class Database
   {
       private IDatabaseConnection _databaseConnection;
   
       public Database(IDatabaseConnection databaseConnection)
       {
           _databaseConnection = datbaseConnection;
       }
   }
   ```
5. Save the file and commit the changes.
6. With these changes, as long as the passed-in class implements the IDatabaseConnection interface, we can pass in any class for any kind of database connection.
7. So if we find a bug in the SQL Server connection class, only SQL Server clients are affected. That means the clients with different databases will continue to work, and we only have to fix the code for SQL Server customers in the one class.
8. This reduces the maintenance overhead and so reduces the overall cost of maintenance.

## 2.2 Review Exception Handling

1. Open the java file [Company.java](../codeReview/Company.java)
2. Notice The main method tries to print the fourth item in the array, which doesn’t exist.
3. If you execute this program, it causes the ArrayIndexOutOfBoundsException exception to be thrown.
4. When that happens, the program’s execution is stopped and the exception’s message is shown.
5. The fourth and fifth messages are never displayed. There is no exception handling.
6. Now replace this entire code will below snippet
    ```
       import java.io.*;

         public class Company {
         
             public static void main(String[] args) {
         	// write your code here
         	    System.out.println("First line");
         	    System.out.println("Second line");
         	    System.out.println("Third line");
         
         	    try {
         	        int[] myIntArray = new int[]{1, 2, 3};
         	        print4thItemInArray(myIntArray);
         	    } catch (ArrayIndexOutOfBoundsException e){
         	        System.out.println("The array doesn't have four items!");
         	    }
         
         	    System.out.println("Fourth line");
         	    System.out.println("Fith line");
             }
         
             private static void print4thItemInArray(int[] arr) {
                 System.out.println(arr[3]);
             }
         }
     ```
7. Notice the try catch block for exception handling.
8. This time, the exception still happens, same as before.
9. The flow control of the program is then handed to the catch block.
10. Inside the catch block, the code just prints a message explaining that the array doesn’t have four items.
11. Then, execution is resumed to print rest of the lines

## 2.3 Review Memory Leaks

1. Open the java file [ReadUrl.java](../codeReview/ReadUrl.java)
2. Notice the readFromURL() method opens a URL connection object but does not close it.
3. Since the object is referenced even after it is no longer used, it continues to block memory and is not eligible for garbage collection.
4. Add finally block **after** line 15 to close the connection:

    ```
      finally {
        if (urlConnection != null)
        {
          try
          {
            urlConnection.close();
          }
          catch (IOException ioe)
          {
            ioe.printStackTrace();
          }
        }
    }
    ``` 
5. To prevent these types of memory leaks, the finally block should be used to close resources when they are no longer needed.

   
## 2.4 Update the code file to implement DRY (Don't Repeat Yourself) Principle
1. Open the java file [SimpleCollegeApp.java](../dry-principle/SimpleCollegeApp.java)
2. Notice the varaibles methods college(),college1() and college2() on line 12,25 and 39.
3. These essentially perform the same acvitity of printing the College and Department Name.
4. Now open the java file [SimpleCollegeAppDRY.java](../dry-principle/SimpleCollegeAppDRY.java)
5. Replace the contents of this file with below code:

   ```
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
   ```
6. Save and commit the file
7. Notice now there is only one college method implementation on line being called from all the methods.
8. You can compare the changes by navigating to > 
