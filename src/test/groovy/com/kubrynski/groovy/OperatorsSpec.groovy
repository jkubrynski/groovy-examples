package com.kubrynski.groovy

import spock.lang.Specification


/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class OperatorsSpec extends Specification {

  def "should override plus operator"() {
    when:
    Cart cart = new Cart()
    cart + new Product(name: "tv")

    then:
    cart.size() == 1
  }

  def "should use plus operator in chain"() {
    when:
    Cart cart = new Cart()
    cart + new Product(name: "tv") + new Product(name: "Game console")

    then:
    cart.size() == 2
  }

  def "should override leftShift operator"() {
    when:
    Cart cart = new Cart()
    cart << new Product(name: "tv")

    then:
    cart.size() == 1
  }

  def "should override minus operator"() {
    when:
    Cart cart = new Cart()
    def product = new Product(name: "tv")
    cart << product
    cart - product

    then:
    cart.size() == 0
  }

}