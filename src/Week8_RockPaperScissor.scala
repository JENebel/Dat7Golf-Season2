object Week8_RockPaperScissor {
  /*
    Gæt sammenhængen og lav en løsning
  */
  def winnerWinner(p1: String, p2: String): String = {
    ???
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
