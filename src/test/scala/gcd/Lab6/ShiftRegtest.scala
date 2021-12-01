package Lab6

import chisel3._
import  chiseltest._
import org.scalatest._

class ShiftRegtest extends FreeSpec with ChiselScalatestTester{
    "Shift Register"  in{
        test(new ShiftReg) {c=>
        c.io.in.poke(1.B)
        c.clock.step(4)
       // c.io.in.poke(1.B)
       // c.clock.step(1)

       // c.io.in.poke(1.B)
       // c.clock.step(1)
      //  c.io.in.poke(1.B)
       // c.io.out.expect(3.U)
        //c.io.out.expect(7.U)
        c.io.out.expect(15.U)
       // c.io.out(3).expect(30.U)
        }
    }
}
