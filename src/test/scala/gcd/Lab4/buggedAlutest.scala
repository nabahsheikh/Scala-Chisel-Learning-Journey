package Lab4

import chisel3._
import  chiseltest._
import org.scalatest._

class buggedAlutest extends FreeSpec with ChiselScalatestTester{
    "ALU"  in{
        test(new buggedAlu()) {c=>
        c.io.in_A.poke(2.U)
        c.io.in_B.poke(9.U)
        c.io.alu_Op.poke(5.U)
        c.clock.step(1)
        c.io.out.expect(1.U)
        }
    }
}