package Lab1

import chisel3._
import chiseltest._
import org.scalatest._

class AdderWithOffsettest extends FreeSpec with ChiselScalatestTester{
    "Adderoffset" in{
        test(new AdderWithOffset(){ u =>
        u.io.x.poke(1.S)
        u.io.y.poke(1.U)
        u.clock.step(1)
        u.io.z.expect(2.U)
        })
    }
}