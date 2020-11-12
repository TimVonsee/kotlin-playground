package aoc

/* PART I */

/**
 * Calculate sum of al frequency changes
 */
fun calculateFrequency(freqDrifts : String) = toIntegers(freqDrifts).sum()

/**
 * Convert delimited list of numbers into integers
 */
fun toIntegers(string : String, delimiter : String =", ") : List<Int> = string
                                                                            .split(delimiter)
                                                                            .map { it.toInt() }

/* PART II */

/**
 * Find double frequency
 */
fun doubleFrequency(freqDrifts: String) : Int{
    val doubleFreqs = mutableSetOf(0)
    var currentFreq = 0

    return  toIntegers(freqDrifts)
                                .asSequence()
                                .infinite()
                                .map {
                                    currentFreq += it
                                    currentFreq // why can't I use return?
                                }
                                .first { !doubleFreqs.add(it) }
}

/**
 * Convert to infinite sequence
 */
fun <T> Sequence<T>.infinite() = sequence { while (true) yieldAll(this@infinite) }