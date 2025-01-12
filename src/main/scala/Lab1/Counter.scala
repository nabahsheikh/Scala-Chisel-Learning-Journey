package Lab1
import chisel3._

class Counter(counterbits:UInt) extends Module{
    val io = IO(new Bundle{
        val output = Output(Bool())
     })

     val max = (1.U << counterbits) - 1.U
     val count = RegInit(0.U (4.W))

     when (count === max) {
         count := 0.U

     }.otherwise{
         count := count + 1.U
     }
    
     io.output := count(3.U)
}