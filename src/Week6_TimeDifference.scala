/*
  Den gale videnskabsmand dr. Frankenschmirtz skal som led i sin udvikling af en tidsmaskine vide
  hvor lang tid der går mellem to begivenheder. Han vil ikke sige hvorfor det er relevant,
  eller hvorfor han ikke selv kan. Det er helt sikkert ikke fordi han er smådum og ikke kan programmere!

  Det vides at begivenhederne sker i samme døgn. Dvs. 00.00 og 23.59 er 23 timer og 59 minutter adskilt.
  Inputs gives som strings der altid er formateret "xx.xx", og outputtet skal formateres ligesådan.
 */

object Week6_TimeDifference extends App {
  def elapsed(event1: String, event2: String): String = {
    // Lasses 127 char løsning
    var v=event1
    def p=v.take(2).toInt+v.slice(3,5).toFloat/60
    val d=(p-{v=event2;p}).abs
    "%02d.%02d"format(d.toInt,(d%1*60).round)
  }

  assert(elapsed("07.59", "00.00") == "07.59")
  assert(elapsed("10.00", "05.00") == "05.00")
  assert(elapsed("05.32", "03.14") == "02.18")
  assert(elapsed("12.52", "12.53") == "00.01")
  assert(elapsed("20.51", "23.08") == "02.17")
  assert(elapsed("14.22", "14.22") == "00.00")
  assert(elapsed("00.00", "23.59") == "23.59")
  assert(elapsed("17.30", "14.01") == "03.29")

  println("All tests passed succesfully!")
}