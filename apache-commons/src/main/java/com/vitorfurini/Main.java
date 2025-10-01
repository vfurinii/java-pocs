package com.vitorfurini;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String s = "   ";

        // w/o Apache Commons
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Invalid string");
        }

        // w/ Apache Commons
        if (StringUtils.isBlank(s)) {
            System.out.println("Invalid string");
        }
    }
}