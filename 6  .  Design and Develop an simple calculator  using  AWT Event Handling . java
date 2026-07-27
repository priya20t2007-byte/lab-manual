import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double firstNumber, secondNumber, result = 0;
        int choice;
        System.out.println("------------------------------------");
        System.out.println("        Simple Calculator");
        System.out.println("------------------------------------");
        System.out.print("First Number : ");
        firstNumber = sc.nextDouble();
        System.out.print("Second Number : ");
        secondNumber = sc.nextDouble();
        System.out.println("\n1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Click : ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                result = firstNumber + secondNumber;
                System.out.println("\nClick : Add");
                System.out.println("Result : " + result);
                break;
            case 2:
                result = firstNumber - secondNumber;
                System.out.println("\nClick : Subtract");
                System.out.println("Result : " + result);
                break;
            case 3:
                result = firstNumber * secondNumber;
                System.out.println("\nClick : Multiply");
                System.out.println("Result : " + result);
                break;
            case 4:
                System.out.println("\nClick : Divide");
                if (secondNumber == 0) {
                    System.out.println("Result : Cannot divide by zero");
                } else {
                    result = firstNumber / secondNumber;
                    System.out.println("Result : " + result);
                }
                break;
            default:
                System.out.println("Invalid Choice");
        }
        sc.close();
    }
}
