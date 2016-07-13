package object capability {
  import types.Pure

  def pure: Pure = Pure

  def mkCapability[C <: Pure]: C = null.asInstanceOf[C]

  def printCapability(msg: String = "")(implicit c: Pure): Unit = {
    println(c.toString + ": " + msg)
  }

}
