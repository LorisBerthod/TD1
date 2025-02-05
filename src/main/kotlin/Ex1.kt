import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    //Liste de 1000 nombres aléatoires entre 20 et 40
    val rndList = List(1000) { Random.nextInt(20, 41) }

    //Moyenne
    val avg = rndList.sumOf { it } / rndList.size.toDouble()
    println("Moyenne : $avg\n")

    //Variance et écart-type
    val variance = rndList.sumOf { (it - avg).pow(2) } / rndList.size
    val ecartType = sqrt(variance)
    println("Variance : $variance")
    println("Ecart-type : $ecartType\n")

    //Comparaison moyenne et écart-type
    val moyenneT = (20 + 40) / 2.0
    val varianceT = ((40 - 20).toDouble().pow(2)) / 12
    val ecartTypeTheorique = sqrt(varianceT)
    println("Moyenne théorique : $moyenneT")
    println("Variance théorique : $varianceT")
    println("Écart-type théorique : $ecartTypeTheorique\n")

    //Histogramme des apparitions
    val histogramme = mutableMapOf<Int, Int>()
    rndList.forEach { histogramme[it] = histogramme.getOrDefault(it, 0) + 1 }
    println("Histogramme : $histogramme\n")

    //Calcul des moments centrés
    val moment3 = rndList.sumOf { (it - avg).pow(3) } / rndList.size
    val moment4 = rndList.sumOf { (it - avg).pow(4) } / rndList.size
    val coefficientAsymetrie = moment3 / ecartType.pow(3)
    val coefficientAplatissement = moment4 / ecartType.pow(4)
    println("Coefficient d'asymétrie : $coefficientAsymetrie")
    println("Coefficient d'aplatissement : $coefficientAplatissement\n")

    //Centrage et réduction
    val zList = rndList.map { (it - avg) / ecartType }
    val avgZ = zList.average()
    val ecartTypeZ = sqrt(zList.sumOf { it.pow(2) } / zList.size)
    println("Moyenne de la liste centrée-réduite : $avgZ")
    println("Écart-type de la liste centrée-réduite : $ecartTypeZ \n")

    //Comparaison des performances
    val timeSumOf = measureTimeMillis {
        val avgTest = rndList.sumOf { it } / rndList.size.toDouble()
    }
    val timeForLoop = measureTimeMillis {
        var sum = 0.0
        for (num in rndList) {
            sum += num
        }
        val avgTest = sum / rndList.size
    }

    println("Temps d'exécution avec sumOf : ${timeSumOf}ms")
    println("Temps d'exécution avec boucle for : ${timeForLoop}ms")
    println("Le temps de réponse est de 0ms")

}
