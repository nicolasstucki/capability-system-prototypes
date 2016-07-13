package finegrained.scala.collections

import capability._
import capability.types._
import capability.stoic._

sealed trait $List[+T] {

  protected type head$cap >: CanThrow[NoSuchElementException]
  def head(implicit c: head$cap): T

  protected type tail$cap >: CanThrow[NoSuchElementException]
  def tail(implicit c: tail$cap): $List[T]

  def headOption(implicit c: Pure): Option[T]

  def ::[U >: T](elem: U)(implicit c: Pure): $Cons[U] = new $Cons[U](elem, this)
}

object $List {
  implicit class Ops[T](ls: $List[T]) {
    def map[U, C <: Pure](f: StoicFun1[T, U, C])(implicit c: C): $List[U] = ls match {
      case ls: $Cons[T] =>
        ls.map(f)
      case ls: $Nil =>
        ls.map(f)
    }
    def filter[C <: Pure](p: StoicFun1[T, Boolean, C])(implicit c: C): $List[T] = ls match {
      case ls: $Cons[T] => ls.filter(p)
      case ls: $Nil => ls.filter(p)
    }
    def foldLeft[A, C <: Pure](z: A)(f: StoicFun2[A, T, A, C])(implicit c: C): A = ls match {
      case ls: $Cons[T] => ls.foldLeft(z)(f)
      case ls: $Nil => $Nil.foldLeft(z)(f)
    }
  }

}

object $Nil extends $Nil

trait $Nil extends $List[Nothing] {
  def head(implicit c: head$cap): Nothing =
    throw new NoSuchElementException

  def tail(implicit c: tail$cap): $Cons[Nothing] =
    throw new NoSuchElementException

  override def headOption(implicit c: Pure): Option[Nothing] = None

  def map[U, C <: Pure](f: StoicFun1[Nothing, U, C])(implicit c: Pure): $List[U] = this

  def filter[C <: Pure](p: StoicFun1[Nothing, Boolean, C])(implicit c: Pure): $List[Nothing] = this

  def foldLeft[A, C <: Pure](z: A)(f: StoicFun2[A, Nothing, A, C])(implicit c: Pure): A = z

  override def toString: String = "$Nil"
}

class $Cons[+T](_head: T, _tail: $List[T]) extends $List[T] {
  protected override type head$cap = Pure
  protected override type tail$cap = Pure

  override def head(implicit c: head$cap): T = _head

  override def headOption(implicit c: Pure): Option[T] = Some(_head)

  override def tail(implicit c: tail$cap): $List[T] = _tail

  def map[U, C <: Pure](f: StoicFun1[T, U, C])(implicit c: C): $List[U] =
    new $Cons[U](f(_head), _tail.map(f))

  def filter[C <: Pure](p: StoicFun1[T, Boolean, C])(implicit c: C): $List[T] = {
    if (p(_head)) new $Cons[T](_head, _tail.filter(p))
    else tail.filter(p)
  }

  def foldLeft[A, C <: Pure](z: A)(f: StoicFun2[A, T, A, C])(implicit c: C): A = {
    tail.foldLeft(f(z, _head))(f)
  }

  override def toString: String = {
    implicit val c: Pure = pure
    head.toString + " :: " + tail.toString
  }
}
