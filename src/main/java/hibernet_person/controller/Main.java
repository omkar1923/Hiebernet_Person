package hibernet_person.controller;

import java.util.List;
import java.util.Scanner;

import hibernet_person.dao.PersonDao;
import hibernet_student.dto.Person;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PersonDao dao = new PersonDao();
        boolean isLoggedIn = false; // Track login status

        while (!isLoggedIn) {
            System.out.println("press \n1.SignUp \n2.login");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                	Person person = new Person();
        			System.out.println("Enter the id");
        			person.setId(scanner.nextInt());
        			System.out.println("enter the name");
        			person.setName(scanner.next());
        			System.out.println("enter the phone");
        			person.setPhone(scanner.nextLong());
        			System.out.println("enter the email");
        			person.setEmail(scanner.next());
        			System.out.println("enter the address");
        			person.setAddress(scanner.next());
        			System.out.println("enter password");
        			person.setPassword(scanner.next());

        			dao.savePerson(person);
                    break;
                case 2:
                	Person person1 = new Person();
        			System.out.println("enter the email");
        			String email = scanner.next();
        			System.out.println("enter password");
        			String password = scanner.next();
        			Person dbPerson = dao.getPerson(email);
        			if (dbPerson != null) {
        				if (password.equals(dbPerson.getPassword())) {
        					System.out.println("login successful");
        					isLoggedIn = true;
        				} else {
        					System.err.println("invalid password");

        				}
        			} else {
        				System.err.println("invalid email provided");
        			}
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        // Operations accessible only after successful login
        System.out.println(
                "press \n1.find person by ID \n2.find person by phone \n3.find person by name \n4.delete Person by id\n5.delete person by phone \n6.delete person by email \n7.find all Person\n8.update ");
        int choice = scanner.nextInt();
        if(isLoggedIn) {
            switch (choice) {
                case 1:

        			System.out.println("enter id");
        			int id = scanner.nextInt();

        			Person findById = dao.findById(id);
        			if (findById != null)
        				System.out.println(findById);
        			else
        				System.out.println("invalid id");
                    break;
                case 2:
                	System.out.println("enter phone no");
        			long phone = scanner.nextLong();
        			Person findByPhone = dao.findByPhone(phone);
        			if (findByPhone != null) {
        				System.out.println(findByPhone);

        			} else {
        				System.err.println("invalid phone No  provided");
        			}
                    break;
                case 3:
                	System.out.println("find person by name");
        			String name = scanner.next();
        			Person findByName = dao.findByName(name);
        			if (findByName != null) {
        				System.out.println(findByName);
        			} else {
        				System.err.println("plz provid valid name");
        			}
                    break;
                case 4:
                	System.out.println("enter the id to delete data");
        			int id1 = scanner.nextInt();
        			dao.deleteById(id1);
                    break;
                case 5:
                	System.out.println("enter the phone no to delete data");
        			long phone1 = scanner.nextLong();
        			dao.deleteByPhone(phone1);
                    break;
                case 6:
                	System.out.println("enter the email no to delete data");
        			String email1 = scanner.next();
        			dao.deleteByEmail(email1);
                    break;
                case 7:
                	List<Person> list=dao.displayAll();
        			System.out.println(list);
                    break;
                case 8:
                	 updateMenu(scanner, dao);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
     
    }
    public static void updateMenu(Scanner scanner, PersonDao dao) {
        System.out.println("Choose what to update:");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone");
        System.out.println("4. Password");
        System.out.println("5. Address");
        System.out.println("0. Back to main menu");
        int choice = scanner.nextInt();
        int id;
     
        switch (choice) {
            case 1:
                System.out.println("Enter ID:");
                id = scanner.nextInt();
                System.out.println("Enter new name:");
             String name = scanner.next();
               Person person= dao.updateName(id, name);
               if(person!=null) {
               System.out.println("Result after Update");
               
               System.out.println(person);
               }else {
            	   System.err.println("invalid id provided");
               }
                break;
            case 2:
                // Update email logic
            	 System.out.println("Enter ID:");
                 id = scanner.nextInt();
                 System.out.println("Enter new email:");
                 String email = scanner.next();
               Person person2=  dao.updateEmail(id,email);
               if(person2!=null) {
               System.out.println("Result after Update");
               System.out.println(person2);
               }
               else System.err.println("invalid id provided");
                break;
            case 3:
                // Update phone logic
            	 System.out.println("Enter ID:");
                 id = scanner.nextInt();
                 System.out.println("Enter new Phone:");
                 Long phone = scanner.nextLong();
                Person person3= dao.updatePhone(id, phone);
                if(person3!=null) {
                System.out.println("Result after Update");
                System.out.println(person3);
                }
                else System.err.println("invalid id provided");
                break;
            case 4:
                // Update password logic
            	 System.out.println("Enter ID:");
                 id = scanner.nextInt();
                 System.out.println("Enter new Password:");
                 String password = scanner.next();
                Person person4= dao.updatePassword(id, password);
                if(person4!=null) {
                System.out.println("Result after Update");
                System.out.println(person4);}
                else System.err.println("invalid id provided");
                break;
            case 5:
                // Update address logic
            	 System.out.println("Enter ID:");
                 id = scanner.nextInt();
                 System.out.println("Enter new Address:");
                 String address = scanner.next();
                 
               Person person5=  dao.updateAddress(id,address);
               if(person5!=null) {
               System.out.println("Result after Update");
               System.out.println(person5);}
               else System.err.println("invalid id provided");
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}