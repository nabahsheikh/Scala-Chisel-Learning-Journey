package Lab5
import chisel3._
import chisel3.util._
//import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }

// your code for Transaction_in class
class DataPacket[T <: Data]( gen : T ) extends Bundle{
        val databit = gen
        val addressbit = (UInt(5.W))

    }

// your code for Transaction_out class

class Router (alpha : UInt) extends Module {
   val io = IO(new Bundle{
        val in = Input(new DataPacket(alpha))
        val out = Output(new DataPacket(alpha))
    })
    io.out <> io.in
// your code begin
// your code end
}