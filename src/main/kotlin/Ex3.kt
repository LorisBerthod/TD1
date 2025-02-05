
fun main() {

    // Fonction apply
    fun apply(n: Int, m: Int = 0, f: (Int) -> Int): Int {
        var result = n
        repeat(m) {
            result = f(result)
        }
        return result
    }

    // Test pour n=2 et m=3
    val f1: (Int) -> Int = { x -> x * x }
    println("\nExercice 3 :")
    println("apply(2, 3, f) avec f(x) = x^2 : ${apply(2, 3, f1)}") // Résultat attendu : 256

    // Test pour n=12 et m=8
    val f2: (Int) -> Int = { x ->
        println("x % 2 = ${x % 2}")
        x / 2
    }
    println("apply(12, 8, f) avec division par 2 : ${apply(12, 8, f2)}")

    // Fonction pour la suite de Syracuse
    fun syracuse(n: Int, m: Int): List<Int> {
        val sequence = mutableListOf(n)
        var current = n
        repeat(m - 1) {
            current = if (current % 2 == 0) current / 2 else 3 * current + 1
            sequence.add(current)
        }
        return sequence
    }

    // Test de la suite de Syracuse
    println("\nSuite de Syracuse (n = 15, m = 10) : ${syracuse(15, 10)}")

    // Approximation
    fun approximateSqrt2(m: Int): Double {
        var u = 1.0
        repeat(m) {
            u = 0.5 * (u + 2 / u)
        }
        return u
    }

    // Test pour l'approximation
    println("\nApproximation de √2 avec 10 itérations : ${approximateSqrt2(10)}")
}

