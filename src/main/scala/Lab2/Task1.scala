
package Lab2
import chisel3._
import chisel3.util._


class Intro extends Bundle {
    val s0 = Input(Bool())
    val s1 = Input(Bool())
    val s2 = Input(Bool())
    
    val in0 = Input(UInt(32.W))
    val in1 = Input(UInt(32.W))
    val in2 = Input(UInt(32.W))
    val in3 = Input(UInt(32.W))
    val in4 = Input(UInt(32.W))

    val out = Output(UInt(32.W))
}

class Task1 extends Module{
    val io = IO(new Intro)

    io.out := Mux(io.s0,(Mux(io.s1,io.in4, Mux(io.s2,io.in2, io.in3))), (Mux(io.s1, io.in1, io.in0)))

    //io.out := Mux1H(io.s0, Seq(io.in0, io.in1, io.in2, io.in3, io.in4))


}