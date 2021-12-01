package Lab2

import chisel3._
import  chiseltest._
import org.scalatest._

class Task1test extends FreeSpec with ChiselScalatestTester{
    "Task 1"  in{
        test(new Task1()) {x=>
        x.io.in0.poke(0.U)
        x.io.in1.poke(8.U)
        x.io.in2.poke(16.U)
        x.io.in3.poke(24.U)
        x.io.in4.poke(32.U)
        x.io.s0.poke(1.B)
        x.io.s1.poke(0.B)
        x.io.s2.poke(0.B)
        x.clock.step(1)
        x.io.out.expect(8.U)
        }
    }
}
        