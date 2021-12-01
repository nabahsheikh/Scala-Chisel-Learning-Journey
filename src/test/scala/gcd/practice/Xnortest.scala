package practice
import chisel3._
import chiseltest._
import org.scalatest._

class Xnortest extends FreeSpec with ChiselScalatestTester {
    "New Xnor gate test" in{
        test(new Xnor()){ t =>
        t.io.a.poke(1.U)
        t.io.b.poke(1.U)
        t.clock.step(1)
        t.io.output.expect(0.U)}
    }
}