package Lab3

import chisel3._
import  chiseltest._
import org.scalatest._

class Encodertest extends FreeSpec with ChiselScalatestTester{
    "Encoder"  in{
        test(new Encoder()) {c=>
        c.io.in.poke("b0010".U)
        c.clock.step(1)
        c.io.out.expect("b01".U)        
        }
    }
}
