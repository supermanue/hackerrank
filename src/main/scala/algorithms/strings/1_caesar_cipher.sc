val N=11
val s = "middle-Outz"
val k = 2

def encodeIfLetter(c:Char, k:Int):Char = {
  val numLetras= 'z'.toInt - 'a'.toInt +1
  val startLower = 'a'.toInt
  val startUpper = 'A'.toInt

  if (c.isLower)
    ((c + k - startLower ) % numLetras +startLower).toChar
  else if (c.isUpper)
    ((c + k - startUpper ) % numLetras +startUpper).toChar
  else c
}

s.map(c=>encodeIfLetter(c,k))




