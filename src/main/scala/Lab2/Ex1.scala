package Lab2
import chisel3._
import chisel3.util._

class MUX extends Bundle{
    val in_A = Input(UInt(4.W))
    val in_B = Input(UInt(4.W))
    val select = Input(Bool())
    val out = Output(UInt())


}

class Ex1 extends Module{
    val io = IO(new MUX)

    io.out := Mux(io.select, io.in_A, io.in_B)
}