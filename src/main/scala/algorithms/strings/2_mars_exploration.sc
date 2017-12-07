val input="SOSSPSSQSSOR"
val input2="SOSSOT"

def changedChars(input:String, position:Int):Int = {
  if (input.length ==0) 0
  else

  position match {
    case 0 =>
      if (input.head =='S')
        changedChars(input.tail, 1)
      else
        1 + changedChars(input.tail, 1)
    case 1=>
      if (input.head =='O')
        changedChars(input.tail, 2)
      else
        1 + changedChars(input.tail, 2)
    case _ =>
      if (input.head =='S')
        changedChars(input.tail, 0)
      else
        1 + changedChars(input.tail, 0)

  }
}



changedChars(input,0)
changedChars(input2,0)
