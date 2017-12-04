/*
LIMITED SCALABILITY: LINEAR WITH ROWS, COLS
 */


/*


    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
        val sc = new java.util.Scanner (System.in)
        var rows = sc.nextInt()
        var cols = sc.nextInt()
        var numberOfTrains =sc.nextInt()
        var trains = new Array[(Int, Int, Int)](numberOfTrains)

        for(s_i <- 0 to numberOfTrains-1) {
            trains(s_i) = (sc.nextInt(),sc.nextInt(),sc.nextInt())
        }

        print (numberOfLampposts(rows, cols, trains))

 */
val rows=4
val cols = 4
val numberOfTrains = 3

val trains=Array((2,2,3),(3,1,4),(4,4,4))

def isInTrack(row:Int, col:Int, train: (Int, Int, Int)): Boolean = {
  //  print (row.toString + ", " + col.toString + ": train " + train.toString)
  var sol = false
  if (row != train._1) sol = false
  else if ((train._2<=col) && (col<=train._3)) sol = true
  else false
//  println (" is in track? " + sol.toString)
  sol
}

def isInAnyTrack(row:Int, col:Int, trains:Array[(Int,Int,Int)]):Boolean=
  trains.dropWhile(t => !isInTrack(row,col, t)).length > 0

def numberOfLampposts(rows:Int, cols:Int,trains:Array[(Int,Int,Int)] ) = {
  var acum=0
  for {
    i <- 1 to rows
    j <- 1 to cols
  } if (!isInAnyTrack(i,j,trains)) (acum +=1)

  acum
}

print (numberOfLampposts(rows, cols, trains))
