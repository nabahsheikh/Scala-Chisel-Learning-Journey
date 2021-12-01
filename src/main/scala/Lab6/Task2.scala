package Lab6

import chisel3._
import chisel3.util._

class Task2 ( val max : Int = 1) extends Module {
val io = IO ( new Bundle {
val out = Output (UInt((log2Ceil(max).W)))

})
val counter1 = RegInit(0.U(6.W))

val func = counter1(5) ^ 1.U 
val check = Mux(func === 1.U, 0.U, counter1 + 1.U)

counter1 := func
io.out := counter1

}