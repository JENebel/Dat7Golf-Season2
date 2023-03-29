object Week8_RockPaperScissor extends App {
  /*
    Gæt sammenhængen og lav en løsning
  */
  def winnerWinner(p1: String, p2: String): String = {
    /*
      Daniels løsning der ikke compippler:
      print("hi, mom!")
    */

    // Lasses løsning på 334 chars
    val l=Seq("Sten","Saks","Papir","Rock","Paper","Scissor","Uafgjort")
    val o=l.indexOf(p1)
    val s=l.indexOf(p2)
    val m=Map((0,0)->6,(0,1)->0,(0,2)->2,(0,3)->6,(0,4)->4,(0,5)->0,(1,1)->6,(1,2)->1,(1,3)->3,(1,4)->1,(1,5)->6,(2,2)->6,(2,3)->2,(2,4)->6,(2,5)->5,(3,3)->6,(3,4)->4,(3,5)->3,(4,4)->6,(4,5)->5,(5,5)->6)
    l(m((o.min(s),s.max(o))))
  }

  assert(winnerWinner("Sten", "Saks") == "Sten")
  assert(winnerWinner("Papir", "Paper") == "Uafgjort")
  assert(winnerWinner("Saks", "Papir") == "Saks")
  assert(winnerWinner("Sten", "Papir") == "Papir")
  assert(winnerWinner("Rock", "Papir") == "Papir")
  assert(winnerWinner("Sten", "Rock") == "Uafgjort")
  assert(winnerWinner("Scissor", "Rock") == "Rock")
  assert(winnerWinner("Paper", "Scissor") == "Scissor")
  assert(winnerWinner("Saks", "Scissor") == "Uafgjort")

  println("Alt er godt. Sejt. Tillykke med det!")
}
