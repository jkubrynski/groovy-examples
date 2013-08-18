package com.kubrynski.groovy

/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
@Singleton
class CartFactory {

  Cart newCart() {
    new Cart()
  }
}
