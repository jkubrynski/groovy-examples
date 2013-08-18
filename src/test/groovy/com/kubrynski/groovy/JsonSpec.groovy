package com.kubrynski.groovy

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import spock.lang.Specification

/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class JsonSpec extends Specification {

  def "should parse JSON from string"() {
    when:
    def json = '{ "flights": {"flight": [{ "number":"LO231", "from":"WAW", "to":"KRK"}] } }'

    def parsedJson = new JsonSlurper().parseText(json)

    then:
    parsedJson.flights.flight[0].number == "LO231"
    parsedJson.flights.flight[0].from == 'WAW'
    parsedJson.flights.flight[0].to == 'KRK'
  }

  def "should create JSON"() {
    when:
    JsonBuilder builder = new JsonBuilder()

    builder.flights {
      flight(number: "LO231") {
        from "WAW"
        to "KRK"
      }
    }

    def json = builder.toString()
    then:
    json.contains('"number":"LO231"')
    json.contains('"from":"WAW"')
    json.contains('"to":"KRK"')
  }


}