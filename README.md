# Project: Reporting Eden Hotels & Resorts' Sales Incentive Plan for the Sales & Marketing department



## Introduction:

Your mission is to create a Java program for the Director of Sales and Marketing of Eden Hotels & Resorts. The system must store information of each Salesperson and assign them to incentive scheme based on their gained revenue per month. The system must prompt the user to input each Salesperson’s name, revenues of the sales categories they completed each month. Then, the system must calculate their Monthly Sales Revenue Ratio and use to assign them to respective rewarded sales incentives.

## System Requirement:

The system must do the following:

### A-	A warm welcoming message will show “Welcome in Eden Hotels & Resorts” when the program begins and ask the user to input the monthly target revenue for each Sales person in the S&M department


### B-	The password must be asked to input satisfy the following rules:

####•	Not be less than 12 characters.

####•	Contain at least 3 upper-case letter.

####•	Contain only 3 or 4 numbers.

####•	Contain only 2 special characters.

The system must ask the user to enter new password if the password is incorrect and allow the user only 3 attempts.

The system will continue if the password is correct.


### C-	After checking the password, the system must require the user to enter the number of Salesperson per property, the number must be between 1-15. If the number is incorrect, the system must ask the user to re-enter (a number between 1-15). The system must provide the user only five attempts. If exceeded, the program will stop.


### D-	 After entering a valid number of Salespersons, the system must inform the user to enter the names of Salespersons.


### E-	Then, the system must announce the user to enter the revenues of the sales categories of each Salesperson as follows:

####a-	“Input your revenue in Banquet” = 2
####b-	“Input your revenue in Meeting” = 2
####c-	“Input your revenue in MICE” = 3 
####d-	“Input your revenue in Room” = 3 
####e-	“Input your mark in F&B” = 2 
####f-   “Input your mark in Outside Catering” = 2


### F-	The system must calculate the Monthly Sales Revenue Ratio of each Salesperson based on the revenues that were entered in the previous step according to the following function:

MSRR = (∑ (Revenue)/monthly target revenue)*100


### G-	The system must assign Salespersons to Incentive Scheme Levels based on the following matrix:

####Incentive Scheme Level III: MSRR >= 125 (%)
####Incentive Scheme Level II: 125> MSRR <=115 (%)
####Incentive Scheme Level I: 115 > MSRR <=100 (%)
####No Incentive: MSRR <100 (%)


### H-	The system must be able to print the following:

####a-	Report 1: Salesperson Name, Incentive Scheme Level
####b-	Report 2: Number of Salespersons in Sales & Marketing department showing Salesperson distribution per each Incentive Scheme Level.
####c-	Report 3: Number of Salespersons that not accepted to receive incentive.
####d-	Report 4: Ratio of Salespersons qualified to receive incentive among the S&M department.
