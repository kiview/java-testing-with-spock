package com.groovycoder.javatestingwithspock;

/**
 * Java implementation of the famous left-pad npm library.
 */
public class PadService {

    public String leftPad(String nonPadded, int totalWidth) {
        if (nonPadded == null) {
            /*
             * let's start a discussion if we should even
             * allow null values as valid input
             */
            return null;
        }

        StringBuilder builder = new StringBuilder(nonPadded);
        while (builder.length() < totalWidth) {
            builder.insert(0, " "); // workaround for missing prepend method
        }

        return builder.toString();
    }
}
