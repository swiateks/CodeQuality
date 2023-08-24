# 2 - Testing Code
In this lab you write simple test cases to verify your code.
> Duration: 15-20 minutes

## 2.1 Writing Unit Tests

1. Open the java file [Calculator.java](../codeTesting/Calculator.java)
2. Notice the method multiple.
3. Create a file CalculatorTest.java in the same folder.
4. Copy the below code to test the Calculator function

   ```
   import static org.junit.jupiter.api.Assertions.assertEquals;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.RepeatedTest;
    import org.junit.jupiter.api.Test;

    class CalculatorTest {

        Calculator calculator;

        @BeforeEach                                         
        void setUp() {
            calculator = new Calculator();
        }

        @Test                                               
        @DisplayName("Simple multiplication should work")   
        void testMultiply() {
            assertEquals(20, calculator.multiply(4, 5),     
                    "Regular multiplication should work");  
        }

        @RepeatedTest(5)                                    
        @DisplayName("Ensure correct handling of zero")
        void testMultiplyWithZero() {
            assertEquals(0, calculator.multiply(0, 5), "Multiple with zero should be zero");
            assertEquals(0, calculator.multiply(5, 0), "Multiple with zero should be zero");
        }
    }
   ```
   
5. The method annotated with @BeforeEach runs before each test
6. A method annotated with @Test defines a test method
7. @DisplayName can be used to define the name of the test which is displayed to the user
8. This is an assert statement which validates that expected and actual value is the same, if not the message at the end of the method is shown
9. @RepeatedTest defines that this test method will be executed multiple times, in this example 5 times

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
