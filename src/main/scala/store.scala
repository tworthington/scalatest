package com.beis.application

class Store(items:Array[Fruit])
{
  //Convert input array of fruit to a map
  val stock=items.map(x=>(x.name,x)).toMap

  def bill(items: String) : (Double) =
  {
    "([^,]+)".r.findAllIn(items).foldLeft(0.0)((sum,item)=>sum+(stock(item).price))
  }
}
