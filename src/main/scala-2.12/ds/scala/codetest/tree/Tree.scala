package ds.scala.codetest.tree

import scala.annotation.tailrec

case class Tree(var x: Int, var l: Option[Tree], var r: Option[Tree]) {
  override def toString = s"($x, ${l.getOrElse(None)}, ${r.getOrElse(None)})"
}

object Tree {
  def apply(x: Int, l: Tree, r: Tree) = new Tree(x, Some(l), Some(r))
  def apply(x: Int, l: Option[Tree], r: Tree) = new Tree(x, l, Some(r))
  def apply(x: Int, l: Tree, r: Option[Tree]) = new Tree(x, Some(l), r)
}

object TestingTree extends App {
  // var tree = Tree(5, Tree(3, None, None), Tree(10, Tree(12, Tree(21, None, None), Tree(20, None, None)), None))
  // val tree = Tree(5, Tree(3, None, None), Tree(10, Tree(12, Tree(21, None, None), Tree(20, None, None)), None))
  // var tree = Tree(5, None, None)
  // var tree = Tree(5, Tree(8, Tree(12, None, None), Tree(2, None, None)), Tree(9, Tree(7, Tree(1, None, None), None), Tree(4, Tree(3, None, None), None)))
  var tree = Tree(5, Tree(3, Tree(20, None, None), Tree(21, None, None)) , Tree(10, Tree(1, None, None), None))
  // var tree = Tree(8, Tree(2, Tree(8, None, None), Tree(7, None, None)), Tree(6, None, None))
  // val tree = null

  // println("Height: " + maxDepth(if(tree != null) Some(tree) else None))
  // println("Ampl: " + amplitude(if(tree != null) Some(tree) else None))
  println("Visibile: " + countVisibileNodes(if(tree != null) Some(tree) else None))

  def maxDepth(root: Option[Tree]): Int = {
    if (root.isEmpty) {
      println("Root is empty ")
      -1
    } else {
      println("Adding depth for the root: " + root.getOrElse(""))
      val l = maxDepth(root.map {t => t.l}.flatten)
      println("l: " + l)
      val r = maxDepth(root.map {t => t.r}.flatten)
      println("r: " + r)

      max(l , r) + 1
    }
  }

  def amplitude(root: Option[Tree]): Int = {
    if (root.isEmpty) return 0
    depthSearch(root, Integer.MAX_VALUE, Integer.MIN_VALUE)
  }

  def depthSearch(root: Option[Tree], minimum: Int, maximum: Int): Int = {
    if (root.isEmpty) return maximum - minimum
    val mn = if (root.get.x < minimum) root.get.x else minimum
    val mx = if (root.get.x > maximum) root.get.x else maximum
    max(depthSearch(root.get.l, mn, mx), depthSearch(root.get.r, mn, mx))
  }

  def countVisibileNodes(root: Option[Tree]) = { println(root); getVisible(root, Integer.MIN_VALUE) }

  def getVisible(root: Option[Tree], maxValue: Int): Int = {
    if (root.isEmpty) return 0
    println("root: " + root.getOrElse(""))

    var num = 0

    val tempMax =  if (root.get.x >= maxValue) {
        num = 1
        root.get.x
      } else {
        maxValue
      }

    println("max val: " + tempMax)
    val res = getVisible(root.get.l, tempMax) + getVisible(root.get.r, tempMax)
    println("result: " + res)
    num + res
  }

  def max(x: Int, y: Int) = if(x > y) x else y


  // println("Subtree: " + getSubtree(Some(tree)))


  def getSubtree(root: Option[Tree]): Option[Tree] = {
    val value = 10

    root.foreach(x => println("Checking: ", x, x.x))
    root.foreach(x => println("Checking: x: ", (root.get.x), value))
    root.foreach(x => println("Checking: " + (root.get.x == value)))

    if (root.isEmpty) {
      println("Empty")
      None
    } else if(root.get.x == value) {
      root
    } else {
      if(root.get.x < value)
        getSubtree(root.get.l)
      else
        getSubtree(root.get.r)
    }
  }
}