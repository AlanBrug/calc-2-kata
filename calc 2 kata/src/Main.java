import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Output: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректный формат выражения");
        }

        int operand1;
        int operand2;
        try {
            operand1 = Integer.parseInt(tokens[0]);
            operand2 = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректные числа");
        }

        if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }

        String operator = tokens[1];
        int result;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция");
        }

        return String.valueOf(result);
    }
}
