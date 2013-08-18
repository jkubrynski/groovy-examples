package com.kubrynski.groovy

import groovy.xml.MarkupBuilder
import spock.lang.Specification


/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class XmlSpec extends Specification {

  def "should parse XML from string"() {
    when:
    def xml = '<flights><flight number="LO231"><from>WAW</from><to>KRK</to></flight></flights>'

    def parsedXml = new XmlSlurper().parseText(xml)

    then:
    parsedXml.flight[0].@number == "LO231"
    parsedXml.flight[0].from == 'WAW'
    parsedXml.flight[0].to == 'KRK'
  }

  def "should create XML"() {
    when:
    def writer = new StringWriter()
    MarkupBuilder builder = new MarkupBuilder(writer)

    builder.flights {
      flight(number: "LO231") {
        from "WAW"
        to "KRK"
      }
    }

    def xml = writer.toString()
    then:
    xml.contains("<flight number='LO231'>")
    xml.contains("<from>WAW</from>")
    xml.contains("<to>KRK</to>")
  }


}