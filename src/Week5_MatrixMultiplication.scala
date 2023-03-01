import scala.collection.mutable

object Week5_MatrixMultiplication extends App {
  type Matrix = mutable.ArraySeq[mutable.ArraySeq[Double]]

  def matMult(A: Matrix, B: Matrix): Matrix = {
    ???
  }

  val A: Matrix = mutable.ArraySeq(
    mutable.ArraySeq[Double](1, 2),
    mutable.ArraySeq[Double](2, 1),
  )

  val B: Matrix = mutable.ArraySeq(
    mutable.ArraySeq[Double](3, 2),
    mutable.ArraySeq[Double](2, 3),
  )

  val C: Matrix = mutable.ArraySeq(
    mutable.ArraySeq[Double](3, 2, 6),
    mutable.ArraySeq[Double](2, 3, 3),
  )

  val D: Matrix = mutable.ArraySeq(
    mutable.ArraySeq[Double](3, 2),
    mutable.ArraySeq[Double](2, 3),
    mutable.ArraySeq[Double](2, 3),
  )

  val E: Matrix = mutable.ArraySeq(
    mutable.ArraySeq[Double](7),
    mutable.ArraySeq[Double](6),
    mutable.ArraySeq[Double](2),
  )

  val F: Matrix = mutable.ArraySeq(
    mutable.ArraySeq[Double](7, 7, 0, 4),
    mutable.ArraySeq[Double](6, 69.5, 2, 4),
    mutable.ArraySeq[Double](2, 5, 64, 2),
  )

  val G: Matrix = mutable.ArraySeq(
    mutable.ArraySeq[Double](1.8, 1.5, 6.5, 2.5),
    mutable.ArraySeq[Double](4.5, 12, 200, 40),
    mutable.ArraySeq[Double](2.5, 5.5, 4.5, 12.5),
    mutable.ArraySeq[Double](2.5, 5.2, 6.5, 6.7),
  )

  assert(matMult(A, B) == mutable.ArraySeq(
    mutable.ArraySeq[Double](7, 8),
    mutable.ArraySeq[Double](8, 7),
  ))

  assert(matMult(C, D) == mutable.ArraySeq(
    mutable.ArraySeq[Double](25, 30),
    mutable.ArraySeq[Double](18, 22),
  ))

  assert(matMult(C, E) == mutable.ArraySeq(
    mutable.ArraySeq[Double](45),
    mutable.ArraySeq[Double](38),
  ))

  assert(matMult(F, G) == mutable.ArraySeq(
    mutable.ArraySeq[Double](54.1, 115.3, 1471.5, 324.3),
    mutable.ArraySeq[Double](338.55, 874.8, 13974.0, 2846.8),
    mutable.ArraySeq[Double](191.1, 425.4, 1314.0, 1018.4)
  ))

  println("All tests passed succesfully!")
}
