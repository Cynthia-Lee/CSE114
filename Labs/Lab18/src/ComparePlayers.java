// **********************************************************
// ComparePlayers
//
// Reads in two Player objects and tells whether they represent
// the same player.
// **********************************************************

import java.util.*;

public class ComparePlayers
{
    public static void main(String[] args)
    {
      Player player1 = new Player();
      Player player2 = new Player();
      String n1; String t1; int num1;
      String n2; String t2; int num2;

      //Prompt for and read in information for player 1
      Scanner input = new Scanner(System.in);
      System.out.print("Enter player1 name: ");
      n1 = input.next();
      System.out.print("Enter team name : ");
      t1 = input.next();
      System.out.print("Enter jersey number: ");
      num1 = input.nextInt();
      player1.setName(n1);
      player1.setTeam(t1);
      player1.setNumber(num1);
      //Prompt for and read in information for player 2
      System.out.print("Enter player2 name: ");
      n2 = input.next();
      System.out.print("Enter team name : ");
      t2 = input.next();
      System.out.print("Enter jersey number: ");
      num2 = input.nextInt();
      player2.setName(n2);
      player2.setTeam(t2);
      player2.setNumber(num2);
      //Compare player1 to player 2 and print a message saying
      //whether they are equal
      System.out.println(player1.equals(player2));
    }
}