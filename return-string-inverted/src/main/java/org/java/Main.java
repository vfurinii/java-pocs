package org.java;

import java.util.Scanner;

/**
 * @author vfurinii
 */

public class Main {
    public static void main(String[] args) {
        /* inicia a classe scanner pra ler a string do usuario*/
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String original = scanner.nextLine();

        String reversed = reverseCleanString(original);
        System.out.println("String invertida (sem caracteres especiais): " + reversed);

        scanner.close();
    }

    public static String reverseCleanString(String input) {
        StringBuilder result = new StringBuilder();

        /*
            input.length() -> comeca no ultimo caractere da string
            i >= 0 -> vai ate o primeiro caracter
            i-- -> diminui a cada repeticao
         */
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);

            /*  utiliza um metodo nativo da classe Character para ignorar os caracteres especiais como !@#* */
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}