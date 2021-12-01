package Lab5

import chisel3._
import chiseltest._
import org.scalatest._

class Task1test extends FreeSpec with ChiselScalatestTester{
    "Adder Task 5 "  in{
        test(new Task1(16)) {c=>
        c.io.in0.poke(5.U)
        c.io.in1.poke(5.U)
        c.clock.step(1)
        c.io.sum.expect(10.U)

        }
    }
}