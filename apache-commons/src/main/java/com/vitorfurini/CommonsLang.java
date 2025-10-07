package com.vitorfurini;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class CommonsLang {

    public void commonsLangSimpleExample() throws IOException {
        String someString = "";

        // w/o Apache Commons
        if (someString == null || someString.trim().isEmpty()) {
            System.out.println("Invalid string");
        }

        // w/ Apache Commons
        if (StringUtils.isBlank(someString)) {
            System.out.println("Invalid string");
        }
    }
}