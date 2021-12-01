package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class counter_up_downtest extends FreeSpec with ChiselScalatestTester{
    "counter_up_down test" in{
        test (new counter_up_down(4)){ t =>
        t.clock.step(100)
        } 

     }
}