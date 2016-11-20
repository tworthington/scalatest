package com.beis.application

// offer is # needed to get free item
class Fruit(val name: String, val price: Double, val offer: Int =0)
{
  def discountFor(n:Int):(Double) = (n/offer)*price
}


