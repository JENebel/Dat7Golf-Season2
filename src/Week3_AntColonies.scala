/*
  Myrerne er kommet og er igen ved at overtage terrassen!
  Myrekolonierne spreder sig hurtigt under fliserne, men hvor hurtigt?
  Lav en algoritme der kan udregne hvor mange fliser myrerne har spredt sig til efter et givent antal dage.
  Vi ved at en flise med en myrekoloni hver dag spreder sig til alle nabofliser.
  Dvs. nord, syd, øst, vest.
  Der kan kun være én myrekoloni pr. flise.

  Størrelsen på terrassen er angivet i antal fliser i bredden og længden.
  Der er givet et array med de fliser der har kolonier i dag,
  og det skal så udregnes hvor mange fliser der har en koloni om 'days' dage.

  Her er et lille eksempel med parametrene:
    width=5,
    length=4,
    colonies=Array(Point(2, 1), Point(0, 3)),
    days=2:

  day 0:
  . . . . .
  . . X . .
  . . . . .
  X . . . .

  day 1:
  . . X . .
  . X X X .
  X . X . .
  X X . . .

  day 2:
  . X X X .
  X X X X X
  X X X X .
  X X X . .

  Så her vil resultatet være 15

  God fornøjelse!

  Mail: joachim.e.nebel@gmail.com
*/

object Week3_AntColonies extends App {
  case class Point(x: Int, y: Int)

  def solve(width: Int, length: Int, colonies: Array[Point], days: Int): Int = {
    var s=colonies.toSet
    for(_←1to days)for(Point(x,y)←s)for((a,b)←Seq((x-1,y),(x+1,y),(x,y-1),(x,y+1)))s+=Point(a.abs-a/width,b.abs-b/length)
    s.size
  }

  // Eksemplet
  assert(solve(5, 4, Array(Point(2, 1), Point(0, 3)), 0) == 2)
  assert(solve(5, 4, Array(Point(2, 1), Point(0, 3)), 1) == 8)
  assert(solve(5, 4, Array(Point(2, 1), Point(0, 3)), 2) == 15)

  // Vejledende test
  assert(solve(10, 10, Array(Point(5, 5)), 1) == 5)
  assert(solve(10, 10, Array(Point(5, 5)), 2) == 13)
  assert(solve(10, 10, Array(Point(0, 0)), 2) == 6)
  assert(solve(10, 2,  Array(Point(0, 0)), 2) == 5)
  assert(solve(10, 10, Array(Point(0, 0), Point(1, 1)), 3) == 17)
  assert(solve(10, 10, Array(Point(0, 0), Point(1, 1), Point(9, 9)), 3) == 27)

  assert(solve(100, 100, Array(Point(70, 0), Point(12, 21), Point(33, 5)), 8) == 362)
  assert(solve(100, 100, Array(Point(12, 12), Point(45, 95), Point(22, 70), Point(65, 45), Point(79, 8)), 12) == 1485)

  assert(solve(10000, 10000, Array(
    Point(1054, 256), Point(4568, 1902), Point(9055, 4569), Point(5023, 0), Point(1231, 3653),
    Point(9876, 345), Point(9245, 8111), Point(1000, 2348), Point(6653, 2156), Point(700, 1274),
    Point(6666, 7777), Point(4444, 2222), Point(1111, 5555), Point(9999, 9922), Point(8888, 8888),
    Point(69, 420), Point(420, 6969), Point(6969, 6969), Point(420, 420), Point(4206, 9420),
    Point(1234, 5678), Point(9876, 5432), Point(1029, 3847), Point(5151, 1515), Point(8985, 3465),
    Point(0, 0), Point(666, 666), Point(42, 6969), Point(1402, 2023), Point(2224, 0214)
  ), 100) == 566379)

  println("All tests passed succesfully!")
}
