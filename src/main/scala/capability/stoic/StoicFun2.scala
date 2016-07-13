package capability
package stoic

import types.Pure

trait StoicFun2[-T1, -T2, +R, -C <: Pure] extends StoicFun[C] {
  def apply(e1: T1, e2: T2)(implicit c: C): R
}
