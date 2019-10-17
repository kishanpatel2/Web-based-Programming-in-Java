/*
Author: Kishan Patel
E-mail: kpp5282@psu.edu
Course: CMPSC 221
Assignment: Programming Assignment 3
Due date: 3/14/2019
File: Main.java
Purpose: Java application that enables a user to create a playlist from
an online music library
Compiler/IDE: IntelliJ IDEA
System: Macbook Pro
Reference(s): Java 8 API - Oracle Documentation
(http://docs.oracle.com/javase/8/docs/api/);
*/
package musicLibrary;
import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<MusicSelection> firePlaylist = new ArrayList<MusicSelection>();
    static ArrayList account = new ArrayList();

    InputStreamReader obj = new InputStreamReader(System.in);
    boolean differentOutput = false;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args)throws IOException {
        Main fireSongs = new Main();
        boolean files = fireSongs.FileRead();
        if(files)
            fireSongs.musicSelection();
    }

    public boolean FileRead()
            throws IOException {
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("/Users/kishan/Desktop/Computer Science/Computer Science 221/musicLibrary/src/musiclibrary/items.txt"));
            String inOut = inputStream.readLine();
            while(inOut != null) {
                account.add(inOut);
                inOut = inputStream.readLine();
            }
        }

        catch(FileNotFoundException e) {
            System.out.println("File wasn't not found");
            return false;
        }

        return true;
    }

    public void musicSelection() {
        System.out.println("********************************************************************************\n");
        System.out.println("Welcome to Kishan's Fire Playlist!\n");
        System.out.println("Choose an option.");
        System.out.println("1) Create Playlist");
        System.out.println("2) Delete Playlist");
        System.out.println("3) Add Selection to Playlist");
        System.out.println("4) Remove Selection from Playlist");
        System.out.println("5) Quit");
        System.out.println();
        System.out.print("Your choice: ");
        int yourChoice=input.nextInt();
        System.out.println();
        giveChoice(yourChoice);
    }

    public void giveChoice(int yourChoice) {
        switch (yourChoice) {
            case 1:
                System.out.println("********************************************************************************\n");
                if(differentOutput == true)
                {
                    System.out.println("The Playlist exists\n");
                    musicSelection();
                    return;
                }
                System.out.println("Playlist has been Created!\n");
                differentOutput = true;
                musicSelection();
                break;
            case 2:
                System.out.println("********************************************************************************\n");
                if(differentOutput == false)
                {
                    System.out.println("Sorry, there was no playlist available\n");
                    musicSelection();
                    return;
                }
                System.out.print("The playlist has entries in it. Would you still like to delete it(Y/N): ");
                String checkOutput = input.next();
                if(checkOutput.equalsIgnoreCase("y"))
                {
                    System.out.println("\nPlaylist has been deleted!\n");
                    firePlaylist.clear();
                    differentOutput = false;
                }
                else
                {
                    System.out.println("\nPlaylist was not deleted\n");
                }
                musicSelection();
                break;

            case 3:
                playlistAdder();
                break;
            case 4:
                playlistRemover();
                break;
            case 5:
                System.out.println("********************************************************************************\n");
                System.out.println("Thank You for using Kishan's Fire Playlist.");
                break;
            default:
                incorrect(yourChoice);
                break;
        }
    }

    public void incorrect(int yourChoice) {
        System.out.println(yourChoice + " is not a valid choice!\n");
        System.out.println("Please enter a number from 1 to 5\n");
        System.out.print("Your choice: ");
        yourChoice = input.nextInt();
        System.out.println();
        giveChoice(yourChoice);
    }


    public void playlistAdder() {
        System.out.println("********************************************************************************\n");
        if(differentOutput == false)
        {
            System.out.println("Please create a playlist!\n");
            musicSelection();
            return;
        }

        boolean tru = false;
        int numberCounted = 0;
        System.out.println("Choose an artist.\n");
        for(int number = 1; number < account.size(); number = number + 5) {

            for(int number2 = number - 5; number2 >= 0; number2 = number2 - 5) {
                if(account.get(number).equals(account.get(number2))) {
                    tru = true;
                }
            }

            if(tru == false)
            {
                numberCounted++;
                System.out.println(numberCounted + ") " + account.get(number));
            }

            tru = false;
        }

        System.out.print("\nYour choice? ");
        int yourChoice = input.nextInt();

        if (yourChoice > numberCounted || yourChoice < 1)
        {
            System.out.println();
            yourChoice = artistIncorrect(numberCounted, yourChoice);
        }
            yourChoice = yourChoice * 5;

        for(int number = 1; number < yourChoice; number = number + 5) {

            for(int j = number - 5; j >= 0; j = j-5)
            {
                if(account.get(number).equals(account.get(j)))
                {
                    yourChoice = yourChoice + 5;
                    break;
                }
            }
        }

        numberCounted = 0;
        System.out.println("\nChoose a title.\n");
        int artistChoice = yourChoice - 4;

        for(int number = 1; number < account.size(); number = number + 5)
        {
            if(account.get(number).equals(account.get(artistChoice)))
            {
                numberCounted++;
                System.out.println(numberCounted + ") " + account.get(number + 1));
            }
        }

        System.out.print("\nYour choice? ");
        yourChoice = input.nextInt();
        if (yourChoice > numberCounted || yourChoice < 1)
        {
            yourChoice = artistIncorrect(numberCounted, yourChoice);
        }

        yourChoice = yourChoice + artistChoice - 2;
        System.out.println(yourChoice);
        String genre = (String) account.get(yourChoice);
        String artist = (String) account.get(yourChoice + 1);
        String title = (String) account.get(yourChoice + 2);
        String album = (String) account.get(yourChoice + 3);
        String releaseDate = (String) account.get(yourChoice + 4);
        MusicSelection list = new MusicSelection(genre, artist, title, album, releaseDate);
        firePlaylist.add(list);
        System.out.println("\nYour choice \"" + title + "\" by " + artist +" has been added to the playlist.\n");
        musicSelectionSummary();
        musicSelection();
    }
    public int artistIncorrect(int count,int yourChoice) {
        while(yourChoice > count || yourChoice < 1) {
            System.out.println(yourChoice + " is not a valid choice!\n");
            System.out.println("Enter a number from 1 to "+ count + "\n");
            System.out.print("Your choice: ");
            yourChoice = input.nextInt();
            System.out.println();
        }

        return yourChoice;
    }

    public void playlistRemover() {
        System.out.println("********************************************************************************\n");
        if(differentOutput == false) {
            System.out.println("No playlist found.\n");
            musicSelection();
            return;
        }

        if(firePlaylist.isEmpty()) {
            System.out.println("There are no songs in the playlist\n");
            musicSelection();
            return;
        }

        System.out.println("Displaying current playlist ");
        musicSelectionSummary();
        System.out.println("Please enter the number of the selection you wish to remove.");
        System.out.print("Your choice: ");
        int yourChoice = input.nextInt();

        if(yourChoice > firePlaylist.size() || yourChoice < 1) {
            yourChoice = artistIncorrect(firePlaylist.size(), yourChoice);
        }

        System.out.println("\nSelection #" + yourChoice + " has been removed from the playlist.\n");
        firePlaylist.remove(yourChoice - 1);
        musicSelectionSummary();
        musicSelection();
    }
    public void musicSelectionSummary() {
        for(int number = 0; number < firePlaylist.size(); number++) {
            System.out.println("Selection #" + (number + 1) + ":");
            System.out.println(firePlaylist.get(number));
        }
    }

}
