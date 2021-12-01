package Lab6

import chisel3._
import  chiseltest._
import org.scalatest._

class Ex4test extends FreeSpec with ChiselScalatestTester{
    "Exercise 4 lab6"  in{
        test(new Ex4) {c=>
        c.io.in.valid.poke(1.B)
        c.io.in.bits.poke(8.U)
        c.io.out.ready.poke(1.B)
        c.clock.step(1)

        }
    }
}
