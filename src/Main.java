import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int randomNumber;
        int attempts;
        int userNumber;
        int bestScore = 0;
        boolean isFirstGame = true;
        boolean playAgain = true;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            randomNumber = random.nextInt(100) + 1;
            attempts = 0;
            System.out.println("Введите число от 1 до 100:");

            while (true) {
                String input = scanner.next();

                if (input.equalsIgnoreCase("RESULT")) {
                    System.out.println("Текущее количество попыток: " + attempts);
                    System.out.println("Лучший результат: " + (isFirstGame ? "еще нет" : bestScore));
                    continue;
                }

                userNumber = Integer.parseInt(input);

                attempts++;

                if (userNumber == randomNumber) {
                    System.out.println("Поздравляю, вы выиграли!");
                    System.out.println("Количество попыток: " + attempts);

                    if (isFirstGame || attempts < bestScore) {
                        bestScore = attempts;
                        isFirstGame = false;
                    }

                    System.out.println("Лучший результат: " + bestScore);
                    break;
                } else if (userNumber > randomNumber) {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                } else {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                }
            }

            System.out.println("Хотите продолжить? Введите Y(yes) / N(no):");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("y")) {
                playAgain = true;
            } else if (choice.equalsIgnoreCase("n")) {
                playAgain = false;
                System.out.println("Игра завершена.");
            } else {
                playAgain = false;
            }
        }

        scanner.close();
    }
}