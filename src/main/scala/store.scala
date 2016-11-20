package com.beis.application
import scala.collection.mutable.HashMap

class Store(items:Array[Fruit])
{
  //Convert input array of fruit to a map
  val stock=items.map(x=>(x.name,x)).toMap

  def bill(items: String) : (Double) =
  {
    val counts=new HashMap[String,Int]
    var discount:Double=0.0
    val commaParse="([^,]+)".r
    val baseCharge=commaParse.findAllIn(items).foldLeft(0.0)((sum,item)=>sum+(stock(item).price))

    commaParse.findAllIn(items).foreach(name=>
      if(counts.isDefinedAt(name))
      {
        counts(name)+=1
      }
      else
      {
        counts(name)=1
      })

    counts.keys.foreach(name=>
      discount=discount+stock(name).discountFor(counts(name)))

    return math.rint((baseCharge-discount)*100)/100
  }
}
