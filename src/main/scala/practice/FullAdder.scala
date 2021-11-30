package practice

import chisel3._

class FullAdder extends Module{
    val io = IO(new Bundle{
        val a = Input(UInt(2.W))
        val b = Input(UInt(2.W))
        val sum = Output(UInt(2.W))

    })
    io.sum := io.a + io.b
}