import capability.types._

object $System {

  def currentTimeMillis()(implicit c: NonDeterministic): Long =
    System.currentTimeMillis()

  def nanoTime()(implicit c: NonDeterministic): Long =
    System.nanoTime()

  def lineSeparator()(implicit c: Pure): String =
    System.lineSeparator()

  object out {
    def println()(implicit c: Output): Unit = System.out.println()
    def println(s: String)(implicit c: Output): Unit = System.out.println(s)
  }
}

