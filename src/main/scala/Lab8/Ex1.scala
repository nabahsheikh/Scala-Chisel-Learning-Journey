package Lab8
import chisel3._

class Ex1 extends Module {
    
    val io = IO (new Bundle {
    val en = Input (Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(UInt(2.W)) 
    val datain = Input(UInt(32.W))
    val dataout = Output(UInt(32.W))
})

    val memory = SyncReadMem (1024 , UInt(32.W))

    when(io.mask === 0.U){
         memory.write (io.addr,io.datain(7,0))
    }.elsewhen(io.mask === 1.U){
        memory.write (io.addr, io.datain(15,0))
     }
    .otherwise{
        memory.write ( io.addr , io.datain)
    }
        io.dataout := memory.read (io.addr, io.en)
}