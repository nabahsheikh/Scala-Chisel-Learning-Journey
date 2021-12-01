package Lab5

import chisel3._
import  chiseltest._
import org.scalatest._

class Ex1test extends FreeSpec with ChiselScalatestTester{
    "ALU when, elsewhen"  in{
        test(new Ex1(32)) {c=>
        c.io.alu_oper.poke("b0100".U)
        c.io.arg_x.poke(5.U)
        c.io.arg_y.poke(2.U)
        c.io.alu_out.expect(20.U)

        }
    }
}