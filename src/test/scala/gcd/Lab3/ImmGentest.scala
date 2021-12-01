package Lab3

import chisel3._
import  chiseltest._
import org.scalatest._

class ImmGentest extends FreeSpec with ChiselScalatestTester{
    "Immediate Generator"  in{
        test(new ImmGen()) {c=>
        c.io.instr.poke("b00000000010100000000000100010011".U)
        c.clock.step(1)
       // c.io.immd_se.expect(5.S)
        }
            
       
    }
}