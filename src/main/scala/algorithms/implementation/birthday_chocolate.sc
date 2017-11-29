//val m =2
//val d=3
//val n=5
//val sc = Array[Int](1,2,1,3,2)

val m =1
val d=4
val n=1
val sc = Array[Int](4)


def sumValues(s: Array[Int], start:Int, size:Int):Int = s.slice(start, start+size).sum

def eval(a:Int, b:Int):Int = if (a==b) 1 else 0

def scan(s: Array[Int], size:Int, desiredValue:Int) = {
  var start = 0
  val acum = for (start <-0 to s.size - size)
    yield eval(sumValues(s,start,size), desiredValue)

  acum.sum
}

scan(sc, m,d)
