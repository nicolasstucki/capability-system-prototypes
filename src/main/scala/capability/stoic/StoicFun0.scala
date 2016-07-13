package capability
package stoic

import types.Pure

trait StoicFun0[+R, -C <: Pure] extends StoicFun[C] {
  def apply()(implicit c: C): R
}

