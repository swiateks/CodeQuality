# 2 - Testing Code
In this lab you write simple test cases to verify your code.
> Duration: 15-20 minutes

## 2.1 Writing Unit Tests

1. Open the java file [Calculator.java](../codeTesting/Calculator.java)
2. Notice the method multiply.
3. Create folder /src/test/java and Create a file CalculatorTest.java inside the folder.
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


## 2.2 JUnit test class naming conventions

Build tools like Maven use a pattern to decide if a class is a test classes or not. The following is the list of classes Maven considers automatically during its build:

**/Test*.java           
**/*Test.java           
**/*Tests.java          
**/*TestCase.java       

- includes all of its subdirectories and all Java filenames that start with Test.
- includes all of its subdirectories and all Java filenames that end with Test.
- includes all of its subdirectories and all Java filenames that end with Tests.
- includes all of its subdirectories and all Java filenames that end with TestCase.
Therefore, it is common practice to use the Test or Tests suffix at the end of test classes names.

## 2.2 Where should the test be located?
Typical, unit tests are created in a separate source folder to keep the test code separate from the real code. The standard convention from the Maven and Gradle build tools is to use:

src/main/java - for Java classes

src/test/java - for test classes
