import scala.collection.mutable.HashMap
import scala.io.Source

//////////////////
///////////////////
// CODE

def insertInHashMap(train:(Long, Long, Long),
                    hash:HashMap[Long, List[(Long,Long)]]):Unit =
  if (!hash.contains(train._1))
    hash(train._1) = List((train._2, train._3))
  else
    hash(train._1) = hash(train._1) ++ List((train._2, train._3))


def removeOverlaps(list: List[(Long,Long)],
                   element: (Long, Long),
                  nonOverlappingList: List[(Long,Long)]):List[(Long,Long)] =
  if (list.isEmpty)
    nonOverlappingList :+ element
else {
    if (element._2 >= list.head._1)
      removeOverlaps(list.tail, (element._1, math.max(element._2, list.head._2)), nonOverlappingList)
    else
      removeOverlaps(list.tail, list.head, nonOverlappingList:+element)
  }

def trainsToHash(trains: Array[(Long, Long, Long)] ):
HashMap[Long, List[(Long,Long)]] = {
  var occupiedCells= new HashMap[Long, List[(Long,Long)]]()

  trains.map(t => insertInHashMap(t,occupiedCells))

  occupiedCells.keysIterator.foreach(k => {
    val orderedList = occupiedCells(k).sorted
    occupiedCells(k) = removeOverlaps(orderedList.tail, orderedList.head,  List[(Long,Long)]())
  })

  occupiedCells
}

def totalTrackSurface(occupiedrows: HashMap[Long, List[(Long,Long)]]): Long =
  occupiedrows.map(r =>  //for each row
    r._2.map(t => //for each track
    t._2 - t._1 + 1).sum //calculate the covered surface
    ).sum //and add everything


def numberOfLampposts(rows:Long, cols:Long,trains:Array[(Long,Long,Long)] ) =
  rows * cols - totalTrackSurface(trainsToHash(trains))



///////////////////
//////////////////
// TESTS

val rows=4
val cols = 4
val numberOfTrains = 3

val trains= Array[(Long, Long, Long)]((2,2,3),(3,1,4),(4,4,4))

val trains2= Array[(Long, Long, Long)]((1,1,2),
  (1,4,4),
  (2,1,2),
  (2,2,3),
  (2,4,5),
  (4,1,2), (4,4,5))

trainsToHash(trains)
trainsToHash(trains).mkString("\n")
totalTrackSurface(trainsToHash(trains))
print (numberOfLampposts(rows, cols, trains))


//first line is rows, cols, numTrains

val filename =
  "/home/supermanue/Dropbox/hackerrank/src/main/scala/algorithms/search/testCases/2_input.txt"

var trains3= Array[(Long, Long, Long)]()
for (line <- Source.fromFile(filename).getLines) {
  if (!line.startsWith("#"))
    trains3 :+= (line.split(" ")(0).toLong, line.split(" ")(1).toLong, line.split(" ")(2).toLong)
}

trains3.mkString("\n")
print (numberOfLampposts(trains3.head._1, trains3.head._2, trains3.tail))



//first line is rows, cols, numTrains
val filename4: String =
  "/home/supermanue/Dropbox/hackerrank/src/main/scala/algorithms/search/testCases/2_input_overlapping.txt"

var trains4= Array[(Long, Long, Long)]()
for (line <- Source.fromFile(filename4).getLines) {
  if (!line.startsWith("#"))
    trains4 :+= (line.split(" ")(0).toLong, line.split(" ")(1).toLong, line.split(" ")(2).toLong)
}

trains4.mkString("\n")
print (numberOfLampposts(trains4.head._1, trains4.head._2, trains4.tail))



