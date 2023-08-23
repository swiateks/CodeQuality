# Sample project for Spring Boot application on AKS with Azure Database for MySQL - Flexible Server
 
This sample project is used in the Deploy a Spring Boot application on AKS cluster with MySQL Flexible Server in a VNet Microsoft documentation tutorial.

## Prerequisites
- An Azure subscription. If you don't have an Azure subscription, create an [Azure free account](https://azure.microsoft.com/free/) before you begin. With an Azure free account, you can now try Azure Database for MySQL - Flexible Server for free for 12 months. For more details, see [Try Flexible Server for free](https://docs.microsoft.com/azure/mysql/flexible-server/how-to-deploy-on-azure-free-account).
- The [Azure Command-Line Interface (CLI)](/cli/azure/install-azure-cli).
- A supported [Java Development Kit](/azure/developer/java/fundamentals/java-support-on-azure), version 8 (included in Azure Cloud Shell).
- The [Apache Maven](https://maven.apache.org/) build tool.
- A [Git](https://github.com/) client.
- A [Docker](https://www.docker.com/) client.

## Running the project
Download the project, change directory to ```springboot-mysql-aks``` folder and follow the steps outlined in this tutorial : 

1. Create an Azure Database for MySQL - Flexible Server
2. Create an Azure Container Registry
3. Build the image and push to ACR
4. Create a Kubernetes cluster on AKS
5. Deploy the application to AKS cluster
6. Test the application
7. Clean up resources
