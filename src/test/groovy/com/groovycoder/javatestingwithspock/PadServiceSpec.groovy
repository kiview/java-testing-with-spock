package com.groovycoder.javatestingwithspock

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit tests for {@link PadService}.
 */
class PadServiceSpec extends Specification {

    def "should add padding character to given string"() {
        given: "a string"
        String nonPadded = "foo"

        and: "the total width of the padded string"
        int totalWidth = 6

        and: "the service"
        PadService padService = new PadService()

        when: "given string is left padded to total width"
        String padded = padService.leftPad(nonPadded, totalWidth)

        then: "resulting string has been padded with whitespace characters reach expected width"
        padded == "   foo"
    }

    @Unroll
    def "padding string with content #nonPadded to width #totalWidth will result in '#padded' with width #padded.length()"() {
        given: "the service"
        PadService padService = new PadService()

        when: "given string is left padded to total width"
        String padResult = padService.leftPad(nonPadded, totalWidth)

        then: "resulting string has been padded with whitespace characters reach expected width"
        padResult == padded

        where:
        nonPadded | totalWidth || padded
        "foo"     | 6          || "   foo"
        "foobar"  | 6          || "foobar"
        "foobar"  | 8          || "  foobar"
        "foobar"  | -5         || "foobar"
        "baz"     | 2          || "baz"
        "baz"     | 0          || "baz"
        null      | 2          || null
    }

}
