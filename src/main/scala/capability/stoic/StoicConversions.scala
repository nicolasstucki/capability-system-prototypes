package capability.stoic

import scala.language.implicitConversions

import capability.types.Pure
import capability.types.Unchecked
import capability.UncheckedCapabilities._

object StoicConversions {

  def stoic[R, C <: Pure](f: C => Function0[R]): StoicFun0[R, C] = new StoicFun0[R, C] {
    override def apply()(implicit c: C): R = f(c)()
  }

  def stoic[T1, R, C <: Pure](f: C => Function1[T1, R]): StoicFun1[T1, R, C] = new StoicFun1[T1, R, C] {
    override def apply(e: T1)(implicit c: C): R = f(c)(e)
  }

  def stoic[T1, T2, R, C <: Pure](f: C => Function2[T1, T2, R]): StoicFun2[T1, T2, R, C] = new StoicFun2[T1, T2, R, C] {
    override def apply(e1: T1, e2: T2)(implicit c: C): R = f(c)(e1, e2)
  }

  def stoic[T1, T2, T3, R, C <: Pure](f: C => Function3[T1, T2, T3, R]): StoicFun3[T1, T2, T3, R, C] = new StoicFun3[T1, T2, T3, R, C] {
    override def apply(e1: T1, e2: T2, e3: T3)(implicit c: C): R = f(c)(e1, e2, e3)
  }


  implicit def fromFun[R](f: Function0[R]): StoicFun0[R, Unchecked] =
    stoic[R, Unchecked](c => f)

  implicit def fromFun[T1, R](f: Function1[T1, R]): StoicFun1[T1, R, Unchecked] =
    stoic[T1, R, Unchecked](c => f)

  implicit def fromFun[T1, T2, R](f: Function2[T1, T2, R]): StoicFun2[T1, T2, R, Unchecked] =
    stoic[T1, T2, R, Unchecked](c => f)

  implicit def fromFun[T1, T2, T3, R](f: Function3[T1, T2, T3, R]): StoicFun3[T1, T2, T3, R, Unchecked] =
    stoic[T1, T2, T3, R, Unchecked](c => f)


  implicit def toFun[R](f: StoicFun0[R, Unchecked]): Function0[R] =
    () => f.apply()(unchecked)

  implicit def toFun[T1, R](f: StoicFun1[T1, R, Unchecked]): Function1[T1, R] =
    (e1: T1) => f.apply(e1)(unchecked)

  implicit def toFun[T1, T2, R](f: StoicFun2[T1, T2, R, Unchecked]): Function2[T1, T2, R] =
    (e1: T1, e2: T2) => f.apply(e1, e2)(unchecked)

  implicit def toFun[T1, T2, T3, R](f: StoicFun3[T1, T2, T3, R, Unchecked]): Function3[T1, T2, T3, R] =
    (e1: T1, e2: T2, e3: T3) => f.apply(e1, e2, e3)(unchecked)

}
