package Lab6

import chisel3._
import  chiseltest._
import org.scalatest._

class Countertest extends FreeSpec with ChiselScalatestTester{
    "Counter"  in{
        test(new Counter(13)) {c=>
        c.clock.step(100)

        }
    }
}

