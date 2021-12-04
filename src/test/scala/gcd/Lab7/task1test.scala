package Lab7

import org.scalatest._
import chiseltest._
import chisel3._

class task1Test extends FreeSpec with ChiselScalatestTester{
    "Task1 lab7 "in {
        test(new task1){c =>
        c.io.f1.poke(0.B)
        c.io.f2.poke(0.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(1.B)
         c.clock.step(100)
    }
   
}
}