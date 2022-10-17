import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
    }
    // Функция принимает строку вида a + b, где a и b могут быть римскими или арабскими цирами в пределах от 1 до 10 и возвращает результат выражения в строке.
    public static String calc(String input) {
        String[] romanNumbers = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabicNumbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanBigNumbers = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] data = input.split(" ");
        int result = 0;
        // Массив data должен иметь ровно 3 элемента.
        if (data.length < 3) {
            System.out.println("Некорректные входные данные!");
            System.out.println("Формат математической операции не соответсвует требованиям - два операнда и один оператор (+, -, /, *)");

        } else {
            // Если оба операнда а римской системе счисления
            if (Arrays.asList(romanNumbers).contains(data[0]) && Arrays.asList(romanNumbers).contains(data[2])) {
                int newNum1 = 0, newNum2 = 0;
                // Каждый операнд поочерёдно сравнивается с каждым элементом массива romanNumbers, который содержит все римские цифры от 1 до 10
                // Если опернад совпал, то переменной newNum присваивается арабская цира, эквивалентная римской
                for (int i = 0; i < romanNumbers.length; i++) {
                    if (data[0].equals(romanNumbers[i])) {
                        newNum1 = i;
                    }
                    if (data[2].equals(romanNumbers[i])) {
                        newNum2 = i;
                    }
                }


                switch (data[1]) {
                    case "+":
                        result = newNum1 + newNum2;
                        break;
                    case "-":
                        result = newNum1 - newNum2;
                        break;

                    case "*":
                        result = newNum1 * newNum2;
                        break;
                    case "/":
                        result = newNum1 / newNum2;

                }
                // Если результат больше 10, то создаются переменные d и c, который храянт в себе целое и остаток от деления на 10 соответсвенно.
                if (result > 10) {
                    int d = result / 10, c = result % 10;
                    return romanBigNumbers[d] + romanNumbers[c];
                } else {
                    try {
                        return romanNumbers[result];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В римской системе счисления нет отрицательных значений!");
                    }

                }
                // Если оба операнда в арабской системе счисления
            } else if (Arrays.asList(arabicNumbers).contains(data[0]) && Arrays.asList(arabicNumbers).contains(data[2])) {
                int newNum1 = Integer.parseInt(data[0]), newNum2 = Integer.parseInt(data[2]);

                switch (data[1]) {
                    case "+":
                        result = newNum1 + newNum2;
                        break;
                    case "-":
                        result = newNum1 - newNum2;
                        break;

                    case "*":
                        result = newNum1 * newNum2;
                        break;
                    case "/":
                        result = newNum1 / newNum2;

                }
                return Integer.toString(result);
            }else {
                return "Использвуются разные системы счисления или входные данных не принадлежат множеству {1,2,3,4,5,6,7,8,9,10}!";
            }

        }
        return "";

    }
}

