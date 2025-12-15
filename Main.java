/**
 * The main runs different methods to show players, make matches, generate players, and exit our code.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
   
    Scanner scan  = new Scanner(System.in);

    //MyQueue and Player objects to use the methods in those classes
    MyQueue match = new MyQueue();
    Player play = new Player();
    
    play.genPlayer(match);
    boolean isRunning = true;

    while (isRunning) {
        System.out.println(" 1. Show players in Queue");
        System.out.println(" 2. MatchMaking");
        System.out.println(" 3. Generate new Players");
        System.out.println(" 4. Exit");

        int choice = scan.nextInt();
        
        if(choice ==1){
            match.print();
        }
        else if(choice == 2){   
            Player[] dataTen = match.tenPlayers();
            
            if(dataTen == null){
                System.out.println("Not enough players");
            }
            else{
                match.mergeSort(dataTen);
                match.printMatch(dataTen);
            }
        }
        else if (choice == 3) {
            play.genPlayer(match);
        }
        else if (choice == 4) {
            isRunning = false;
        }   
    }

    scan.close();
    }
}