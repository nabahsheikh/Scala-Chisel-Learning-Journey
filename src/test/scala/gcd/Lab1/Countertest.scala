package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class Countertest extends FreeSpec with ChiselScalatestTester{
    "New counter test" in{
        test(new Counter(3.U)) { n =>
        n.clock.step(100)}
    }
}