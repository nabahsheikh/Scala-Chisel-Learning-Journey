package Lab8

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Task1test extends FreeSpec with ChiselScalatestTester{
    "Task1 Lab8" in {
        test (new Task1){c=>
        c.io.writeaddr.poke(4.U)
        c.io.write_en.poke(1.B)
        c.io.requestor(0).valid.poke(1.B)
        c.io.requestor(1).valid.poke(1.B)
        c.io.requestor(2).valid.poke(1.B)
        c.io.requestor(3).valid.poke(1.B)

        c.io.readaddr.poke(4.U)
        c.io.requestor(0).bits.poke(8.U)
        c.io.requestor(1).bits.poke(8.U)
        c.io.requestor(2).bits.poke(8.U)
        c.io.requestor(3).bits.poke(8.U)

        c.io.mem_out.ready.poke(1.B)

        c.clock.step(1)
        }
    }
}