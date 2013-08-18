package com.kubrynski.groovy

import spock.lang.Specification


/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class CollectionsSpec extends Specification {

  def "should transform by invoking method on each element in collection"() {
    when:
    def strings = ['Groovy', 'is', 'great']

    then:
    strings*.size() == [5, 2, 5]
  }

  def "should transform map"() {
    when:
    def paramsMap = [key1: 'value1', key2: 'value2']

    then:
    paramsMap.collect {k, v -> "$k=$v"} == ["key1=value1", "key2=value2"]
  }

  def "should join list"() {
    when:
    def elements = ["aa", "bb", "cc"]

    then:
    elements.join('&') == "aa&bb&cc"
  }

  def "should add elements to list"() {
    when:
    def list = []
    list << 'Groovy'
    list << 'is' << 'great'

    then:
    list.size() == 3
  }

  def "should add collections"() {
    when:
    def list1 = [1, 2, 3]
    def list2 = [4, 5]
    def list3 = list1 + list2

    then:
    list3.size() == 5
  }
}