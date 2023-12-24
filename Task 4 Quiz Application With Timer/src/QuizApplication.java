import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int TIME_LIMIT_SECONDS = 60;
    private static int currentQuestionIndex = 0;
    private static int score = 0;

    private static final String[] questions = {
        "What is the capital of India?",
        "Which fort on  Chatrapati Shivaji Maharaj born?",
        "Which cricker has 100 hundereds in cricket?",
        
    };

    private static final String[][] options = {
        {"Delhi", "Gujrat", "Chennai", "Mumbai"},
        {"Shivneri", "Purandar", "Rajgad", "Korigad"},
        {"Sachin tendular", "Virat Kholi", "Rohit Sharma", "Suresh Raina"},
        
    };

    public static void main(String[] args) 
    {
        Timer timer = new Timer();   
        timer.schedule(new TimerTask() 
        {
            
            public void run() 
            {
                endQuiz();
            }
        }, TIME_LIMIT_SECONDS * 1000);

        startQuiz();
        timer.cancel(); 
    }

    private static void startQuiz()
    {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < questions.length) 
        {
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex]);

           
            for (int i = 0; i < options[currentQuestionIndex].length; i++)
            {
                System.out.println((i + 1) + ". " + options[currentQuestionIndex][i]);
            }

            
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            
            if (userAnswer > 0 && userAnswer <= options[currentQuestionIndex].length)
            {
                String selectedOption = options[currentQuestionIndex][userAnswer - 1];
                checkAnswer(selectedOption);
            } else 
            {
                System.out.println("Invalid option. Try again.");
            }
        }

        endQuiz();
    }

    private static void checkAnswer(String selectedOption)
    {
        String correctOption = options[currentQuestionIndex][0];
        if (selectedOption.equals(correctOption))
        {
            System.out.println("Correct!");
            score++;
        } else 
        {
            System.out.println("Incorrect. The correct answer is: " + correctOption);
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            System.out.println("\nNext question:");
        } else
        {
            endQuiz();
        }
    }

    private static void endQuiz()
    {
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + " out of " + questions.length);
        System.exit(0);
    }
}
