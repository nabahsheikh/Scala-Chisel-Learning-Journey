package Lab1

import chisel3._

class Ex2() extends Module{
    val io = IO(new Bundle{
        val output = Output(Bool())
     })

     val count = RegInit(0.U (4.W))
     
     when(count(3.U) === 1.U) {
        count := 0.U

     }.otherwise{
        count := count + 1.U
     }
    
     io.output := count(3.U)
}