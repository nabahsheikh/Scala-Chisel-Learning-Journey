package Lab3

import chisel3._
import  chiseltest._
import org.scalatest._

class Switchencodertest extends FreeSpec with ChiselScalatestTester{
    "Switch Encoder"  in{
        test(new Switchencoder()) {c=>
        c.io.in.poke("b0100".U)
        c.clock.step(1)
        c.io.out.expect("b10".U)        
        }
    }
}