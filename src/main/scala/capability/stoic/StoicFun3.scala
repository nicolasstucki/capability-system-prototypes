package capability
package stoic

import types.Pure

trait StoicFun3[-T1, -T2, -T3, +R, -C <: Pure] extends StoicFun[C] {
  def apply(e1: T1, e2: T2, e3: T3)(implicit c: C): R
}
