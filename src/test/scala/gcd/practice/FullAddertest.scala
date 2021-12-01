package practice

import chisel3._
import chiseltest._
import org.scalatest._

class FullAddertest extends FreeSpec with ChiselScalatestTester{
    "Full Adder test" in {
        test(new FullAdder()){s =>
        s.io.a.poke (1.U)
        s.io.b.poke (1.U)
        s.clock.step(1)
        s.io.sum.expect(2.U)

        }
    }
} 