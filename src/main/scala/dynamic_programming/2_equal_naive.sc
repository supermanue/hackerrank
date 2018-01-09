/////////////CODE

//apply first, second and third  OPs to all the list except elem
def first_op (elem:Int, l:List[Int]) =
(l.take(elem).map(_+1) :+ l(elem)) ++ l.drop(elem+1).map(_+1)

def second_op (elem:Int, l:List[Int]) =
  (l.take(elem).map(_+2) :+ l(elem)) ++ l.drop(elem+1).map(_+2)

def third_op (elem:Int, l:List[Int]) =
  (l.take(elem).map(_+5) :+ l(elem)) ++ l.drop(elem+1).map(_+5)

//success condition
def allEquals(l:List[Int]):Boolean = l match {
  case Nil => true
  case x ::Nil => true
  case x ::tail => (x == tail.head) && allEquals(tail)
}

var cache = collection.mutable.Map[String, Int]()

def storeOrUpdate(s:String, myVal:Int): Unit =
  if (!cache.contains(s)) {
//    println("adding (" + s + "): " + myVal.toString)
    cache += (s -> myVal)
  }
  else
    cache(s) = math.min (cache(s), myVal)


def step(l:List[Int], iterations:Int ): Boolean = {
  var sol = false
  for (elem <- 0 to l.length-1) {
    var myVal = first_op(elem, l)
    var info = myVal.mkString(",")
    if (allEquals(myVal)){
//      println("YA")
      sol=true}
    else
      storeOrUpdate(info, iterations)

    myVal = second_op(elem, l)
    info = myVal.mkString(",")
    if (allEquals(myVal)){
//      print("YA 2")
      sol=true}
    else
      storeOrUpdate(info, iterations)

    myVal = third_op(elem, l)
    info = myVal.mkString(",")
    if (allEquals(myVal)){
//      print("YA 3")
      sol=true}
    else
      storeOrUpdate(info, iterations)
  }
//  println(cache)
  sol
}


def evolve(): Int = {
  var iter=1
  while (true){
    for (k <-cache.keys){
//      println ("evolving: " + k)
      if (step(k.split(",").map(_.toInt).toList,iter)) return iter

    }
    iter +=1
//    println ("new iteration")
  }
  0
}


////////////////
////////////

// TESTS
val initial_state=List[Int](2,2,3,7)

third_op(0,initial_state)
third_op(1,initial_state)
third_op(2,initial_state)
third_op(3,initial_state)

//evolve split
val k="1,2,3"
k.split(",").map(_.toInt).toList

val l = List (1,1,1,1)
allEquals(l)

val l2 = List (1,1,1,2)

val init=initial_state.mkString(",")
cache += (init ->1)
evolve()



/////////
/////////////////
// INITIALIZE

/*

    def main(args: Array[String]) {
        //Enter your code here. Read input from STDIN. Print output to STDOUT
        val sc = new java.util.Scanner (System.in)
        var testcases = sc.nextInt();
        for (i <- 1 to testcases){
            var size = sc.nextInt();
            var c = new Array[Long](size);
            for(c_i <- 0 to size-1) {
               c(c_i) = sc.nextInt();
            }
            val init=c.mkString(",")
            cache += (init ->0)
            println(evolve())
            }
    }

}

 */