package com.beis.application

import org.scalatest._

class BeisTests extends FunSuite with BeforeAndAfter
{
  var shop: Store=_

  before
  {
    shop=new Store(Array(new Fruit("Apple",.60,2),
      new Fruit("Orange",.25,3)))
  }

  test("Empty string is 0p")
  {
    assert(shop.bill("")===0)
  }

  test("Single Apple is 60p")
  {
    assert(shop.bill("Apple")===.6)
  }

  test("Single Orange is 25p")
  {
    assert(shop.bill("Orange")===.25)
  }

  test("Apple,Apple,Orange,Apple is £2.05")
  {
    assert(shop.bill("Apple,Apple,Orange,Apple")===2.05)
  }

  test("Apple has offer rate of 2")
  {
    assert(shop.stock("Apple").offer===2)
  }
}
