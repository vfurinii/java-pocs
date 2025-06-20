package org.example;

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