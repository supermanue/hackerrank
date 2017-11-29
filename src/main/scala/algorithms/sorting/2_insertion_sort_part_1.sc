val n_1=5
val s_3 = Array[Int](2,4,6,8,1)

val s_1 = Array[Int](2,4,6,8,9)

val s_2 = Array[Int](2,4,6,8,1)

val n=10
val s=Array[Int](2, 3, 4, 5, 6, 7, 8, 9, 10, 1)

def insertRec(s:Array[Int], pos:Int, valueToInsert:Int):Array[Int] ={
  if ((pos<0) || (s(pos) < valueToInsert))
    s(pos+1) = valueToInsert
  else {
    s(pos+1) = s(pos)
    println(s.mkString(" "))
    insertRec(s, pos-1, valueToInsert)
  }
  s
}


def insertion_sort(s:Array[Int]) = {
  val valueToInsert=s.last
  s(s.size-1) = s(s.size-2)
  insertRec(s,s.size-2,valueToInsert)
  println(s.mkString(" "))

}


insertion_sort(s)