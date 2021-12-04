package Lab8

import chisel3._
import chisel3.util._

class Ex2 extends Module {
    val width : Int = 16
    val io = IO(new Bundle {
        val wrdata = Input(Vec(2, UInt(width.W)))
        val out = Output(Vec(2, UInt(width.W)))
        val rdAddr = Input(UInt(10.W))
        val wrAddr = Input(UInt(10.W))
        val mask = Input(Vec(2, Bool()))
        val write_en = Input(Bool())
})

        val memory = SyncReadMem(1024, Vec(2, UInt(width.W)))
        val wrDataReg = RegNext(io.wrdata)
        val doForwardReg = RegNext(io.wrAddr === io.rdAddr && io.write_en)
        val memData = memory.read(io.rdAddr)

        when (io.write_en) {
            memory.write(io.wrAddr, io.wrdata, io.mask)
        }

        io.out := Mux(doForwardReg, wrDataReg, memData)

}