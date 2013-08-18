package com.kubrynski.groovy

import spock.lang.Specification


/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class AstSpec extends Specification {

  def "should be immutable type"() {
    when:
    def product = new Product(name: "tv", price: 20.0) // uses @Immutable
    product.price = 21.0

    then:
    thrown(ReadOnlyPropertyException)
  }

  def "should delegate to field"() {
    when:
    def cart = new Cart() // uses @Delegate
    cart.user.email = "foo@bar.org"

    then:
    cart.email == "foo@bar.org"
  }

  def "should provide singleton instance"() {
    when:
    def cartFactory1 = CartFactory.instance // CartFactory is @Singleton
    def cartFactory2 = CartFactory.instance

    then:
    cartFactory1 == cartFactory2
  }

  def "should thrown exception when instantiating singleton"() {
    when:
    new CartFactory() // CartFactory is @Singleton

    then:
    thrown(RuntimeException)
  }
}