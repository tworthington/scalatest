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
    assert(shop.bill("Apple,Apple,Orange,Apple")===1.45)
  }

  test("Apple has offer rate of 2")
  {
    assert(shop.stock("Apple").offer===2)
  }

  test("Two apples give rebate equal to one apple")
  {
    val item=shop.stock("Apple")
    assert(item.discountFor(2)===item.price)
  }

  test("One apple gives no rebate")
  {
    val item=shop.stock("Apple")
    assert(item.discountFor(1)===0)
  }

  test("Three Oranges give rebate equal to one orange")
  {
    val item=shop.stock("Orange")
    assert(item.discountFor(3)===item.price)
  }

  test("Two oranges give no rebate")
  {
    val item=shop.stock("Orange")
    assert(item.discountFor(2)===0)
  }

  test("Two apples costs same as one apple")
  {
    val item=shop.stock("Apple")
    assert(shop.bill("Apple,Apple")===item.price)
  }

  test("One apple is normal price")
  {
    val item=shop.stock("Apple")
    assert(shop.bill("Apple")===item.price)
  }

  test("Three Oranges costs same as 2")
  {
    val item=shop.stock("Orange")
    assert(shop.bill("Orange,Orange,Orange")===item.price*2)
  }

  test("Two oranges also same as 2")
  {
    val item=shop.stock("Orange")
    assert(shop.bill("Orange,Orange,Orange")===item.price*2)
  }

  test("1dz oranges cost £2")
  {
    val item=shop.stock("Orange")
    assert(shop.bill("Orange,Orange,Orange,Orange,Orange,Orange,Orange,Orange,Orange,Orange,Orange,Orange")===2)
  }

}
