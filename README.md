# Hibernate Person Management Application 
This is a simple Java
application that manages person records using Hibernate as the ORM
(Object-Relational Mapping) framework.

## Features 
Sign up: Users can create new person records by providing their details such as name, email, phone, address, and password.
Login: Users can log in using their email and password.
-- Find person by:
ID
Phone number
Name
-- Delete person by:
ID
Phone number
Email
-- Find all persons: Retrieve a list of all person records.
-- Update person details:
Name
Email
Phone
Password
Address

## Console output
press 
1.SignUp 
2.login
1
Enter the id
1
enter the name
John Doe
enter the phone
1234567890
enter the email
john@example.com
enter the address
123 Main Street
enter password
password123
press 
1.SignUp 
2.login
2
enter the email
john@example.com
enter password
password123
login successful
press 
1.find person by ID 
2.find person by phone 
3.find person by name 
4.delete Person by id
5.delete person by phone 
6.delete person by email 
7.find all Person
8.update 
0.Exit
7
[Person{id=1, name='John Doe', phone=1234567890, email='john@example.com', address='123 Main Street', password='password123'}]
press 
1.find person by ID 
2.find person by phone 
3.find person by name 
4.delete Person by id
5.delete person by phone 
6.delete person by email 
7.find all Person
8.update 
0.Exit
3
find person by name
John Doe
Person{id=1, name='John Doe', phone=1234567890, email='john@example.com', address='123 Main Street', password='password123'}
press 
1.find person by ID 
2.find person by phone 
3.find person by name 
4.delete Person by id
5.delete person by phone 
6.delete person by email 
7.find all Person
8.update 
0.Exit
8
Choose what to update:
1. Name
2. Email
3. Phone
4. Password
5. Address
0. Back to main menu
1
Enter ID:
1
Enter new name:
John Smith
Result after Update
Person{id=1, name='John Smith', phone=1234567890, email='john@example.com', address='123 Main Street', password='password123'}
press 
1.find person by ID 
2.find person by phone 
3.find person by name 
4.delete Person by id
5.delete person by phone 
6.delete person by email 
7.find all Person
8.update 
0.Exit
7
[Person{id=1, name='John Smith', phone=1234567890, email='john@example.com', address='123 Main Street', password='password123'}]
press 
1.find person by ID 
2.find person by phone 
3.find person by name 
4.delete Person by id
5.delete person by phone 
6.delete person by email 
7.find all Person
8.update 
0.Exit
0
Exiting...

