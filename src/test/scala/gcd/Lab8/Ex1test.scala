package Lab8

import org.scalatest._
import chiseltest._
import chisel3._

class Ex1Test extends FreeSpec with ChiselScalatestTester{
    "Exercise1 Lab8"in {
        test(new Ex1 ){c =>
        c.io.en.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(10.U)
        c.io.mask.poke(0.U)
        c.io.datain.poke(200.U)    
        c.clock.step(1)
    }
   
}
}