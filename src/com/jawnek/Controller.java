package com.jawnek;

import com.jawnek.datamodel.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private ArrayList<Contact> contacts;
    private String file = "contacts.csv";

    public Controller(){
        contacts = new ArrayList<>();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void saveData() {
        try(BufferedWriter bufferedWriter =new BufferedWriter(new FileWriter(file))){
            Contact contact;
            for(int i=0; i<contacts.size(); i++){
                contact = contacts.get(i);
                bufferedWriter.write(contact.getFirstName()+","+contact.getLastName()+","+contact.getPhoneNr()+"\n");
            }
        }catch(IOException e){
            System.out.println("Cannot write the file.");
            e.printStackTrace();
        }
    }
    public void loadData() {
        String readedLine;
        try(Scanner scanner  = new Scanner(new BufferedReader(new FileReader(file)))){
            if(scanner == null){
                try(FileWriter fileWriter = new FileWriter(file)){
                    fileWriter.write("");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }else{
                while(scanner.hasNextLine()){
                    readedLine = scanner.nextLine();
                    String[] strings = readedLine.split(",");
                    Contact contact = new Contact(strings[0], strings[1], strings[2]);
                    contacts.add(contact);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void addContact(String firstName, String lastName, String phoneNr){

        boolean flag = false;
        Contact contact = new Contact(firstName, lastName, phoneNr);
        for(int i=0; i<contacts.size(); i++){
            if(contacts.get(i).equals(contact)){
                flag = true;
            }
        }

        if(flag){
            System.out.println("Contact already exists.");
        }else {
            this.contacts.add(contact);
            System.out.println("Contact : " + contact.getFirstName() + " " + contact.getLastName() + " added.");
        }
    }

    public void deleteContact(Contact contact){
        if(contact!=null){
            System.out.println("Contact : "+contact.getFirstName()+" "+contact.getLastName()+" removed.");
            this.contacts.remove(contact);
        }
    }

    public void editContact(Contact contact, String firstName, String lastName, String phoneNr){
        if(contacts.contains(contact)){
            for(int i=0; i<contacts.size(); i++){
                if(contact.equals(contacts.get(i))) {
                    contacts.get(i).editContact(firstName, lastName, phoneNr);
                }
            }
        }
    }


    public Contact searchContact(int index){
        if(index > this.getContacts().size()){
            System.out.println("Uncorrect number");
            return null;
        }else {
            return this.getContacts().get(index - 1);
        }
    }

}
