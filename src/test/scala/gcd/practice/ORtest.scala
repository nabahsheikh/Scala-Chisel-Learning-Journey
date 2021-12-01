package practice
import org.scalatest._
import chiseltest._
import chisel3._

class ORtest extends FreeSpec with ChiselScalatestTester {
    "New OR gate test" in{
        test(new OR()){ t =>
        t.io.a.poke(1.U)
        t.io.b.poke(0.U)
        t.clock.step(1)
        t.io.output.expect(1.U)}
    }
}