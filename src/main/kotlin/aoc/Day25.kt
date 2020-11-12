package aoc

import kotlin.math.absoluteValue

// find the number of constellations of points in the list.
//   Two points are in the same constellation if
//    - their manhattan distance apart is no more than 3
//    - if they can form a chain of points

data class Node(val p1 : Point, val p2 : Point)

class Point(private val a : Int, private val b: Int,
            private val c: Int, private val d: Int) {

    /**
     * Calculate manhattan distance distance to other point
     * |a - a| + |b - b| + |c - c| + |d - d|
     * @return distance
     */
    fun distance(dest : Point) : Int {
        return (this.a - dest.a).absoluteValue +
                (this.b - dest.b).absoluteValue +
                (this.c - dest.c).absoluteValue +
                (this.d - dest.d).absoluteValue
    }

    override fun toString(): String {
        return "($a, $b, $c, $d)"
    }
}

class Matrix(rows: String) {
    val rows : List<Point> = toRows(rows)

    fun countConstellation() : Int {

        // ...

        return 0
    }

    private fun toRows(list: String) : List<Point>{
        return list.lines()
                .asSequence()
                .map { it.split(",") }
                .flatten()
                .map { it.trim() }
                .map { it.toInt() }
                .chunked(4)
                .map { (a,b,c,d) -> Point(a, b, c, d) }
                .toList()
    }

    override fun toString(): String {
        return rows.joinToString("\n")
    }
}

fun main(){
    val p1 = Point(0,0,0,0)
    val p2 = Point(3,0,0,0)

    val matrix = Matrix(""" 0,0,0,0
 3,0,0,0
 0,3,0,0
 0,0,3,0
 0,0,0,3
 0,0,0,6
 9,0,0,0
12,0,0,0""")

    matrix.countConstellation()
}

