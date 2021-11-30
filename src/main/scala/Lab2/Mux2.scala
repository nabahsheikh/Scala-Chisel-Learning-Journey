package Lab2
import chisel3._
import chisel3.util._

class Mux2 extends Bundle{
    val in_A = Input(UInt(4.W))
    val in_B = Input(UInt(4.W))
    val select = Input(Bool())
    val out = Output(UInt())


}

class Mux2_1 extends Module{
    val io = IO(new Mux2)

    io.out := Mux(io.select, io.in_A, io.in_B)
}