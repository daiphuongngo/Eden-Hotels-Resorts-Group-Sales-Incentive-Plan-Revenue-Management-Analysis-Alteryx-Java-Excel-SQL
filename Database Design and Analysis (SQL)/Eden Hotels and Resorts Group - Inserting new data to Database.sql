/*
Eden Hotel Group is a new player in the luxury hotel industry worldwide, based in Toronto, Canada. It has different brands in North America providing luxury 5-star accommodation, restaraunt's food and berage service 
and banquet catering. This new hotel group has been expanding further in Canada (reached 20 properties), the US (15), Mexico (8) and recently in West Europe, starting with City Hotels 
in Paris, France and Lausanne, Switzerland. Due to its growing brands, properties, employees, guests, customers and transactions, it requires a well-developed database to manage its business.


-- Tables:
Hotel_Brand: | ID | CITY_HOTEL_ID | EMPLOYEE_ID |
City_Hotel: | CITY_HOTEL_ID | CITY_HOTEL_NAME | CITY_HOTEL_BRAND | CITY_HOTEL_ADDRESS | 
Employee: | EMPLOYEE_ID | EMPLOYEE_NAME | DATE_OF_BIRTH | CITY_HOTEL_ID | TITLE | 
Services: | SERVICE_ID | SERVICE_NAME | PRICE | SERVICE_TYPE | 
Customer: | CUSTOMER_ID | CUSTOMER_NAME | CUSTOMER_DOB | CUSTOMER_COMPANY | CUSTOMER_CREDIT_CARD | CUSTOMER_ADDRESS | TRANSACTION_ID | CUSTOMER_BOOKING_ID |
Guest: | GUEST_ID | GUEST_NAME | GUEST_DOB | GUEST_COMPANY | GUEST_CREDIT_CARD | GUEST_ADDRESS | TRANSACTION_ID  | CUSTOMER_BOOKING_ID  |
Supplier: | SUPPLIER_ID  | SUPPLIER_NAME | PURCHASE_ORDER  | PURCHASE_TYPE | 
Orders: | ORDER_ID | SUPPLIER_ID | CUSTOMER_ID | PRODUCT_ID | PRIMARY KEY |
*/

USE Eden_Hotel_Group_Database
---Insert values to Customer---
INSERT INTO Customer (CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_DOB, CUSTOMER_COMPANY, CUSTOMER_CREDIT_CARD, CUSTOMER_ADDRESS, TRANSACTION_ID, CUSTOMER_BOOKING_ID)
VALUES (007,'Liam', 01/01/1990, 'NASA', 1234567812345678, 'Washington DC', 121212, 232345);

-------------------------------
---Insert values to Service---
INSERT INTO Services (SERVICE_ID, SERVICES_NAME, PRICE, SERVICES_TYPE) 
VALUES (001, 'Eden Restaurant', 400, 'Dining');

---Insert values to Supplier---
INSERT INTO Supplier (SUPPLIER_ID, SUPPLIER_NAME, PURCHASE_ORDER, PURCHASE_TYPE) 
VALUES (909, 'Douglas', 005, 'Rooms');

--Insert values to City Hotel
INSERT INTO Store (CITY_HOTEL_ID, CITY_HOTEL_NAME, CITY_HOTEL_BRAND, CITY_HOTEL_ADDRESS) 
VALUES (002,'Eden Garden Hotel by the Pacific Bay', 'Eden Garden', 'Vancouver', 002);

--Insert values to Employee
INSERT INTO Employee (EMPLOYEE_ID, EMPLOYEE_NAME, DATE_OF_BIRTH, CITY_HOTEL_ID, TITLE)
values (007, 'Simon', 1997/07/07, 001, 'Director of Sales and Marketing');

--Insert values to Hotel_Brand
INSERT INTO Hotel_Brand (ID, CITY_HOTEL_ID, EMPLOYEE_ID) 
VALUES (001, 001, 007);

--Insert values to Orders
INSERT INTO Orders (ORDER_ID, SUPPLIER_ID, CITY_HOTEL_ID, SERVICE_ID) 
VALUES (090, 003, 003, 202);

