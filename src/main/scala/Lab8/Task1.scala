package Lab8

import chisel3._
import chisel3.util._

class Task1 extends Module {
    val io = IO(new Bundle {
        val mem_out = Decoupled(UInt(32.W))
        val requestor = Vec(4,Flipped(Decoupled(UInt(32.W))))
        val readaddr = Input(UInt(5.W))
        val writeaddr = Input(UInt(5.W))
        val write_en = Input(Bool())
})

    val mem = Mem(32 , UInt(32.W))

    val queue_0 = Queue(io.requestor(0), 5) 
    val queue_1 = Queue(io.requestor(1), 5) 
    val queue_2 = Queue(io.requestor(2), 5)
    val queue_3 = Queue(io.requestor(3), 5)

    io.mem_out.valid := 1.B


    val arb_priority = Module(new Arbiter(UInt(),4))

        arb_priority.io.in(0) <> queue_0
        arb_priority.io.in(1) <> queue_1
        arb_priority.io.in(2) <> queue_2
        arb_priority.io.in(3) <> queue_3

        arb_priority.io.out.ready := 1.B
        
        when(io.write_en) {
            mem.write(io.writeaddr, (arb_priority.io.out).asUInt)
        }

    
        io.mem_out.bits := mem.read(io.readaddr)

}