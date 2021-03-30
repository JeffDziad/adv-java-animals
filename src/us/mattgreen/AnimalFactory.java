package us.mattgreen;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalFactory
{
    private final Scanner keyboard = new Scanner(System.in);

    public AnimalFactory(ArrayList<Talkable> list)
    {
        addAnimals(list);
    }

    public void addAnimals(ArrayList<Talkable> list)
    {
        boolean isFinished = false;
        int input = 0;
        do
        {
            System.out.println("Which animal would you like to create?");
            System.out.println("1. Cat");
            System.out.println("2. Dog");
            System.out.println("3. Teacher");
            System.out.print("> ");
            try{
                input = Integer.parseInt(keyboard.nextLine());
            }catch(NumberFormatException nfe){
                System.out.println("That is not a valid number!");
                addAnimals(list);
            }
            switch(input)
            {
                case 1:
                    list.add(makeCat());
                    break;
                case 2:
                    list.add(makeDog());
                    break;
                case 3:
                    list.add(makeTeacher());
                default:
                    break;
            }
            System.out.println("Add another? (Y/N)");
            System.out.print("> ");
            String check = keyboard.nextLine();
            char[] checkArr = check.toUpperCase().toCharArray();
            if(checkArr[0] == 'N')
            {
                isFinished = true;
            }
        }while(!isFinished);
    }

    public Cat makeCat()
    {
        boolean isFinished = false;
        String catName;
        int mousesKilled  = 0;
        System.out.print("Enter Cat Name: ");
        catName = keyboard.nextLine();
        do{
            System.out.print("Enter Mouse's Killed: ");
            try{
                mousesKilled = Integer.parseInt(keyboard.nextLine());
                isFinished = true;
            }catch(NumberFormatException nfe)
            {
                System.out.println("Please enter a number!");
            }
        }while(!isFinished);
        System.out.printf("Cat Name: %s%nMouses Killed: %d%n", catName, mousesKilled);
        return new Cat(mousesKilled, catName);
    }

    public Dog makeDog()
    {
        String dogName;
        String friendly;
        boolean isFriendly;
        System.out.print("Enter Dog Name: ");
        dogName = keyboard.nextLine();
        System.out.printf("Is %s friendly? (Yes/No): ", dogName);
        friendly = keyboard.nextLine();
        char[] friendlyArr = friendly.toUpperCase().toCharArray();
        if(friendlyArr[0] == 'Y')
        {
            isFriendly = true;
        }else
        {
            isFriendly = false;
        }
        System.out.printf("Dog Name: %s%nFriendly: %b%n", dogName, isFriendly);
        return new Dog(isFriendly, dogName);
    }

    public Teacher makeTeacher()
    {
        String teacherName;
        String ageStr;
        int ageInt = 0;
        boolean isFinished = false;
        System.out.print("Enter Teacher Name: ");
        teacherName = keyboard.nextLine();
        do{
            System.out.print("Enter Teacher Age: ");
            ageStr = keyboard.nextLine();
            try
            {
                ageInt = Integer.parseInt(ageStr);
                isFinished = true;
            }catch(NumberFormatException nfe)
            {
                System.out.println("That is not a valid age!");
            }
        }while(!isFinished);
        System.out.printf("Teacher Name: %s%nAge: %d%n", teacherName, ageInt);
        return new Teacher(ageInt, teacherName);
    }

}
