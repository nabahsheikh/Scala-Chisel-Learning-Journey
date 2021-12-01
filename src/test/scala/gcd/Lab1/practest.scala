package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class practest extends FreeSpec with ChiselScalatestTester{
    "Practice" in{
        test (new pract(3)){ n =>
        n.clock.step(100)
        } 

     }
}