package Lab5

import chisel3._
import  chiseltest._
import org.scalatest._

class Ex2test extends FreeSpec with ChiselScalatestTester{
    "Emux Lab 5"  in{
        test(new Ex2(SInt(8.W))) {c=>
        c.io.in1.poke(3.S)
        c.io.in2.poke(2.S)
        c.io.sel.poke(true.B)
        c.io.out.expect(3.S)

        }
    }
}