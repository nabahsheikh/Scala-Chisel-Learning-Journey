package Lab1

import chisel3._
import chiseltest._
import org.scalatest._

class Counter2test extends FreeSpec with ChiselScalatestTester{
    "Counter2"  in{
        test(new Counter2(5,20.U){ v=>
     v.clock.step(5)})
    }
}