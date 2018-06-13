package com.jawnek;

import com.jawnek.datamodel.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static boolean quit = false;
    private static Controller controller = new Controller();
    public static void main(String[] args)  {

        printMenu();

    }

    private static void printMenu(){
        controller.loadData();
        Scanner input= new Scanner(System.in);
        while(!quit) {
            printContactList();
            printOptions();
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Name: ");
                    String name = input.nextLine();
                    System.out.println("Last name: ");
                    String lastName = input.nextLine();
                    System.out.println("Phone nr:");
                    String phoneNr = input.nextLine();
                    controller.addContact(name, lastName, phoneNr);
                    break;
                case 2:
                    System.out.println("Number of contact to edition: ");
                    int contactNr = input.nextInt();

                    input.nextLine();
                    System.out.println("New name:");
                    name = input.nextLine();
                    System.out.println("New last name:");
                    String lastNam = input.nextLine();
                    System.out.println("New phone number:");
                    phoneNr = input.nextLine();
                    controller.editContact(controller.searchContact(contactNr), name, lastNam, phoneNr);
                    System.out.println("Contact updated.");


                    break;
                case 3:
                    System.out.println("Number of contact to delete: ");
                    contactNr = input.nextInt();
                    if(controller.searchContact(contactNr)!=null){
                        controller.deleteContact(controller.searchContact(contactNr));
                    }
                    break;
                case 4:
                    quit = true;
                    break;

                default:
                    System.out.println("Wrong user input.");
                    break;
            }
            controller.saveData();
        }
    }

    private static void printOptions(){
        System.out.println("Press 1 to add new Contact; 2 to edit Contact; 3 to delete Contact; 4 to Quit");
        System.out.println("======================================");
    }

    public static void printContactList(){
        System.out.println("======================================");
        System.out.println("Contacts: ");
        ArrayList<Contact> contacts = controller.getContacts();
        if(contacts.isEmpty()){
            System.out.println("No contacts found.");
        }else{
            for(int i=0; i<contacts.size(); i++){
                System.out.println((i+1)+". "+contacts.get(i).getFirstName()
                    +" "+ contacts.get(i).getLastName()
                    +", "+ contacts.get(i).getPhoneNr());
            }
        }
        System.out.println("======================================");
    }
}
