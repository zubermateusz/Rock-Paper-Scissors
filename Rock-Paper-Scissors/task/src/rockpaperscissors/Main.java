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
/*
* We came up with a really cool idea in the previous stage. But the game is really short. Nobody plays a single shot of rock paper scissors. We need to find a way to run the game forever. Not literally, though — let's implement a way to stop your program.

Improve your program so that it will take an unlimited number of inputs until users enter !exit. After entering !exit, the program should print Bye! and terminate. Also, let's try to handle invalid inputs: your program should be ready to handle typos in user input, or when there's a mishmash instead of a normal command. So, if the input doesn't correspond to any known command (an option or !exit), your program should output the following line: Invalid input.

Objectives
Your program should:

Take input from users;
If the input contains !exit, output Bye! and stop the game;
If the input is the name of the option, then pick a random option and output a line with the result of the game in the following format (<option> is the name of the option chosen by the program):
Loss: Sorry, but the computer chose <option>
Draw: There is a draw (<option>)
Win: Well done. The computer chose <option> and failed
If the input corresponds to anything else, output Invalid input;
Repeat it all over again.*/
/*
* How about new game rules? The original game has a fairly small choice of options.

The extended version of the game makes it hard to draw. Now, your program should accept alternative lists of options, like Rock, Paper, Scissors, Lizard, Spock, and so on. You can take the following options (don't take their relations into account; we'll speak about them further on):



In this stage, before the game starts, users can choose the options. After entering the name, they should provide a list of the options separated by a comma. For example:

rock,paper,scissors,lizard,spock
If users input an empty line, start the game with default options: rock, paper, and scissors.

Once the game options are defined, output Okay, let's start.

Regardless of the chosen options, your program, obviously, should identify which option beats which. You can use the following algorithm. First, every option produces a draw when opposed to itself. Secondly, every option beats half of the other options and is defeated by another half. How to determine which options are stronger or weaker? Take the list of options provided by the user and pick the option that you want to know the relationships of. Take all other options from the user's list. Add them to the list of options that precede the chosen option. Now, you have another list of options that don't include the user's option with a different order of elements inside. First are the options that follow the chosen one in the original list; then, there are the ones that precede it. So, in this "new" list, the first half of the options defeat the "chosen" option, and the second half is beaten by it.

Once again, never mind the "links" between the options in the picture above. They are only for illustration purposes
For example, the user's list of options is rock,paper,scissors,lizard,spock. You want to know what options are weaker than lizard. By looking at the list spock,rock,paper,scissors you realize that spock and rock beat lizard. Paper and scissors are defeated by it. For spock, it'll be almost the same, but it'll get beaten by rock and paper, and prevail over scissors and lizard.

Of course, this is not the most efficient way to determine which option prevails over which. You are welcome to try to develop other methods of tackling this problem.

Objectives
Your program should:

Output a line Enter your name: . Users enter their names on the same line (not the one following the output);
Read the input with the username and output Hello, <name>;
Read rating.txt and check whether it contains an entry with the current username. If yes, use the score specified in the file as a starting point. If not, start the score from 0;
Read the input with the list of options for the game (options are separated by comma). If the input is an empty line, play with the default options;
Output a line Okay, let's start;
Play the game by the rules defined in the previous stages and read the user's input;
If the input is !exit, output Bye! and stop the game;
If the input is the name of the option, then pick a random option and output a line with the result of the game in the following format (<option> is the name of the option chosen by the program):
Loss: Sorry, but the computer chose <option>
Draw: There is a draw (<option>)
Win: Well done. The computer chose <option> and failed
For each draw, add 50 points to the score. For each user's win, add 100 to their score. In case of a loss, don't change the score;
If input corresponds to anything else, output Invalid input;
Restart the game (with the same options defined before the start of the game).
* */

package rockpaperscissors;

import java.util.*;


public class Main {


    private static ArrayList<String> options = new ArrayList<>();
    public static class User {

        private String name;
        private int score;
        private int id;

        public User(int id, String name){
            this.id = id;
            this.name = name;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void userWin() {
            this.score += 100;
        }

        public void userDraw() {
            this.score += 50;
        }
    }
    static void loss(String option){
        System.out.println("Sorry, but the computer chose " + option);
    }

    static void draw(String option){
        System.out.println("There is a draw (" + option +") ");
    }

    static void win(String option){
        System.out.println("Well done. The computer chose "+ option+" and failed");
    }

    static boolean checkUserLine(String line) {
        boolean flag = false;
        if (line.equals("!rating")) {
            return true;
        } else {
            int i = 0;
            while (i < options.size()){
                if (options.get(i).equals(line)) {
                    flag = true;
                    break;
                }
                i++;
            }
        }
        return flag;
    }

    static int checkAndAddNewUser(ArrayList<User> listOfUsers, String userName) {
        int userId = -1;
        for (User user : listOfUsers) {
            if (user.getName().equals(userName)){
                userId = user.getId();
            }
        }
        if (userId == -1) {
            userId = listOfUsers.size();
            listOfUsers.add(new User(userId, userName));
        }
        return userId;
    }

    private static int winDrawLoss(String userLine, int computerChose) {
        int result = -1;
        int halfOfLengthOptionsArray = options.size() / 2;
        int userChoseToComparison = options.indexOf(userLine);
        int computerChoseToComparison = computerChose;

        if (computerChoseToComparison == userChoseToComparison) {
            return 1; // draw
        } else {
            if (userChoseToComparison <= halfOfLengthOptionsArray) { //first half of options
                if (userChoseToComparison > computerChoseToComparison) {
                    return 2; //loss
                }
                if (userChoseToComparison + halfOfLengthOptionsArray < computerChoseToComparison) {
                    return 2; //loss
                }
                if (userChoseToComparison + halfOfLengthOptionsArray >= computerChoseToComparison) {
                    return 0; //win
                }
            } else { //second half of options
                if (userChoseToComparison < computerChoseToComparison) {
                    return 0; //win
                }
                if (userChoseToComparison - halfOfLengthOptionsArray < computerChoseToComparison) {
                    return 2; //loss
                }
                if (userChoseToComparison - halfOfLengthOptionsArray >= computerChoseToComparison) {
                    return 0; //win
                }
            }
        }

        return result;
    } // return 0 - loss, 1 - draw, 2 - win
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String userLine;

        System.out.println("Enter your name:");
        ArrayList<User> listOfUsers = new ArrayList<>();
        String userName = scanner.nextLine();
        int userId = checkAndAddNewUser(listOfUsers, userName); //check if user name not exist add new and read id
        System.out.println("Hello, " + listOfUsers.get(userId).getName());
        String[] listOfOptions = scanner.nextLine().split(",");
        if (listOfOptions.length > 1) {
            options.addAll(Arrays.asList(listOfOptions)); // adds options form user
        } else {
            options.addAll(Arrays.asList("rock", "paper", "scissors"));
        }


        System.out.println("Okay, let's start");
        for(;;) {
            userLine = scanner.nextLine();

            if(userLine.equals("!exit")) {
                break;
            } else {
                if(checkUserLine(userLine)) {
/*
                    Stage 1-4
                    int computerChose = random.nextInt(3);

                    //draw
                    if (userLine.equals(options[computerChose])) {
                        draw(options[computerChose]);
                        listOfUsers.get(userId).userDraw();
                    }

                    //win
                    if ((userLine.equals("scissors") && computerChose == 0) || // random = papier
                            (userLine.equals("paper") && computerChose == 2) || // random = rock
                            (userLine.equals("rock") && computerChose == 1)){ // random = scissors
                        win(options[computerChose]);
                        listOfUsers.get(userId).userWin();
                    }

                    //loss
                    if ((userLine.equals("scissors") && computerChose == 2) ||// random = rock
                            (userLine.equals("paper") && computerChose == 1) ||// random = scissors
                            (userLine.equals("rock") && computerChose == 0)) { // random = paper
                        loss(options[computerChose]);
                    }
*/
                    int computerChose = random.nextInt(options.size()); //computer drows 1 options
                    switch (winDrawLoss(userLine, computerChose)) {
                        case -1 -> {
                            System.out.println("Something wrong"); break;
                        }
                        case 0 -> {
                            loss(options.get(computerChose)); break;
                        }
                        case 1 -> {
                            draw(options.get(computerChose));
                            listOfUsers.get(userId).userDraw();
                            break;
                        }
                        case 2 -> {
                            win(options.get(computerChose));
                            listOfUsers.get(userId).userWin();
                            break;
                        }
                    }
                    if (userLine.equals("!rating")) {
                        System.out.println("Your rating: " + listOfUsers.get(userId).getScore());
                    }
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
        System.out.println("Bye!");
    }




}
