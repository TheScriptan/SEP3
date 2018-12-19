# VIA-Vikar Project (SEP3)

## User Guide - How to run the project

1.Configure your PostgreSQL database and connection string
  - configure connection string in /DBServer/appsettings.json based on your P-SQL configuration
  ![connectionString](https://github.com/TheScriptan/SEP3/blob/master/Other/connectionString.png)
  
2.Start DBServer (dotnet required)
  - open command prompt in /DBServer folder and run these commands
  
3.Restore project
  ```powershell
  dotnet restore
  ```
  
4.Migrate tables to database (AKA create db tables inside database) 
  ```powershell
  dotnet ef migrations add StudentMigrInit --context StudentContext
  
  dotnet ef database update --context StudentContext
  
  dotnet ef migrations add CompanyMigrInit --context CompanyContext
  
  dotnet ef database update --context CompanyContext
  ```
  
5.Start web server
  ```powershell
  dotnet run
  ```
  
6.Start Logic Server
  - double click on LogicServer.bat
  
7.Start Client
  - double click on Client.bat
