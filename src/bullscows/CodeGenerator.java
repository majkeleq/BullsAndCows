package bullscows;

import java.util.Random;
import java.util.Scanner;

public class CodeGenerator {

    private StringBuilder allSymbols = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
    /**
     * Metoda pobiera zadaną przez użytkownika długość kodu,
     * a następnie generuje pseudolosową liczbę za pomocą funkcji System.nanoTime()
     * Pseudolosowa liczba jest przeszukiwana od tyłu w poszukiwaniu unikalnych wartości, które są wpisywane
     * do zmiennej "code"
     * Warunki które muszą zostać spełnione żeby dodać cyfrę do kodu:
     * 1) 0 nie może być pierwszą cyfrą kodu
     * 2) cyfra nie może się powtarzać
     * Jeśli warunki zostały spełnione to dodajemy cyfrę do kodu
     * Jeśli długość kodu osiągnęła żądaną długość to opuszczamy pętle,
     * jeśli nie to zerujemy pseudolosową liczbę i wracamy na początek pętli
     * @param codeLength
     * @return
     */
    public StringBuilder generateCode (int codeLength, int symbolNumber) {
        allSymbols.delete(symbolNumber, allSymbols.length());
        displaySecret(codeLength);
        StringBuilder code = new StringBuilder();
        int pseudoRandomNumber;
        Random random = new Random();
        while (code.length() != codeLength) {
            pseudoRandomNumber = random.nextInt(allSymbols.length());
            code.append(allSymbols.charAt(pseudoRandomNumber));
            allSymbols.deleteCharAt(pseudoRandomNumber);
        }
        return code;
    }

    public StringBuilder codeGenerator() {
        System.out.println("Please, enter the secret code's length:");
        StringBuilder code = new StringBuilder("Error!");
        Scanner sc = new Scanner(System.in);
        int codeLength = inputNumber(sc);
        if (codeLength > 36 || codeLength < 1) {
            System.out.println(code.append(" Code length has to be between 1 and 36 (inclusive)"));
            return code;
        }
        System.out.println("Input the number of possible symbols in the code");
        int symbolNumber = inputNumber(sc);
        if (symbolNumber < codeLength || symbolNumber > 36) {
            System.out.println(code.append(" Number of possible symbols must be greater than code length and less than 36"));
            return code;
        }
        code = generateCode(codeLength , symbolNumber);
        return code;
    }

    public int inputNumber(Scanner sc) {
        int number;
            number = Integer.parseInt(sc.nextLine());
        return number;
    }

    private void displaySecret(int codeLength) {
        System.out.print("The secret is prepared: ");
        System.out.print("*".repeat(codeLength) + " (");
        if (allSymbols.length() == 1) {
            System.out.println("0).");
        } else if (allSymbols.length() <= 9) {
            System.out.println("0-" + allSymbols.charAt(allSymbols.length()-1) + ").");
        } else if (allSymbols.length() == 10) {
            System.out.println("0-9, a).");
        } else {
            System.out.println("0-9, a-" + allSymbols.charAt(allSymbols.length()-1) + ").");
        }
    }
}
