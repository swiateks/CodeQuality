# 1 - Introduction to Code Quality
In this lab you will update and run your first code changes.
> Duration: 15-20 minutes

## 1.1 Update the code file and add comments to provide details about sections of code

1. Open the java file [AzSearchConfig.java](spring-chatgpt-sample-main/spring-chatgpt-sample-cli/src/main/java/com/microsoft/azure/spring/chatgpt/sample/cli/AzSearchConfig.java)
2. Edit the file and copy the following comment after line 12:
   ```
   // This class is provided as an example of how to configure the Azure Cognitive Search vector store.
   ```
3. Copy the following comment after line 26:
   ```
   // This bean is only created if the property vector-store.type is set to azure-search.
   ```
5. Save the file and commit the changes.
6. Now you have added meaningful code comments to make it easier for the reader to infer the functionality of the code.

## 1.2 Update the code file and adjust indentation to understand execution steps

1. Open the java file [AzSearchConfig.java](spring-chatgpt-sample-main/spring-chatgpt-sample-cli/src/main/java/com/microsoft/azure/spring/chatgpt/sample/cli/CliApplication.java)
2. Notice line 25, if block where a set of conditions are evaluated and actions are taken in a single line.
3. Now replace this line 25 with below code snippet
    ```
        if (from == null || from.size() != 1) {
            System.err.println("argument --from is required.");
            System.exit(-1);
        }
        indexPlanner.buildFromFolder(from.get(0));
     ```
