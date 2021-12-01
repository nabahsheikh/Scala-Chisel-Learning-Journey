package Lab5

import chisel3._
import chiseltest._
import org.scalatest._

class Ex3test extends FreeSpec with ChiselScalatestTester{
    "operator"  in{
        test(new Ex3(4,UInt(16.W))( _ + _ )) {c=>
        c.io.in1(0).poke(2.U)
        c.io.in1(1).poke(3.U)
        c.io.in1(2).poke(4.U)
        c.io.in1(3).poke(1.U)

        c.io.in2(0).poke(2.U)
        c.io.in2(1).poke(3.U)
        c.io.in2(2).poke(4.U)
        c.io.in2(3).poke(2.U)
        
        c.io.in3(0).poke(2.U)
        c.io.in3(1).poke(3.U)
        c.io.in3(2).poke(4.U)
        c.io.in3(3).poke(3.U)

        c.io.in4(0).poke(2.U)
        c.io.in4(1).poke(3.U)
        c.io.in4(2).poke(4.U)
        c.io.in4(3).poke(4.U)
        c.clock.step(1)

        c.io.out(0).expect(10.U)

        c.io.out(1).expect(11.U)
        c.io.out(2).expect(12.U)
        c.io.out(3).expect(13.U)
        }
    }
}