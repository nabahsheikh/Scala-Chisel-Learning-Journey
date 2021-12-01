package practice
import org.scalatest._
import chiseltest._
import chisel3._

class Nottest extends FreeSpec with ChiselScalatestTester {
    "New Not gate test" in{
        test(new Not()){ s =>
        s.io.a.poke(1.U)
        s.io.output.expect(0.U)}
    }
}