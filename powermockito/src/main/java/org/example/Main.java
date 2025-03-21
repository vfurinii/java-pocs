package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static int square(int num) {
                return num * num;
        }

        public int publicMethod(int num) {
                return calculateSecretValue(num);
        }

        private int calculateSecretValue(int num) {
                return num * 2;
        }
}