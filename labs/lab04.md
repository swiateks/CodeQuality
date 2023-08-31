# 1 - SOLID Principles
In this lab you will implement each of the SOLID Principles and update the code
> Duration: 30-40 minutes

## 1.1 Update the code to comply with Single Responsibility Principle

1. Open the file [BoardPresenter.java](../module4/SOLID-main/single_responsibility/good/src/BoardPresenter.java)
2. Edit the file and copy the following code to Display Board after line 12:
  
   ```
   public void displayBoard() {
        String formattedBoard = "";
        for (int i = 0; i < this.board.size*this.board.size; i++) {
            String borderOrNewline = "";
            if ((i+1) % board.size == 0) {
                borderOrNewline += "\n";
            }
            else {
                borderOrNewline += "|";
            }
            formattedBoard += board.spots.get(i);
            formattedBoard += borderOrNewline;
        }
        System.out.print(formattedBoard);
    }

   ```
3. Open the java file [BoardShaper.java](../module4/SOLID-main/single_responsibility/good/src/BoardShaper.java)
4. Edit the file and copy the following code after line 17
   ```
    for (int i = 0; i < this.size; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < this.size; j++) {
                row.add((i*size)+(j));
            }
            rowIndexes.add(row);
        }

   ```
5. Save the file and commit the changes.
6. After the changes consider the BoardModified class in the "good" example. The only thing it is responsible for is knowing the values of its spots. It is entirely unconcerned with how those spots are being manipulated per the rules of Tic Tac Toe (rows, columns, diagonals) or displayed to the user (in a console, on the web, etc.). The BoardShaper and BoardPresenter classes are similarly focused on specific tasks. They are also only passed attributes they need; for example, BoardShaper objects are initialized with only a size (they don't need the whole board).

## 1.2 Update the code to comply with Open Closed Principle

1. Open the java file [CasualPersonality.java](../module4/SOLID-main/open_closed/good/src/CasualPersonality.java)
2. Edit the file and copy the following code after line 5.
    ```
        public String greet() {
            return "Sup bro?";
        }
    ```
3. Open the java file [FormalPersonality.java](../module4/SOLID-main/open_closed/good/src/FormalPersonality.java)
4. Edit the file and copy the following code after line 5.
    ```
        public String greet() {
            return "Good evening, sir.";
        }
    ```
5. Open the java file [IntimatePersonality.java](../module4/SOLID-main/open_closed/good/src/IntimatePersonality.java)
6. Edit the file and copy the following code after line 5.
    ```
        public String greet() {
            return "Hello Dear!";
        }
     ```
7. Notice how in the bad example, any time we want to add a new style of greeting, we have to change the Greeter class to accept a new type of personality. We don't want to have to modify our existing, working code to add something new. Instead, as demonstrated in the good example, we have a high-level Greeter class that is instantiated with some Personality... we don't know which yet, just that it will be some object that implements the Personality interface. Now we can add new objects like FormalPersonality, CasualPersonality, and IntimatePersonality, and just make sure they correctly implement the Personality interface (in this case that means they must have a `greet()` method). The Greeter class is now open for future extension, while remaining closed for modification.

## 1.3 Update the code file to be consitent with Naming Convensions

1. Open the java file [Config.java](../spring-chatgpt-sample-main/spring-chatgpt-sample-cli/src/main/java/com/microsoft/azure/spring/chatgpt/sample/cli/Config.java)
2. Notice the varaibles on 18,21,24,27 > var1, Endpoint, Key, var4.
3. Replace the values with proper varaible names in Camel Case as below:

    Replace var1 on line 18 & 41 with 
    ```
    embeddingDeploymentId 
    ```
    Replace Endpoint on line 21 & 38 with 
    ```
    openAiEndpoint
    ```
    Replace Key line 24 & 39 with 
    ```
    openAiApiKey
    ```
    Replace var4 line 27 & 47 with 
    ```
    vectorJsonFile
    ```
4. Now you have changed the variable names into the ones which make more sense and also follow consistent camel case notations

## 1.4 Update the code file to implement DRY (Don't Repeat Yourself) Principle
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
