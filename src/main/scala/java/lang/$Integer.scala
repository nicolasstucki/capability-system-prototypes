package java.lang
import capability.types._

class $Integer(n: java.lang.Integer) {
  def longValue()(implicit c: Pure): Long = n.longValue()

  def byteValue()(implicit c: Pure): Byte = n.byteValue()

  def floatValue()(implicit c: Pure): Float = n.floatValue()

  def compareTo(anotherInteger: Integer)(implicit c: Pure): Int = n.compareTo(anotherInteger)

  def intValue()(implicit c: Pure): Int = n.intValue()

  def shortValue()(implicit c: Pure): Short = n.shortValue()

  def doubleValue()(implicit c: Pure): Double = n.doubleValue()

  def toString(implicit c: Pure): String = n.toString

  def equals(obj: scala.Any)(implicit c: Pure): Boolean = n.equals(obj)

  def hashCode()(implicit c: Pure): Int = n.hashCode()
}

object $Integer {
  implicit class ExtendsInteger(n: Integer) {
    def $ = new $Integer(n)
  }

}
