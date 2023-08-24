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
5. Save and Commit the file.
6. To prevent these types of memory leaks, the finally block should be used to close resources when they are no longer needed.

   
## 2.4 Review Null pointers
1. Open the java file [NullPointerExceptionExample.java](../codeReview/NullPointerExceptionExample.java)
2. In this example, the printLength() method calls the length() method of a String without performing a null check prior to calling the method.
3. To fix the NullPointerException in the above example, the string should be checked for null or empty values before it is used any further
4. Replace the contents of this file with below code:

   ```
        import org.apache.commons.lang3.StringUtils;
   
         public class NullPointerExceptionExample {
             private static void printLength(String str) {
                 if (StringUtils.isNotEmpty(str)) {
                     System.out.println(str.length());
                 } else {
                     System.out.println("Empty string");
                 }
             }
         
             public static void main(String args[]) {
                 String myString = null;
                 printLength(myString);
             }
         }
   ```
7. Save and commit the file
8. The code is updated with a check in the printLength() method that makes sure the string is not empty using the apache commons StringUtils.isNotEmpty() method.
9. Only if the string is not empty the length() method of the string is called, else it prints the message Empty string to console.
