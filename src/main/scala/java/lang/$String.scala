package java.lang
import java.util.Locale
import java.util.stream.IntStream
import capability.types._

class $String(str: String) {

  def charAt(index: Int)(implicit c: CanThrow[IndexOutOfBoundsException]): Char = str.charAt(index)

  def matches(regex: String)(implicit c: Pure): Boolean = str.matches(regex)

  def toUpperCase(locale: Locale)(implicit c: Pure): String = str.toUpperCase(locale)

  def toUpperCase(implicit c: Pure): String = str.toUpperCase

  def contentEquals(sb: StringBuffer)(implicit c: Pure): Boolean = str.contentEquals(sb)

  def contentEquals(cs: CharSequence)(implicit c: Pure): Boolean = str.contentEquals(cs)

  def substring(beginIndex: Int)(implicit c: CanThrow[StringIndexOutOfBoundsException]): String = str.substring(beginIndex)

  def substring(beginIndex: Int, endIndex: Int)(implicit c: CanThrow[StringIndexOutOfBoundsException]): String = str.substring(beginIndex, endIndex)

  def codePointAt(index: Int)(implicit c: CanThrow[StringIndexOutOfBoundsException]): Int = str.codePointAt(index)

  def replaceAll(regex: String, replacement: String)(implicit c: Pure): String = str.replaceAll(regex, replacement)

  def indexOf(ch: Int)(implicit c: Pure): Int = str.indexOf(ch)

  def indexOf(ch: Int, fromIndex: Int)(implicit c: Pure): Int = str.indexOf(ch, fromIndex)

  def indexOf(str: String)(implicit c: Pure): Int = str.indexOf(str)

  def indexOf(str: String, fromIndex: Int)(implicit c: Pure): Int = str.indexOf(str, fromIndex)

  def compareToIgnoreCase(str: String)(implicit c: Pure): Int = str.compareToIgnoreCase(str)

  def replace(oldChar: Char, newChar: Char)(implicit c: Pure): String = str.replace(oldChar, newChar)

  def replace(target: CharSequence, replacement: CharSequence)(implicit c: Pure): String = str.replace(target, replacement)

  def lastIndexOf(ch: Int)(implicit c: Pure): Int = str.lastIndexOf(ch)

  def lastIndexOf(ch: Int, fromIndex: Int)(implicit c: Pure): Int = str.lastIndexOf(ch, fromIndex)

  def lastIndexOf(str: String)(implicit c: Pure): Int = str.lastIndexOf(str)

  def lastIndexOf(str: String, fromIndex: Int)(implicit c: Pure): Int = str.lastIndexOf(str, fromIndex)

  def toLowerCase(locale: Locale)(implicit c: Pure): String = str.toLowerCase(locale)

  def toLowerCase: String = str.toLowerCase

  def length()(implicit c: Pure): Int = str.length()

  def trim()(implicit c: Pure): String = str.trim()

  def toCharArray: Array[Char] = str.toCharArray

  def getChars(dst: Array[Char], dstBegin: Int)(implicit c: CanThrow[IndexOutOfBoundsException] & CanThrow[ArrayStoreException] & CanThrow[NullPointerException]): Unit = str.getChars(dst, dstBegin)

  def getChars(srcBegin: Int, srcEnd: Int, dst: Array[Char], dstBegin: Int)(implicit c: Pure): Unit = str.getChars(srcBegin, srcEnd, dst, dstBegin)

  def split(regex: String, limit: Int)(implicit c: Pure): Array[String] = str.split(regex, limit)

  def split(regex: String)(implicit c: Pure): Array[String] = str.split(regex)

  def codePointCount(beginIndex: Int, endIndex: Int)(implicit c: Pure): Int = str.codePointCount(beginIndex, endIndex)

  def compareTo(anotherString: String)(implicit c: Pure): Int = str.compareTo(anotherString)

  def subSequence(beginIndex: Int, endIndex: Int)(implicit c: Pure): CharSequence = str.subSequence(beginIndex, endIndex)

  def intern()(implicit c: Pure): String = str.intern()

  def contains(s: CharSequence)(implicit c: Pure): Boolean = str.contains(s)

  def concat(str: String)(implicit c: Pure): String = str.concat(str)

  def regionMatches(toffset: Int, other: String, ooffset: Int, len: Int)(implicit c: Pure): Boolean = str.regionMatches(toffset, other, ooffset, len)

  def regionMatches(ignoreCase: Boolean, toffset: Int, other: String, ooffset: Int, len: Int)(implicit c: Pure): Boolean = str.regionMatches(ignoreCase, toffset, other, ooffset, len)

  def isEmpty(implicit c: Pure): Boolean = str.isEmpty

  def endsWith(suffix: String)(implicit c: Pure): Boolean = str.endsWith(suffix)

  def offsetByCodePoints(index: Int, codePointOffset: Int)(implicit c: CanThrow[IndexOutOfBoundsException]): Int = str.offsetByCodePoints(index, codePointOffset)

  def codePointBefore(index: Int)(implicit c: CanThrow[StringIndexOutOfBoundsException]): Int = str.codePointBefore(index)

  def replaceFirst(regex: String, replacement: String)(implicit c: Pure): String = str.replaceFirst(regex, replacement)

  def equalsIgnoreCase(anotherString: String)(implicit c: Pure): Boolean = str.equalsIgnoreCase(anotherString)

  def startsWith(prefix: String, toffset: Int)(implicit c: Pure): Boolean = str.startsWith(prefix, toffset)

  def startsWith(prefix: String)(implicit c: Pure): Boolean = str.startsWith(prefix)

  def chars()(implicit c: Pure): IntStream = str.chars()

  def codePoints()(implicit c: Pure): IntStream = str.codePoints()

//  override def equals(anObject: scala.Any): Boolean = str.equals(anObject)

//  override def toString: String = str.toString

//  override def hashCode(): Int = str.hashCode()

}

object $String {

}
