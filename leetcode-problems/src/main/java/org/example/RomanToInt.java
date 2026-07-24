package org.example;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static int convertRomanToInt(String s) {

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        characterIntegerMap.put('I', 1);
        characterIntegerMap.put('V', 5);
        characterIntegerMap.put('X', 10);
        characterIntegerMap.put('L', 50);
        characterIntegerMap.put('C', 100);
        characterIntegerMap.put('D', 500);
        characterIntegerMap.put('M', 1000);

        int inteiro = 0;

        for(int i = 0; i < s.length(); i++) {
            char atual = s.charAt(i);
            int valorAtual = characterIntegerMap.get(atual);
            if (i < s.length() - 1) {
                char proximo = s.charAt(i + 1);
                int valorProximo = characterIntegerMap.get(proximo);

                if (valorAtual < valorProximo) {
                    inteiro -= valorAtual;
                } else {
                    inteiro += valorAtual;
                }

            } else {
                inteiro += valorAtual;
            }
        }

        return inteiro;

    }

    static void main() {
        System.out.println(convertRomanToInt("MCDIV"));

    }
}
