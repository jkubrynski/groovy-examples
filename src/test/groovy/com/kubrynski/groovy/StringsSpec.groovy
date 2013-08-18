package com.kubrynski.groovy

import spock.lang.Specification


/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class StringsSpec extends Specification {

  def "should replace variable in GString"() {
    when:
    def name = 'Spock'
    def testGString = "Hello ${name}"

    then:
    name instanceof String
    testGString instanceof GString
    testGString == "Hello Spock"
  }

  def "should use multiline string"() {
    when:
    def multiline = """This
                       is multi-
                       line string"""

    then:
    multiline instanceof String
  }

}