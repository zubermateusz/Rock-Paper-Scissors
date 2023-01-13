/*
* Rock paper scissors is a popular hand game. Two players simultaneously form one of three shapes with their hands, and then, depending on the shapes, one player wins — rock beats scissors, paper wins over rock, scissors defeats paper.
The game is well-known for fair win-conditions between equal options.

Let's start with an unfair version! :)

Write a program that reads input that states which option users have chosen. After this, your program must make users lose! That is, your program should always select an option that defeats the one picked by users. Once it finds this option, output the line Sorry, but the computer chose <option>, where <option> is the name of the option that the program's picked depending on the user's input.
For example, if users enter rock, the program should print Sorry, but the computer chose paper and so on.

Pay attention to the format of the output. It should follow the one in the example, including capital letters and punctuation. Do not print additional strings.

Just think about: in this stage, computer has to win every time.

if users choose paper, the comp chooses scissors (the computer wins);
if users choose scissors, the computer chooses rock (the computer wins);
if users choose rock, the computer chooses paper (the computer wins).
Objectives
Your program should:

Take input from the user;
Find an option that wins over the user's option;
Output the line: Sorry, but the computer chose <option>.
* */

package rockpaperscissors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String userLine = scanner.nextLine();
        if(userLine.equals("paper")){
            System.out.println("Sorry, but the computer chose scissors");
        }
        if(userLine.equals("scissors")){
            System.out.println("Sorry, but the computer chose rock");
        }
        if(userLine.equals("rock")){
            System.out.println("Sorry, but the computer chose paper");
        }
    }
}
