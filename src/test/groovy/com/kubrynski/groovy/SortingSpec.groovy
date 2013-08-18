package com.kubrynski.groovy

import spock.lang.Specification


/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class SortingSpec extends Specification {

  def "should sort naturally"() {
    when:
    def elements = [1, 8, 2]

    then:
    elements.sort() == [1, 2, 8]
  }

  def "should sort descending"() {
    when:
    def elements = [1, 8, 2]

    then:
    elements.sort { -it } == [8, 2, 1]
  }

  def "should sort strings by size"() {
    when:
    def strings = ["a", "ccc", "bb"]

    then:
    strings.sort { it.size() } == ["a", "bb", "ccc"]
  }

}