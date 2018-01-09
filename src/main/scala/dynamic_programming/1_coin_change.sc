//////////////////
//////////////////
// CODE

def possibilities(cuantity:Int, coins: Array[Int]):Int =
if ((cuantity < 0 ) || (coins.isEmpty)) 0
else if (cuantity ==0 ) 1
else
  possibilities(cuantity - coins.head, coins) +
    possibilities(cuantity, coins.tail)


val cache = collection.mutable.Map[String, Long]()

def possibilitiesWithCache(cuantity:Long, coins: Array[Long]):Long = {
  val info = cuantity.toString + "-" + coins.mkString(",")
  if (!cache.contains(info)) {
    if ((cuantity < 0 ) || (coins.isEmpty)) cache(info) = 0
    else if (cuantity ==0) cache(info) = 1
    else cache(info) =
      possibilitiesWithCache(cuantity - coins.head, coins) +
        possibilitiesWithCache(cuantity, coins.tail)
  }
  cache(info)
}
//////////////////
////////////////
// /TESTS


val cuantity = 4
val coins = Array[Long](1,2,3)
possibilitiesWithCache(cuantity.toLong, coins)


val cuantity2 = 10
val coins2 = Array[Long](2,5,3,6)
possibilitiesWithCache(cuantity2, coins2)

val cuantity3 = 3
val coins3 = Array[Long](8,3,1,2)
possibilitiesWithCache(cuantity3, coins3)


/*
    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var m = sc.nextInt();
        var c = new Array[Long](m);
        for(c_i <- 0 to m-1) {
           c(c_i) = sc.nextInt();
        }
        print (possibilitiesWithCache(n.toLong,c))
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
    }
 */