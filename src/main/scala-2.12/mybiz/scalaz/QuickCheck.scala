package mybiz.scalaz

import scalaz._
import Scalaz._

object QuickCheck extends App {

  type Text = String

  object Tags {
    sealed class Id
  }
  type Id = Text @@ Tags.Id
  def Id(s: String) = s.asInstanceOf[Id]

  println(Id("test"))
  println(\/.fromTryCatchNonFatal{ "123s4".toInt }.map(_*2))
  println(\/.fromTryCatchNonFatal{ "1234".toInt }.foreach(println))

  /*val v1: Validation[Throwable, Int] = 1.success[Throwable]
  val v2: Validation[Throwable, Int] = (new RuntimeException).failure[Int]
  val v3: Validation[Throwable, Int] = Validation.fromTryCatchThrowable("c".toInt)

  val result: ValidationNel[Throwable, List[Int]] =     List(v1, v2,v3).map(_.toValidationNel).sequenceU
*/

}
