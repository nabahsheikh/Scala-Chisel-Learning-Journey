package Lab2
import chisel3._
import util._

class Ex2 extends Module {
    val io = IO (new Bundle{
    val in0 = Input (Bool())
    val in1 = Input (Bool())
    val in2 = Input (Bool())
    val in3 = Input (Bool())
    val in4 = Input (Bool())
    val in5 = Input (Bool())
    val in6 = Input (Bool())
    val in7 = Input (Bool())
    val sel1 = Input (UInt(1.W))
    val sel2 = Input (UInt(1.W))
    val sel3 = Input (UInt(1.W))
    val out = Output (Bool())
})

    io.out := MuxLookup(io.sel3,false.B,Array(
        (0.U) -> (MuxLookup(io.sel2,false.B,Array(
                    (0.U) -> (MuxLookup(io.sel1,false.B, Array(
                                (0.U) -> io.in0,
                                (1.U) -> io.in1))),

                    (1.U) -> (MuxLookup(io.sel1,false.B, Array(
                                (0.U) -> io.in2,
                                (1.U) -> io.in3)))
                ))),

        (1.U) -> (MuxLookup(io.sel2,false.B,Array(
                    (0.U) -> (MuxLookup(io.sel1,false.B, Array(
                                (0.U) -> io.in4,
                                (1.U) -> io.in5))),

                    (1.U) -> (MuxLookup(io.sel1,false.B, Array(
                                (0.U) -> io.in6,
                                (1.U) -> io.in7)))
        )))
                ))
}