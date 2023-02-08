object Week1_Ceasar extends App {

  /*
    Cæsar cipher er en simpel krypteringsmetode der virker ved
    at forskyde bogstaver med et bestemt offset i alfabetet.
    Implementér en funktion der kan deciphrere en krypteret tekststreng.
    Cifre forskydes på samme måde. Alle andre tegn forskydes ikke.
    Ved overflow startes der forfra ved 'A' for bogstaver og ved '0' for cifre.
    Se vejledende tests for eksempler
  */

  // Implenetér denne funktion
  def decipher(cipherText: String, offset: Int): String = {
    // Daniels 97 char løsning
    cipherText.map(c=>(if(c.isLetterOrDigit)(c&96)+26-(offset+26-c%32)%(10+(c>>2&16))else +c).toChar)
  }


  // Vejledende tests
  assert(decipher("c", 2) == "a")
  assert(decipher("C", 2) == "A")
  assert(decipher("6", 2) == "4")
  assert(decipher(".", 17) == ".")

  assert(decipher("6", 10) == "6")
  assert(decipher("A", 26) == "A")
  assert(decipher("N", 10) == "D")

  assert(decipher("Pmf 9 Nmzsqdl!", 12) == "Dat 7 Bangerz!")
  assert(decipher("Wxkotkxgztgzxgtgwwxkaxwhex. wxk otk ytdmbld 78", 123) == "Dervarengangenandderhedole. der var faktisk 45")
  assert(decipher("UhmnahKhzkm<.hzhz()hzk", 7) == "NafgtaDasdf<.asas()asd")

  println("All tests passed succesfully!")
}
