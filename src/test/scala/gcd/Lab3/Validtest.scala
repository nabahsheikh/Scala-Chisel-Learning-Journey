package Lab3

import chisel3._
import chiseltest._
import org.scalatest._

class Validtest extends FreeSpec with ChiselScalatestTester{
    "Valid"  in{
        test(new Valid()) {c=>
        c.io.in.poke("b00".U)
        c.io.out.valid.expect(1.B)
        c.io.out.bits.expect("b0001".U)
        c.clock.step(1)
        }
    }
}