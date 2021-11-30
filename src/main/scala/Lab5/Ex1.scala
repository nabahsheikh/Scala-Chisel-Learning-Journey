package Lab5

import chisel3._
import chisel3.util._
//import chisel3.iotesters.{Driver, PeekPokeTester}

class Ex1 ( width_parameter : Int ) extends Module {
    val io = IO ( new Interface ( width_parameter ) )
    
    val index = log2Ceil (width_parameter)

    //AND
    when(io.alu_oper === "b0000".U){
        io.alu_out := io.arg_x & io.arg_y
    
    //OR
    }.elsewhen(io.alu_oper === "b0001".U){
        io.alu_out := io.arg_x | io.arg_y
    
    //ADD
    }.elsewhen(io.alu_oper === "b0010".U){
        io.alu_out := io.arg_x + io.arg_y
    
    //SUB
    }.elsewhen(io.alu_oper === "b0110".U){
        io.alu_out := io.arg_x - io.arg_y
    
    //XOR
    }.elsewhen(io.alu_oper === "b0011".U){
        io.alu_out := io.arg_x ^ io.arg_y
    
    //SLL
    }.elsewhen(io.alu_oper === "b0100".U){
        io.alu_out := io.arg_x << io.arg_y(index -1,0)
    
    //SRL
    }.elsewhen(io.alu_oper === "b0101".U){
        io.alu_out := io.arg_x >> io.arg_y (index -1 ,0)

    //SRA    
    }.elsewhen(io.alu_oper === "b0111".U){
         io.alu_out := (io.arg_x.asSInt >> io.arg_y (index -1 ,0)).asUInt

    // SLT
    }.elsewhen(io.alu_oper === "b1000".U){
         io.alu_out := io.arg_x.asSInt < io.arg_y.asSInt

    //SLTU
    }.elsewhen(io.alu_oper === "b1001".U){
        io.alu_out := io.arg_x < io.arg_y
    
    }.otherwise{
        io.alu_out := 0.U
    }
            
}

class Interface ( width : Int ) extends Bundle {
    val alu_oper = Input (UInt(width.W))
    val arg_x = Input (UInt(width.W))
    val arg_y = Input (UInt(width.W))
    val alu_out = Output (UInt(width.W))

}