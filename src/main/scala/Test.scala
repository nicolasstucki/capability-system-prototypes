import capability.types._
import finegrained.scala.collections._
import capability.UncheckedCapabilities._
import capability.pure

import capability.stoic.StoicConversions._

import java.lang._

object Test {

  def main(args: Array[String]): Unit = {
    implicit def p: Pure = pure

    println("hello, world!")
    val l = 1 :: 2 :: $Nil
    println(l)
    println(l.head)
    val pureFun = stoic[Int, Int, Pure](c => x => 2 * x)
    val fun = stoic[Long, NonDeterministic]( implicit c => () =>
      $System.currentTimeMillis()
    )

//    println(l.map[Int, Pure](pureFun))
    fun()(/*implicitly*/nonDeterministic)
//    ENil.head//(canThrow[NoSuchElementException])

  }
}
