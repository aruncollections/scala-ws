package ds.tree

case class BinaryTree(left: BinaryTree, right: BinaryTree, value: Int)


object BinaryTreeApp extends App {

  val binaryTree = BinaryTree(left = BinaryTree(BinaryTree(BinaryTree(null, null, 5), null, 1), BinaryTree(null, null, 2), 4),
    right = BinaryTree(null, null, 3), 0)

  println("height " + height(binaryTree))

  def height(node: BinaryTree): Int = {
    if (node == null) return 0
    else {
      Math.max(height(node.left) + 1, height(node.right) + 1)
    }

  }

  def inc(i: Int) = i + 1
}