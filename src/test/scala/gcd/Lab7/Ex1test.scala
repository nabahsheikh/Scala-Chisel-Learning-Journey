package Lab7

import org.scalatest._
import chiseltest._
import chisel3._

class Ex1test extends FreeSpec with ChiselScalatestTester{
    "Exercise 1 Lab7"in {
        test(new Ex1()) {o=>
        
        o.io.in(0).valid.poke(1.B)
        o.io.in(1).valid.poke(1.B)
        o.io.in(0).bits.poke(16.U)
        o.io.in(1).bits.poke(16.U)
        o.io.out.ready.poke(1.B)
        o.clock.step(1)
    }
   
}
}