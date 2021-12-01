package Lab6

import chisel3._
import  chiseltest._
import org.scalatest._

class Task2test extends FreeSpec with ChiselScalatestTester{
    "Task2 Lab6"  in{
        test(new Task2) {c=>
        c.clock.step(100)

        }
    }
}
