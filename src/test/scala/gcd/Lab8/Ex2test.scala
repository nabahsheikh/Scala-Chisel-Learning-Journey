package Lab8

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Ex2Test extends FreeSpec with ChiselScalatestTester{
    "Ex2 Lab8" in {
        test (new Ex2){n=>
        n.io.rdAddr.poke(2.U)
        n.io.wrAddr.poke(2.U)
        n.io.wrdata(0).poke(24.U)
        n.io.mask(0).poke(1.B)
        n.clock.step(1)

        n.io.write_en.poke(1.B)

        n.io.rdAddr.poke(2.U)
        n.io.wrAddr.poke(2.U)
        n.io.wrdata(1).poke(16.U)
        n.io.mask(1).poke(1.B)
        n.clock.step(2)
    
        }
    }
}
