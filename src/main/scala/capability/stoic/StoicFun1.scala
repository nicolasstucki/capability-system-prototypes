package capability
package stoic

import types.Pure

trait StoicFun1[-T1, +R, -C <: Pure] extends StoicFun[C] {
  def apply(e: T1)(implicit c: C): R
}
