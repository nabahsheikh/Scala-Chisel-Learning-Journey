package Lab3

import chisel3._
import  chiseltest._
import org.scalatest._

class BranchControltest extends FreeSpec with ChiselScalatestTester{
    "Branch Control"  in{
        test(new BranchControl()) {c=>
        c.io.func3.poke("b110".U)
        c.io.in_A.poke(5.U)
        c.io.in_B.poke(16.U)
        c.io.branch.poke(true.B)
        c.clock.step(1)
        c.io.br_taken.expect(1.B)
        }
    }
}