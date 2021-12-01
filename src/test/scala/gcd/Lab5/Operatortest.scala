package Lab5

import chisel3._
import chiseltest._
import org.scalatest._

class Operatortest extends FreeSpec with ChiselScalatestTester{
    "operator"  in{
        test(new Operator(4,UInt(16.W))( _ + _ )) {c=>
        c.io.in(0).poke(2.U)
        c.io.in(1).poke(3.U)
        c.io.in(2).poke(4.U)
        c.io.in(3).poke(1.U)
        c.clock.step(1)
        c.io.out.expect(10.U)
        }
    }
}