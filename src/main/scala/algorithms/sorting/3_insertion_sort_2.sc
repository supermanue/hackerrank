val s=Array[Int](2, 3, 4, 5, 6, 7, 8, 9, 10, 1)
val s_1 = Array[Int](2,4,6,8,9)
val s_2 = Array[Int](2,4,6,8,1)
val s_3 = Array[Int](2,4,6,8,1)
val s_4 = Array[Int](5,4,3,2,1)
val s_orig=Array[Int](1, 4, 3, 5, 6, 2)

def insertRec(s:Array[Int], pos:Int, valueToInsert:Int):Array[Int] ={
  if ((pos<0) || (s(pos) < valueToInsert))
    s(pos+1) = valueToInsert
  else {
    s(pos+1) = s(pos)
    insertRec(s, pos-1, valueToInsert)
  }
  s
}



def insertion_sort(s:Array[Int]) = {
  val i = 0
  for (i <- 1 to s.length-1){
    val valueToInsert=s(i)
    s(i) = s(i-1)
    insertRec(s,i-1,valueToInsert)
    println(s.mkString(" "))
  }

}

insertion_sort(s_orig)

insertion_sort(s_4)


insertion_sort(s)
insertion_sort(s_1)
insertion_sort(s_2)
insertion_sort(s_3)

