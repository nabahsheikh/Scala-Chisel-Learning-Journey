package Lab2
import chisel3._

class Mux_2to1 extends Module{
    val io = IO (new Bundle{
    val in_A = Input(Bool())
    val in_B = Input(Bool())
    val select = Input(Bool())
    val out = Output(Bool())
})
 io.out := (io.in_A & (~io.select)) | (io.in_B & io.select)
}





