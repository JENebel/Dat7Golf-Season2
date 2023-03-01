/*
  Hjælp myren Mario med at finde hjem til dronningens fødselsdag.
  Myredronningen har snart fødselsdag, og myren Mario skal hjem og fejre hende.
  Men han har kun et kort at finde vej med.
  Hjælp Mario med at finde den korteste vej hjem, han kan kun gå på de fliser der er koloniserede,
  og han kan kun gå op, ned, højre og venstre.
  Kortet gives som et 2d array af booleans der representer om der er en koloni eller ej på den givne flise.
  Der gives et punkt 'mario' og 'queen', der angiver hvor mario og dronningen er.
  Angiv så længden af den korteste rute fra mario til dronningen.
*/

object Week4_BirthdayRoute extends App {
  case class Point(x: Int, y: Int)

  def shortestPath(map: Array[Array[Boolean]], mario: Point, queen: Point): Int = {
    // Daniels løsning på 181 chars
    var q=Set(mario)
    Stream.from(0).find(c⇒{for(Point(x,y)←q;z←x-1to x+1;w←y-1to y+1;if(z==x|w==y)&(z|w)>=0&z<map(0).size&w<map.size&c>0&&map(w)(z))q+=Point(z,w)
    q.contains(queen)}).get
  }

  val map1 = Array (
    Array(true , true , false, false), // y = 0
    Array(false, true , true , false), // y = 1
    Array(true , false, true , false), // y = 2
    Array(true , false, true , false), // y = 3
    Array(true , true , true , false), // y = 4
    // x = 0      1     2       3
  )

  assert(shortestPath(map1, Point(0, 0), Point(1, 0)) == 1)
  assert(shortestPath(map1, Point(0, 0), Point(1, 1)) == 2)
  assert(shortestPath(map1, Point(2, 4), Point(0, 0)) == 6)
  assert(shortestPath(map1, Point(2, 2), Point(0, 2)) == 6)
  assert(shortestPath(map1, Point(0, 2), Point(0, 0)) == 10)

  println("All tests passed succesfully!")
}