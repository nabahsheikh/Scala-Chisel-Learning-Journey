package Lab3

import chisel3._
import  chiseltest._
import org.scalatest._

class SwitchAlutest extends FreeSpec with ChiselScalatestTester{
    "ALU"  in{
        test(new SwitchAlu()) {c=>
        c.io.in_A.poke("b00000000000000000000000000000001".U)
        c.io.in_B.poke("b00000000000000000000000000000001".U)
        c.io.alu_Op.poke(1.U)
        c.clock.step(1)
        c.io.out.expect(0.U)
        }
    }
}