package Lab5

import chisel3._
import  chiseltest._
import org.scalatest._

class BitAlutest extends FreeSpec with ChiselScalatestTester{
    "Bitwise para"  in{
        test(new BitAlu(32)) {c=>
        c.io.alu_oper.poke("b0100".U)
        c.io.arg_x.poke(5.U)
        c.io.arg_y.poke(2.U)
        c.io.alu_out.expect(10.U)

        }
    }
}