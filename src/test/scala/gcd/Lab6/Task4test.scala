package Lab6

import chisel3._
import  chiseltest._
import org.scalatest._

class Task4test extends FreeSpec with ChiselScalatestTester{
    "Counter"  in{
        test(new Task4(13)) {c=>
        c.clock.step(100)

        }
    }
}