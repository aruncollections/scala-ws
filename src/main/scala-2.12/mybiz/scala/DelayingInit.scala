package mybiz.scala
/**
  * Created by arunprasath on 4/29/17.
  */
import scala.collection.mutable.ListBuffer;

trait SimpleApp extends DelayedInit {

  private val initCode = new ListBuffer[() => Unit]

  override def delayedInit(body: => Unit) {
    println("delayed init ")
    initCode += (() => body)
  }

  def main(args: Array[String]) = {
    println("Whoa, I'm a SimpleApp!")

    for (proc <- initCode) proc()

    println("So long and thanks for all the fish!")
  }
}

// Running the bellow class would print print:
object Test extends SimpleApp { //
  println("  Hello World!")     //   Hello World!
  println("  Hello World!")     //   Hello World!

  //type OuterInnerProjection = Outer#Inner

  val out1 = new Outer
  val out1in = new out1.Inner
}

object MainInApp extends  App {

  override  def main(args: Array[String]) = {
    println("main in app")
  }
}

class Outer {
  class Inner
}

// Type Projection (and alias) refering to Inner
