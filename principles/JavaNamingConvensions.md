They must be followed while developing software in java for good maintenance and readability of code. Java uses CamelCase as a practice for writing names of methods, variables, classes, packages and constants.

### camelCase 
camelCase is a naming convention in which the first letter of each word in a compound word is capitalized, except for the first word.

  ```java
    newStudent;
    getNewStudent()
    myVariableNameHere;
  ```

### Classes and Interfaces 
  * Class names should be nouns, in mixed case with the first letter of each internal word capitalised. Interfaces name should also be capitalised just like class names.
  * Use whole words and must avoid acronyms and abbreviations.

    ```java
      interface Student
      class OldStudent implements Student

      interface Grade
      class ComputerGrade implements Grade
    ```

### Methods
  * Methods should be verbs
  * camelCase

    ```java
      void applyChangeOfGrade(int studentId);
      void addStudentComment(string newComment);
      void closedGradingPeriod(int gradingPeriodId);
    ```

### Variables
  * Variable names should be short yet meaningful.
  * Variables can also start with either underscore(‘_’) or dollar sign ‘$’ characters.
  * Should be mnemonic i.e, designed to indicate to the casual observer the intent of its use.
  * One-character variable names should be avoided except for temporary variables.
  * Common names for temporary variables are i, j, k, m, and n for integers; c, d, and e for characters.

    ```java
    // variables for ComputerGrade class
    int studendId = 201812345;
    int year = 2021;
    ```
### Constant variables
  * Should be all uppercase with words separated by underscores (“_”).
  * There are various constants used in predefined classes like Float, Long, String etc.

    ```java
    static final int MAX_SCORE = 100;

    // Some  Constant variables used in predefined Float class
    public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
    public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
    public static final float NaN = 0.0f / 0.0f;

    ```
### Packages
  * The prefix of a unique package name is always written in all-lowercase ASCII letters and should be one of the top-level domain names, like com, edu, gov, mil, net, org.
  * Subsequent components of the package name vary according to an organisation’s own internal naming conventions.

    ``` java
    com.sun.eng
    ph.edu.univeristy.esb

    // java.lang packet in JDK
    java.lang
    ```
