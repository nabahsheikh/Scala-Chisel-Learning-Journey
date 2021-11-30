import chisel3._
import chisel3.util._
//import chisel3.iotesters.{
//ChiselFlatSpec,Driver,PeekPokeTester
//}
class ValidInterf extends Module {
    val io = IO (new Bundle {
    val in = Flipped (Valid(UInt(8.W))) // valid = Input ,
    val out = Valid (UInt(8.W)) // valid = Output ,
})

io.out := RegNext(io.in)
}