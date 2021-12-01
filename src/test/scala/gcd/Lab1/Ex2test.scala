package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class Ex2test extends FreeSpec with ChiselScalatestTester{
    "Ex2 test" in{
        test(new Ex2()) { n =>
        n.clock.step(100)}
    }
}