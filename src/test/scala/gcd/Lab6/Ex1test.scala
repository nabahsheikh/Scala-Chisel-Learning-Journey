package Lab6

import chisel3._
import  chiseltest._
import org.scalatest._

class Ex1test extends FreeSpec with ChiselScalatestTester{
    "Exercise 1 Lab6"  in{
        test(new Ex1()) {c=>
        c.io.in(0).poke(1.B)
        c.io.in(1).poke(0.B)
        c.io.in(2).poke(1.B)
        c.io.in(3).poke(0.B)
        c.clock.step(1)
        c.io.out(0).expect(3.U)
        c.io.out(1).expect(2.U)
        c.io.out(2).expect(3.U)
        c.io.out(3).expect(2.U)
        }
    }
}
