package practice
import org.scalatest._
import chiseltest._
import chisel3._

class Xortest extends FreeSpec with ChiselScalatestTester {
    "New Xor gate test" in{
        test(new Xor()){ t =>
        t.io.a.poke(0.U)
        t.io.b.poke(0.U)
        t.clock.step(1)
        t.io.output.expect(0.U)}
    }
}