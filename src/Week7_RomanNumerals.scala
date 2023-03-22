/*
  Dr. Frankenschmirtz fortsætter sit arbejde med tidsmaskinen, men er løbet ind i et nyt problem:
  Folk i gamle dage skrev årstal på mærkelige måder!
  Skriv en algoritme der kan lave romerske numeraler om til et normalt tal man kan forstå.
 */

object Week7_RomanNumerals extends App {
  def decodeYear(number: String): Int = {
    // Lasses løsning
    val(t,n)=(Map(73→1,86→5,88→10,76→50,67→100,68→500,77→1000),number)
    val(i,o)=n.tail.foldLeft((0,t(n(0))))((a,x)⇒(if(a._2>=t(x))a._1+a._2 else a._1-a._2,t(x)))
    i+o
  }

  assert(decodeYear("I") == 1)
  assert(decodeYear("V") == 5)
  assert(decodeYear("X") == 10)
  assert(decodeYear("L") == 50)
  assert(decodeYear("C") == 100)
  assert(decodeYear("D") == 500)
  assert(decodeYear("M") == 1000)

  assert(decodeYear("IV") == 4)
  assert(decodeYear("VIII") == 8)
  assert(decodeYear("XCIX") == 99)
  assert(decodeYear("CCI") == 201)
  assert(decodeYear("MDCXIX") == 1619)
  assert(decodeYear("MDCCLXXVI") == 1776)

  assert(decodeYear("MCMLV") == 1955)
  assert(decodeYear("MCMLXXXV") == 1985)
  assert(decodeYear("MMXV") == 2015)

  assert(decodeYear("MMXXIII") == 2023)
  assert(decodeYear("MMMDCCXXIV") == 3724)

  println("Alt er godt. Sejt. Tillykke med det!")
}
