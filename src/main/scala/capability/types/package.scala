package capability

package object types {

  sealed trait Pure
  object Pure extends Pure

  sealed trait CanThrow[+T <: Throwable] extends Pure {
    override def toString: String = "CanThrow"
  }
  def canThrow[T <: Throwable] = new CanThrow[T] {}


  sealed trait Complexity[+T <: Complexity.Order] extends Pure
  object Complexity {
    sealed trait Order
    sealed trait ConstantTime extends Order
    sealed trait LogTime extends ConstantTime
    sealed trait LinearTime extends LogTime
    sealed trait PolynomialTime extends LinearTime
    sealed trait ExponentialTime extends PolynomialTime
    sealed trait DivergentTime extends ExponentialTime
  }

  sealed trait Input extends Pure
  sealed trait Output extends Pure

  sealed trait IO extends Input with Output

  def nonDeterministic = new NonDeterministic {}
  sealed trait NonDeterministic extends Input {
    override def toString: String = "NonDeterministic"
  }


  sealed trait Unchecked extends CanThrow[Throwable] with NonDeterministic
}
