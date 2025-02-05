
fun main() {
    // Fonction mySqrt
    fun mySqrt(x: Double): Double? {
        return if (x >= 0) Math.sqrt(x) else null
    }

    // Fonction realRoots
    fun realRoots(a: Double, b: Double, c: Double): List<Double> {
        val discriminant = b * b - 4 * a * c

        return when {
            discriminant < 0 -> emptyList()
            discriminant == 0.0 -> listOf(-b / (2 * a))
            else -> {
                val sqrtDiscriminant = mySqrt(discriminant) ?: return emptyList()
                listOf(
                    (-b + sqrtDiscriminant) / (2 * a),
                    (-b - sqrtDiscriminant) / (2 * a)
                )
            }
        }
    }

    // Tests
    println("Exercice 2 :")
    println("Polynôme x^2 - 2x + 1 : ${realRoots(1.0, -2.0, 1.0)}") // 1 racine double : [1.0]
    println("Polynôme x^2 - 2x + 2 : ${realRoots(1.0, -2.0, 2.0)}") // 0 racines réelles : []
    println("Polynôme x^2 - 3x + 2 : ${realRoots(1.0, -3.0, 2.0)}") // 2 racines réelles : [2.0, 1.0]
}

