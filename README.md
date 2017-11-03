# employeeproject
Employee Project in Spring. There are 2 parts to this project. One part that deals with front end task such as Controller management and Web View interface.
Second part deals with executing the backend business logic and interaction with DBMS.
First part of project is called employeeproject while second part is called employeeprojectbackend.


This project so far has been implemented with H2 Database. Please download h2 database from: www.h2database.com. You will need to download the zip package. Extract the package to your preferred location.

H2 Instructions:
----------------------------
Once extracted, open the following folder found within the newly created folder: \h2\bin
You can open the jar file which will open in DB portal in your browser.
Similarly you can execute the provided sh file as well.

In your browser DB portal, make sure the database type selected is Generic H2 (Server).
Update the string with DB URL to point to mysql57 from test.
Username to be used is root
Password is !23Qweasdzxc

If you have any questions please feel free to contact me at bilalasifkhan@qts.com

Create Database and populate:
--------------------------

Included in the employeeprojectbackend is databaseQueries.sql file
Please run the query to create DB Table.
To pre-populate the table, please run EmployeeTestCases as TESTNG found in package: com.qts.employeeprojectbackend.test - employeeproectbackend.