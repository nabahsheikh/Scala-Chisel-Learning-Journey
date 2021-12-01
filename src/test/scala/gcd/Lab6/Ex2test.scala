package Lab6

import chisel3._
import  chiseltest._
import org.scalatest._

class Ex2test extends FreeSpec with ChiselScalatestTester{
    "Exercise 2 lab 6"  in{
        test(new Ex2(16)) {c=>
        c.clock.step(100)

        }
    }
}