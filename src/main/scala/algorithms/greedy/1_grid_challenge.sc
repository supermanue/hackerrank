
/*

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
        val sc = new java.util.Scanner (System.in)
        var testCases = sc.nextLine.toInt

        for(i <- 0 to testCases-1) {
            var testCaseSize = sc.nextLine.toInt
            var input = new Array[String](testCaseSize)
            for (j <- 0 to testCaseSize -1)
                input(j) = sc.nextLine
            if (compareColumns(input))
                println("YES")
            else
                println("NO")
        }
    }
 */


val testCase1=Array[String]("ebacd","fghij","olmkn","trpqs","xywuv")
val testCase2 = Array[String]("kc", "iu")
val testCase3 = Array[String]("uxf", "vof","hmp")

def sort(inputArray: Array[String]): Array[String] =
  inputArray.map(str => str.toList.sorted.mkString(""))


def isColumnSorted(inputArray: Array[String], pos: Int, comparing:Int):Boolean =
  if (comparing == inputArray.length-1) true
  else{
    if (inputArray(comparing)(pos) <=inputArray(comparing+1)(pos))
      isColumnSorted(inputArray,pos,comparing+1)
    else false
  }





def compareColumns(inputArray: Array[String]):Boolean =
  (for (i <- 0 to inputArray.length-1) yield isColumnSorted(sort(inputArray),i,0)).foldLeft[Boolean](true)(_ && _)



testCase1.map(x => x(1))
testCase1.map(x => x(1)).sorted


sort(testCase2).mkString("\n")

isColumnSorted(testCase1,1,0)
isColumnSorted(testCase1,2,0)

testCase2.map(x => x(0))
testCase2.map(x => x(0)).sorted

testCase2.map(x => x(1))
testCase2.map(x => x(1)).sorted


isColumnSorted(testCase2,0,0)
isColumnSorted(testCase2,1,0)

compareColumns(testCase1)
compareColumns(testCase2)
compareColumns(testCase3)

testCase3.sliding(2).foreach(f => if (f(0) <=f(1)) print ("true") else print ("false"))

val pos=0
(for (i <- 0 until testCase3.length-1) yield testCase3(i)(pos)<=testCase3(i)(pos+1)).foldLeft[Boolean](true)(_ && _)
