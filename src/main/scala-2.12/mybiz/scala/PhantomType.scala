
package mybiz.scala

/**
  * Created by arunprasath on 4/30/17.
  */
object PhantomType extends App {

  val closedDoor = Door[Closed]
  val openDoor = Door.open(closedDoor)
  val closedAgainDoor = Door.close(openDoor)

  //val closedClosedDoor = Door.close(closedDoor)
  //val openOpenDoor = Door.open(openDoor)
}

trait Status

trait Open extends Status

trait Closed extends Status

trait Door[S <: Status]

object Door {
  def apply[S <: Status] = new Door[S] {}

  def open[S <: Closed](d: Door[S]) = Door[Open]

  def close[S <: Open](d: Door[S]) = Door[Closed]
}


