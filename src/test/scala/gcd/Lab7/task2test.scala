package Lab7

import org.scalatest._
import chiseltest._
import chisel3._

class Task2test extends FreeSpec with ChiselScalatestTester{
    "Task 2 lab7"in {
        test(new Task2){c =>
        c.io.in.poke(0.B)
        c.io.out.expect(0.B)
        c.clock.step(1)
    }
   
}
}