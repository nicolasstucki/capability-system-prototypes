package simple.scala.collection

import capability._
import capability.types._
import capability.stoic._

trait $List[+T] {
  def head(implicit c: CanThrow[NoSuchElementException]): T
  def tail(implicit c: CanThrow[NoSuchElementException]): $List[T]

  def headOption(implicit c: Pure): Option[T]

  def map[U, C <: Pure](f: StoicFun1[T, U, C])(implicit c: C): $List[U]
  def filter[C <: Pure](p: StoicFun1[T, Boolean, C])(implicit c: C): $List[T]
  def foldLeft[A, C <: Pure](z: A)(f: StoicFun2[A, T, A, C])(implicit c: C): A

  def ::[U >: T](elem: U)(implicit c: Pure): $Cons[U] = new $Cons[U](elem, this)
}

object $List {

}

object $Nil extends $List[Nothing] {
  def head(implicit c: CanThrow[NoSuchElementException]): Nothing =
    throw new NoSuchElementException

  def tail(implicit c: CanThrow[NoSuchElementException]): $Cons[Nothing] =
    throw new NoSuchElementException

  override def headOption(implicit c: Pure): Option[Nothing] = None

  override def map[U, C <: Pure](f: StoicFun1[Nothing, U, C])(implicit c: C): $List[U] = this

  override def filter[C <: Pure](p: StoicFun1[Nothing, Boolean, C])(implicit c: C): $List[Nothing] = this

  override def foldLeft[A, C <: Pure](z: A)(f: StoicFun2[A, Nothing, A, C])(implicit c: C): A = z

  override def toString: String = "$Nil"
}

class $Cons[+T](_head: T, _tail: $List[T]) extends $List[T] {

  override def head(implicit c: CanThrow[NoSuchElementException]): T = _head

  override def headOption(implicit c: Pure): Option[T] = Some(_head)

  override def tail(implicit c: CanThrow[NoSuchElementException]): $List[T] = _tail

  override def map[U, C <: Pure](f: StoicFun1[T, U, C])(implicit c: C): $List[U] =
    new $Cons[U](f(_head), _tail.map(f))

  override def filter[C <: Pure](p: StoicFun1[T, Boolean, C])(implicit c: C): $List[T] = {
    if (p(_head)) new $Cons[T](_head, _tail.filter(p))
    else _tail.filter(p)
  }

  override def foldLeft[A, C <: Pure](z: A)(f: StoicFun2[A, T, A, C])(implicit c: C): A = {
    _tail.foldLeft(f(z, _head))(f)
  }

  override def toString: String = {
    implicit val c: CanThrow[NoSuchElementException] = mkCapability[CanThrow[NoSuchElementException]]
    head.toString + " :: " + tail.toString
  }
}

