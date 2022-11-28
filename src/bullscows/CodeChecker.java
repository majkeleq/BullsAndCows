package bullscows;

import java.util.Scanner;

public class CodeChecker {

    /**
     * Metoda pobiera wygenerowany kod oraz kod od użytkownika
     * sprawdza bulls and cows, wyświetla wynik
     * Jeśli użytkownik poprawnie zgadł wynik zwraca prawdę, jeśli nie zwraca fałsz
     *
     * @param code
     * @param input
     * @return
     */
    public boolean checkInput(StringBuilder code, String input) {
        int bulls = 0;
        int cows = 0;
        boolean isGuessed = false;
        for ( int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == code.charAt(i)) {
                bulls += 1;
            } else if (code.indexOf(String.valueOf(input.charAt(i))) >= 0) {
                cows += 1;
            }
        }
        displayResult(bulls, cows);
        if (bulls == code.length()) {
            isGuessed = true;
            System.out.println("Congratulations! You guessed the secret code.");
        }
        return isGuessed;
    }

    private boolean checkIfInputValid ( int codeLength, String input) {
        if (input.length() != codeLength) {
            System.out.println("Error: input length is not valid");
            return false;
        }
        return true;
    }
    private void displayResult(int bulls, int cows) {
        StringBuilder result = new StringBuilder("Grade: ");
        if (bulls != 0 && cows != 0) {
            result.append(bulls)
                    .append(" bull(s) and ")
                    .append(cows)
                    .append(" cow(s).");
        } else if (bulls != 0) {
            result.append(bulls)
                    .append(" bull(s).");
        } else if (cows != 0) {
            result.append(cows)
                    .append(" cow(s).");
        } else {
            result.append("None.");
        }
        System.out.println(result);
    }

    public void takeTurn(Scanner sc, StringBuilder code) {
        int turn = 1;
        String input;
        do {
            System.out.println("Turn " + turn + ":");
            input = sc.nextLine();
            turn += 1;
            if (!checkIfInputValid(code.length(), input)) {
                return;
            }
        } while (!checkInput(code, input));
    }
}
