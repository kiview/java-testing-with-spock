package com.groovycoder.javatestingwithspock

import spock.lang.Specification

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

}
