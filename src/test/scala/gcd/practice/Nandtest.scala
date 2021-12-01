package practice

import chisel3._
import chiseltest._
import org.scalatest._

class Nandtest extends FreeSpec with ChiselScalatestTester {
    "New Nand gate test" in{
        test(new Nand()){ t =>
        t.io.a.poke(1.U)
        t.io.b.poke(0.U)
        t.clock.step(1)
        t.io.output.expect(1.U)}
    }
}