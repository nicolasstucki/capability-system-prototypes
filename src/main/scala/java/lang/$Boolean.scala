package java.lang

import capability.types._

class $Boolean(b: java.lang.Boolean) {
  def booleanValue()(implicit c: Pure): scala.Boolean = b.booleanValue()

  def compareTo(b: scala.Boolean)(implicit c: Pure): Int = b.compareTo(b)

  def toString()(implicit c: Pure): String = b.toString

  def equals(obj: scala.Any)(implicit c: Pure): scala.Boolean = b.equals(obj)

  def hashCode()(implicit c: Pure): Int = b.hashCode()
}

object $Boolean {

  implicit class ExtendsBoolean(b: java.lang.Boolean) {
    def $ = new $Boolean(b)
  }

  def FALSE(implicit c: Pure): java.lang.Boolean = java.lang.Boolean.FALSE
  def TRUE(implicit c: Pure): java.lang.Boolean = java.lang.Boolean.TRUE

  def logicalAnd(a: scala.Boolean, b: scala.Boolean)(implicit c: Pure) = java.lang.Boolean.logicalAnd(a, b)
  def logicalOr(a: scala.Boolean, b: scala.Boolean)(implicit c: Pure) = java.lang.Boolean.logicalOr(a, b)
  def logicalXor(a: scala.Boolean, b: scala.Boolean)(implicit c: Pure) = java.lang.Boolean.logicalXor(a, b)

}