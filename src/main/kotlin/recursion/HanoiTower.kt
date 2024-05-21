package recursion

/**
 * The Tower of Hanoi is a classic problem in computer science and mathematics that involves moving a stack of disks from one rod to another, subject to certain constraints. The problem is usually stated as follows:
 *
 * There are three rods (poles or pegs) labeled A, B, and C.
 * A number of disks of different sizes are stacked in decreasing order of size on rod A.
 * The task is to move the entire stack to rod C, obeying the following rules:
 * a. Only one disk can be moved at a time.
 * b. A disk can only be moved to the top of another rod if it is smaller than the disk already on that rod or if the rod is empty.
 * The goal is to find the minimum number of moves to transfer the entire stack of disks from rod A to rod C.
 *
 * The Tower of Hanoi algorithm can be solved recursively with the following steps:
 *
 * Base Case: If there is only one disk, move it from the source rod to the destination rod.
 *
 * Recursive Step: For n disks, follow these steps:
 * a. Move the top n-1 disks from the source rod to an auxiliary rod (using the destination rod as an auxiliary).
 * b. Move the nth disk from the source rod to the destination rod.
 * c. Move the n-1 disks from the auxiliary rod to the destination rod (using the source rod as an auxiliary).
 *
 * The recursive nature of the Tower of Hanoi algorithm is what makes it elegant. Each recursive call reduces the problem to a smaller subproblem until the base case is reached.
 */
class HanoiTower {

    // TODO: use stacks
    fun hanoi(numberOfDisks: Int,
              source: Peg,
              destination: Peg,
              auxiliary: Peg
    ) {
        if (numberOfDisks == 1) {
            move(source, destination)
        } else {
            hanoi(numberOfDisks - 1, source, auxiliary, destination)
            move(source, destination)
            hanoi(numberOfDisks - 1, auxiliary, destination, source)
        }
    }

    private fun move(source: Peg, destination: Peg) {
        destination.store.add(source.store.removeLast())
    }
}

data class Peg(
    val name: String,
    val store: MutableList<Int>
)