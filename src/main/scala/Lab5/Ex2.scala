package Lab5

import chisel3._
import chisel3.util._

class Mux [ T <: Data ]( gen : T ) extends Bundle{
    val out = Output(gen)
    val in1 = Input(gen)
    val in2 = Input(gen)
    val sel = Input(Bool())
}


class Ex2(alp : SInt) extends Module {
    val io = IO (new Mux(alp))
    io.out := Mux(io.sel, io.in1, io.in2)
    
}

// println (( new chisel3.stage.ChiselStage).emitVerilog(new eMux(SInt(2.W))))