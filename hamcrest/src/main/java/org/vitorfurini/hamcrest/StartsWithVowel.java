package org.vitorfurini.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class StartsWithVowel extends TypeSafeMatcher<String> {

    @Override
    protected boolean matchesSafely(String item) {
        return item.matches("^[AEIOUaeiou].*");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a string starting with a vowel");
    }

}
