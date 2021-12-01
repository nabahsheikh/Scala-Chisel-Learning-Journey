package practice

import chisel3._
import chiseltest._
import org.scalatest._

class Addertest extends FreeSpec with ChiselScalatestTester {
    "New Adder test" in{
        test(new Adder()){ t =>
        t.io.a.poke(1.U)
        t.io.b.poke(0.U)
        t.clock.step(1)
     //   t.io.sum.expect(1.U)
    //    t.io.carry.expect(0.U)}
        }
        }
    }
