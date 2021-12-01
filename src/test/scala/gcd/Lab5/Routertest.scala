package Lab5

import chisel3._
import  chiseltest._
import org.scalatest._

class Routertest extends FreeSpec with ChiselScalatestTester{
    "Router Task"  in{
        test(new Router(UInt(16.W))) {c=>
        c.io.in.databit.poke(5.U)
        c.io.in.addressbit.poke(5.U)
        c.clock.step(1)

        c.io.out.databit.expect(5.U)
        c.io.out.addressbit.expect(5.U)
        }
    }
}