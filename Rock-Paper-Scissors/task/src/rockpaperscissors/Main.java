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
/*
* Well, now let's do something more tangible. Nobody wants to play the game where you always lose. We can use the power of the Random class to make the game a bit more challenging.

Write a program that reads input from users, chooses a random option, and then says who won: a user or the computer.
There are a few examples below to provide the output for any outcome (<option> is the option chosen by your program):

Loss: Sorry, but the computer chose <option>;
Draw: There is a draw (<option>);
Win: Well done. The computer chose <option> and failed;
Objectives
Your program should:

Read the user input that includes an option;
Choose a random option;
Compare the options and determine the winner;
Output one of the lines above depending on the result of the game.
* */
package rockpaperscissors;


import java.util.Random;
import java.util.Scanner;

public class Main {

    static void loss(String option){
        System.out.println("Sorry, but the computer chose " + option);
    }

    static void draw(String option){
        System.out.println("There is a draw (" + option +") ");
    }

    static void win(String option){
        System.out.println("Well done. The computer chose "+ option+" and failed");
    }
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String userLine = scanner.nextLine();
        Random random = new Random();
        String[] options = new String[]{"rock", "scissors", "paper"};
        int computerChose = random.nextInt(3);

        //draw
        if(userLine.equals(options[computerChose])){
            draw(options[computerChose]);

        }
        //win
        if(userLine.equals("scissors") && computerChose == 2){ // random = papier
            win(options[computerChose]);
        }
        if(userLine.equals("paper") && computerChose == 0){ // random = rock
            win(options[computerChose]);
        }
        if(userLine.equals("rock") && computerChose == 1){ // random = scissors
            win(options[computerChose]);
        }

        //loss
        if(userLine.equals("scissors") && computerChose == 0){ // random = rock
            loss(options[computerChose]);
        }
        if(userLine.equals("paper") && computerChose == 1){ // random = scissors
            loss(options[computerChose]);
        }
        if(userLine.equals("rock") && computerChose == 2){ // random = paper
            loss(options[computerChose]);
        }
    }


}
