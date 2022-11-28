package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CodeGenerator codeGenerator = new CodeGenerator();
        CodeChecker codeChecker = new CodeChecker();
        StringBuilder code;
        try {
            code = codeGenerator.codeGenerator();
        } catch (Exception e) {
            System.out.println("Error! Number you entered isn't valid");
            return;
        }
        if (!code.toString().contains("Error!")) {
            System.out.println("Okay, let's start a game!");
            codeChecker.takeTurn(sc, code);
        }
    }
}
