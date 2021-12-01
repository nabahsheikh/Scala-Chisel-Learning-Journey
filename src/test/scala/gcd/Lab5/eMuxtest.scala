package Lab5

import chisel3._
import  chiseltest._
import org.scalatest._

class eMuxtest extends FreeSpec with ChiselScalatestTester{
    "Emux Lab 5"  in{
        test(new eMux(UInt(2.W))) {c=>
        c.io.in1.poke(3.U)
        c.io.in2.poke(2.U)
        c.io.sel.poke(true.B)
        c.io.out.expect(3.U)

        }
    }
}