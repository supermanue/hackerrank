/////////////CODE

def equal (arr: Array[Int]): Int = {
  List(equalPos(arr,0), equalPos(arr,1), equalPos(arr,2)).min
}

def equalPos (arr: Array[Int], pos: Int): Int = {
  var myList = arr.toList
  val minElem = myList.min
  myList = myList.map(a => a - minElem+pos)
  var steps = myList.map(elem => elem / 5).sum
  myList = myList.map(elem => elem % 5)
  steps += myList.map(elem => elem / 2).sum
  myList = myList.map(elem => elem % 2)
  steps += myList.sum
  steps
}

////////////////
////////////

// TESTS
val initial_state2=Array[Int](2,2,3,7)
equal(initial_state2)

val initial_state3=Array[Int](53,361,188,665,786,898,447,562,272,123,229,629,670,
  848, 994,54,822,46,208,17,449,302,466,832,931,778,156,39,31,777,749,436,138,289,
  453,276,539,901,839,811,24,420,440,46,269,786,101,443,832,661,460,281,964,278,
  465,247,408,622,638,440,751,739,876,889,380,330,517,919,583,356,83,959,129,875,
  5,750,662,106,193,494,120,653,128,84,283,593,683,44,567,321,484,318,412,712,559,
  792,394,77,711,977,785,146,936,914,22,942,664,36,400,857)

equal(initial_state3)


val initial_state=Array[Int](0,5)
equal(initial_state)

val initial_state_4=Array[Int](2,5,5,5,5,5)
equal(initial_state_4)
