package practice
import org.scalatest._
import chiseltest._
import chisel3._

class ANDtest extends FreeSpec with ChiselScalatestTester{
    "New And Gate Test" in{
        test(new AND()){ n =>
        n.io.a.poke(1.U) 
        n.io.b.poke(1.U)
        n.clock.step(1)
        n.io.output.expect(1.U)
        }
    }

    
}
