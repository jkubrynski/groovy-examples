package com.kubrynski.groovy

/**
 * @author jkubrynski@gmail.com
 * @since 2013-08-18
 */
class Cart {

  @Delegate
  User user = new User()
  List<Product> products = new ArrayList<>()

  int size() {
    products.size()
  }

  Cart plus(Product productToAdd) {
    products.add(productToAdd)
    this
  }

  Cart leftShift(Product productToAdd) {
    products.add(productToAdd)
    this
  }

  Cart minus(Product productToRemove) {
    products.remove(productToRemove)
    this
  }
}
