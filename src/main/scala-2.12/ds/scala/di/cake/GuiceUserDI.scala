package ds.scala.di.cake

import javax.inject._

case class User(id: String, name: String, email: String)


trait UserDALComponent {

  def getUser(id: String): User

  def create(user: User)

  def delete(user: User)

}

class UserDAL extends UserDALComponent {
  // a dummy data access layer
  def getUser(id: String): User = {
    val user = User("12334", "testUser", "test@knoldus.com")
    println("UserDAL: Getting user " + user)
    user
  }

  def create(user: User) = {
    println("UserDAL: creating user: " + user)
  }

  def delete(user: User) = {
    println("UserDAL: deleting user: " + user)
  }
}

// User service which have Data Access Layer dependency

class UserService @Inject()(userDAL: UserDALComponent) {

  def getUserInfo(id: String): User = {
    val user = userDAL.getUser(id)
    println("UserService: Getting user " + user)
    user
  }

  def createUser(user: User) = {
    userDAL.create(user)
    println("UserService: creating user: " + user)
  }

  def deleteUser(user: User) = {
    userDAL.delete(user)
    println("UserService: deleting user: " + user)
  }

}


import com.google.inject.{Binder, Guice, Module}

class DependencyModule extends Module {

  def configure(binder: Binder) = {
    // list out all bindings here
    binder.bind(classOf[UserDALComponent]).to(classOf[UserDAL])

  }
}

object Test extends App {
  val injector = Guice.createInjector(new DependencyModule)
  val component = injector.getInstance(classOf[UserService]) //get UserService object

}

