/*
 /*
 Who Wants To Be A Programmer Algorithim
 Declared Vaiables score, userAnswer1-5, userAnswer22
 Variable types: int, char
 1. Display Prompt
 2. Enter Name
 3. Greeting
 4. Menu
 - Display
 - Start Game
 - Exit
 * (Rules Display)
 - Leads back to Start of game
 * (Start Game)
 - Question 1
 - Question 2
 - Question 3
 - Question 4
 - Question 5
 -Question 6
 - Question 7
 * (Exit)
 - Display Exit Prompt
 */
import javax.swing.JOptionPane;

public class JavaV3 {
    private static int score;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Who Wants to Be a Java Programmer?", "Welcome", JOptionPane.PLAIN_MESSAGE);
        String name = JOptionPane.showInputDialog("Please enter your name:");

        JOptionPane.showMessageDialog(null, "Hello, " + name + "!", "Introduction", JOptionPane.PLAIN_MESSAGE);

        boolean playAgain;
        boolean validChoice = false;
        do {
            playAgain = false;

            do {
                Object[] options = {"See Rules", "Start Test", "Exit"};
                int choice;
                do {
                    choice = JOptionPane.showOptionDialog(null, "Main Menu:", "Menu",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, options[2]);
                } while (choice < 0 || choice > 2);

                switch (choice) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Rules of the test:\n" +
                                "1. You will be tested on a set of 7 multiple-choice questions relating to Java.\n" +
                                "2. These questions relate to chapters one, two, and three.\n" +
                                "3. Have fun!", "Rules", JOptionPane.INFORMATION_MESSAGE);

                        Object[] startTestOptions = {"Start Test", "Back to Main Menu"};
                        int startTestChoice = JOptionPane.showOptionDialog(null, "Do you want to start the test now?", "Start Test", 
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, startTestOptions, startTestOptions[0]);
                        
                        if (startTestChoice == 0) {
                            validChoice = true;
                            startTest(name);
                        }
                        break;
                    case 1:
                        startTest(name);
                        validChoice = true;
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Thank you for playing. Goodbye, " + name + "!",
                                "Goodbye", JOptionPane.PLAIN_MESSAGE);
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please choose a valid option (1/2/3).",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        validChoice = false;
                }
            } while (!validChoice);

            String playAgainChoice = JOptionPane.showInputDialog("Do you want to play again? (yes/no)").toLowerCase();
            if (playAgainChoice.equals("yes")) {
                playAgain = true;
            }
        } while (playAgain);
    }

    private static void startTest(String name) {
        score = 0;

        // Question 1
        score = askQuestion("Question 1: What does JVM stand for?", "A) Java Virtual Machine\nB) Java Very Main\nC) Java Virtual Method\nD) Java Viable Memory", "A", score);

        // Question 2
        score = askQuestion("Question 2: What is the java source file extension?", "A) .javaexe\nB) .javas\nC) .java\nD) .exe", "C", score);

        // Question 3
        score = askQuestion("Question 3: What are comments used for?", "A) To tell the compiler what it needs to do\nB) To close a line of code\nC) To keep reminders and notes\nD) To define the scope of the class", "C", score);

        // Question 4
        score = askQuestion("Question 4: The else statement means what?", "A) It means the boolean statement is true\nB) That your code has an error\nC) An alternative statement\nD) You have more options to choose", "C", score);

        // Question 5
        score = askQuestion("Question 5: Which is an example of a Logical Operator?", "A) !\nB) >\nC) ||\nD) All of the above", "D", score);

        // Question 6
        String answer6 = JOptionPane.showInputDialog("Question 6: A loop that repeats a specific number of times is known as a ? \n" +
                "A) if/then loop\n" +
                "B) do-while loop\n" +
                "C) count-controlled loop\n" +
                "D) All of the above\n" +
                "Your answer (A/B/C/D): ").toUpperCase();
        if (answer6.equals("C")) {
            score += 1; // Assigned a point value for Question 6
            JOptionPane.showMessageDialog(null, "Correct! You gained 1 point. Your current score: " + score, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is C. Your current score: " + score, "Result", JOptionPane.ERROR_MESSAGE);
        }

        // Question 7
        String answer7 = JOptionPane.showInputDialog("Question 7: To increment a number which symbol do you use? \n" +
                "A) ++\n" +
                "B) xx\n" +
                "C) --\n" +
                "D) All of the above\n" +
                "Your answer (A/B/C/D): ").toUpperCase();
        if (answer7.equals("A")) {
            score += 1; // Assigned a point value for Question 7
            JOptionPane.showMessageDialog(null, "Correct! You gained 1 point. Your current score: " + score, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is A. Your current score: " + score, "Result", JOptionPane.ERROR_MESSAGE);
        }

        // Display the total score
        JOptionPane.showMessageDialog(null, "Thank you for playing, " + name + "!\nYour total score is: " + score, "Test Results", JOptionPane.INFORMATION_MESSAGE);
    }

    private static int askQuestion(String question, String options, String correctAnswer, int currentScore) {
        String userAnswer;
        do {
            userAnswer = JOptionPane.showInputDialog(question + "\n" + options + "\nYour answer (A/B/C/D): ").toUpperCase();
        } while (!userAnswer.equals("A") && !userAnswer.equals("B") && !userAnswer.equals("C") && !userAnswer.equals("D"));

        if (userAnswer.equals(correctAnswer)) {
            currentScore++;
            JOptionPane.showMessageDialog(null, "Correct! You gained 1 point. Your current score: " + currentScore, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + correctAnswer + ". Your current score: " + currentScore, "Result", JOptionPane.ERROR_MESSAGE);
        }

        return currentScore;
    }
}
