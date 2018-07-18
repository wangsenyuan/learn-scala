package codejam.year2008.round3

import codejam.FileOp

object B extends App with FileOp {

  def visibleWalls(r: Int, c: Int, grid: Array[Array[Char]]): Array[Array[Array[Int]]] = {
    //(i, j, 0) top, 1 right, 2, bottom, 3 left
    val walls = Array.fill(r, c, 4)(-1)
    var i = 0
    while (i < r) {
      var j = 0
      while (j < c) {
        if (grid(i)(j) == '#') {
          walls(i)(j)(0) = i
          walls(i)(j)(3) = j
        } else {
          if (i > 0) {
            walls(i)(j)(0) = walls(i - 1)(j)(0)
          }
          if (j > 0) {
            walls(i)(j)(3) = walls(i)(j - 1)(3)
          }
        }
        j += 1
      }
      i += 1
    }

    i = r - 1
    while (i >= 0) {
      var j = c - 1
      while (j >= 0) {
        if (grid(i)(j) == '#') {
          walls(i)(j)(1) = j
          walls(i)(j)(2) = i
        } else {
          if (i == r - 1) {
            walls(i)(j)(2) = r
          } else {
            walls(i)(j)(2) = walls(i + 1)(j)(2)
          }

          if (j == c - 1) {
            walls(i)(j)(1) = c
          } else {
            walls(i)(j)(1) = walls(i)(j + 1)(1)
          }

        }
        j -= 1
      }
      i -= 1
    }
    walls
  }

  case class State(dist: Int, portals: Set[(Int, Int)])

  def loop(grid: Array[Array[Char]], c: Char, row: Int): (Int, Int) = {
    val col = grid(row).indexOf(c)
    if (col >= 0) {
      (row, col)
    } else {
      loop(grid, c, row + 1)
    }
  }

  def findStarting(grid: Array[Array[Char]]): (Int, Int) = {
    loop(grid, 'O', 0)
  }

  def getPortals(sx: Int, sy: Int, walls: Array[Array[Array[Int]]]): Set[(Int, Int)] = {
    val top = walls(sx)(sy)(0) + 1
    val right = walls(sx)(sy)(1) - 1
    val bottom = walls(sx)(sy)(2) - 1
    val left = walls(sx)(sy)(3) + 1
    Set(top -> sy, sx -> right, bottom -> sy, sx -> left)
  }

  def findEnding(grid: Array[Array[Char]]) = {
    loop(grid, 'X', 0)
  }

  val dd = Array(-1, 0, 1, 0, -1)


  def solve(r: Int, c: Int, grid: Array[Array[Char]]): Int = {
    val walls = visibleWalls(r, c, grid)

    val states = Array.fill[State](r, c)(null)
    val que = Array.fill(2 * r * c)(-1)
    var front = 0
    var end = 0
    val (sx, sy) = findStarting(grid)
    val (ex, ey) = findEnding(grid)
    states(sx)(sy) = State(0, getPortals(sx, sy, walls))
    que(end) = sx * c + sy

    def visitNeighbors(x: Int, y: Int, cur: State): Unit = {
      var k = 0
      while (k < 4) {
        val i = x + dd(k)
        val j = y + dd(k + 1)

        if (i >= 0 && i < r && j >= 0 && j < c && grid(i)(j) != '#' && states(i)(j) == null) {
          states(i)(j) = State(cur.dist + 1, cur.portals ++ getPortals(i, j, walls))
          que(end) = i * c + j
          end += 1
        }

        k += 1
      }
    }

    def visitPortals(x: Int, y: Int, curState: State): Unit = {
      var besideWall = false
      var k = 0
      while (k < 4 && !besideWall) {
        val i = x + dd(k)
        val j = y + dd(k + 1)
        if (i < 0 || i == r || j < 0 || j == c || grid(i)(j) == '#') {
          besideWall = true
        }
        k += 1
      }
      if (besideWall) {
        curState.portals.foreach {
          case (i, j) =>
            if (states(i)(j) == null) {
              states(i)(j) = State(curState.dist + 1, getPortals(i, j, walls))
              que(end) = i * c + j
              end += 1
            }
        }
      }
    }

    end += 1
    var found = false
    while (front < end && !found) {
      val cur = que(front)
      front += 1
      val x = cur / c
      val y = cur % c
      val curState = states(x)(y)
      if (x == ex && y == ey) {
        found = true
      } else {
        visitNeighbors(x, y, curState)
        visitPortals(x, y, curState)
      }
    }

    if (found) {
      states(ex)(ey).dist
    } else {
      -1
    }
  }


  //  override val filePrefix = "src/main/scala/codejam/year2008/round3/B-console-practice"
  override val filePrefix = "src/main/scala/codejam/year2008/round3/B-large-practice"
  val T = file.next().toInt

  var tc = 1
  while (tc <= T) {
    val line = file.next().split("\\s+").map(_.toInt)
    val r = line(0)
    val c = line(1)
    val grid = Array.fill(r)(Array.empty[Char])
    var i = 0
    while (i < r) {
      grid(i) = file.next().toCharArray
      i += 1
    }
    val res = solve(r, c, grid)
    if (res < 0) {
      printf(f"Case #$tc: THE CAKE IS A LIE\n")
    } else {
      printf(f"Case #$tc: $res\n")
    }
    tc += 1
  }
}
