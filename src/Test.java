import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        ArrayList<Student> allStudents = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int total = 0;
        int nOfMathStudents = 0;
        int nOfScienceStudents = 0;

        do{
            System.out.println(UserQuestions.askToJoin);
            String answerToJoin = scan.nextLine();

            if (answerToJoin.toLowerCase().startsWith("y")){
                System.out.println(UserQuestions.askFirstName);
                String firstName = scan.nextLine();

                System.out.println(UserQuestions.askLastName);
                String lastName = scan.nextLine();

                System.out.println(UserQuestions.askAge);
                int age = scan.nextInt();
                scan.nextLine();

                try {
                    Permission.checkAge(age);
                }catch (RuntimeException e){
                    System.out.println(age + " is not allowed!");
                    continue;
                }

                System.out.println(UserQuestions.askGender);
                String gender = scan.nextLine().toUpperCase();

                System.out.println(UserQuestions.askClassName);
                String className = scan.nextLine();

                try {
                    Permission.checkClassName(className);
                }catch (RuntimeException e){
                    System.out.println(className + " is not allowed!");
                    continue;
                }

                if (age >= 20 && (className.equalsIgnoreCase("math") || className.equalsIgnoreCase("science"))){
                    if (className.equalsIgnoreCase("Math")) {
                        nOfMathStudents++;
                        System.out.println("\nCongratulations! You are registered for Math class.\n");
                    }
                    else {
                        nOfScienceStudents++;
                        System.out.println("\nCongratulations! You are registered for Science class.\n");
                    }
                    total++;

                    Student student1 = new Student(firstName,lastName,age,gender,className);
                    allStudents.add(student1);
                }

            }
        }
        while (total < 3);

        for (Student allStudent : allStudents) {
            System.out.println(allStudent.getClassName() + allStudent);
        }

        System.out.println("Math students = " + nOfMathStudents);
        System.out.println("Science students = " + nOfScienceStudents);

    }
    }

