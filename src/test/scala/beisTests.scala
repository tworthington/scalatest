package com.beis.application

import org.scalatest._

class BeisTests extends FunSuite with BeforeAndAfter
{
  var shop: Store=_

  before
  {
    shop=new Store(Array(new Fruit("Apple",.60), new Fruit("Orange",.25)))
  }

}
