val range=1

val houses=  Array[Int](1, 2, 3, 4, 5)

val range2 = 2
val houses2=Array[Int](7, 2, 4, 6, 5, 9, 12, 11).sorted

//FUNCIONA PERO NO ES MUY ELEGANTE
//lo suyo sería un drop-while, y sacar el contador de ahí

def placeTransmitters(houses:Array[Int], position:Int, range:Int):Array[Int] = {

  if (position >= houses.length) Array[Int]()
  else {
    val firstUncoveredHouse = houses(position)
    print ("first uncovered:" + firstUncoveredHouse.toString + "\n")
    var cont = position
    println("la antena de esta llega hasta " + (houses(cont) - range).toString)


    while ((cont < houses.length) && (houses(cont) - range <= firstUncoveredHouse)) {
      println ("evaluating house " + houses(cont))
      cont+=1
    }
    println ("cont is " + cont.toString)
    //aqui ya no cubre, poner transmisor en el anterior
    cont -=1
    val transmitter = houses(cont)
    println ("----->pongo transmisor en la casa" + transmitter.toString)
    //y descartar las siguientes

    while ((cont < houses.length) && (houses(cont) <= transmitter + range)) {
      println ("la casa " + houses(cont) + " esta cubierta")
      cont += 1

    }

    Array[Int](cont) ++ placeTransmitters(houses, cont, range)

  }

  }


placeTransmitters(houses, 0, range)
placeTransmitters(houses2, 0, range2)
