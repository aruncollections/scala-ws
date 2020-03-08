package mybiz.scala

class Hierarchy {

}

class Resource {

}

class Person extends Resource {

}

object Testing extends  App{

  def gen[Resource](res: Resource) : Resource = {
    res
  }

  println(gen[Person](new Person))
}
