package Lab2

import chisel3._
import  chiseltest._
import org.scalatest._

class Ex1test extends FreeSpec with ChiselScalatestTester{
    "Exercise 1"  in{ 
        test(new Ex1()){ z =>
        z.io.in_A.poke("b1010".U)
        z.io.in_B.poke("b0001".U)
        z.io.select.poke(1.B)
        z.clock.step(1)
        z.io.out.expect("b1010".U)}

    }
}