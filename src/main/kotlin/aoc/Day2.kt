package aoc

/* PART I */

/**
 * Check if a string contains doubles (aa) or threes (aaa) and return true/false respectively
 */
fun hasDoubleOrThree(input : String): Pair<Boolean, Boolean> {
    val counts =  input.groupingBy { it }
                    .eachCount()

    val twos = counts.containsValue(2)
    val threes = counts.containsValue(3)

    return Pair(twos, threes)
}

/**
 * Count twos and threes occurrence and do checksum calculation
 */
fun countOccurrences(input: List<String>) : Int {
    val twosThrees = input.map { hasDoubleOrThree(it) }

    val twoCount = twosThrees.count { it.first }
    val threeCount = twosThrees.count { it.second }

    return twoCount * threeCount
}

/* PART II */

/**
 * Find the correct boxes. Returns a pair of box IDs if the hamming distance is 1
 */
fun findCorrectBoxes(input: List<String>): Pair<String, String> {
    return input.cartesianProduct(input)
                .find { (fst, snd) -> fst.distance(snd) == 1 } ?: throw NoSuchElementException("Did not find box")
}

/**
 * Calculate Hamming distance (https://en.wikipedia.org/wiki/Hamming_distance)
 */
fun String.distance (s2 : String) : Int = this.zip(s2).count { it.first != it.second }

/**
 * Return list of unique pairs
  */
fun <T, S> Collection<T>.cartesianProduct(other: Iterable<S>): List<Pair<T,S>> {
    return this.flatMap { first -> other.map { second -> first to second } }
}

