package java.lang

/**
  * Created by nicolas.stucki on 17/07/16.
  */
package object $ {
  implicit class ExtendsString(str: String) {
    def $ = new $String(str)
  }


}
