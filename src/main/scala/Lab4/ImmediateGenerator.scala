package Lab4

import chisel3._
import chisel3.util._


object Type_Identifier1 {
    val R_type = "b0110011".U(7.W)
    val R_type2 = "b0111011".U(7.W)
    val I_type1 = "b0000011".U(7.W)
    val I_type2 = "b0010011".U(7.W)
    val I_type3 = "b0011011".U(7.W)
    val S_type = "b0100011".U(7.W)
    val U_type1 = "b0110111".U(7.W)
    val U_type2 = "b0010111".U(7.W)
    val SB_type = "b1100011".U(7.W)
    val UJ_type = "b1101111".U(7.W)    
    
    
}

import Type_Identifier1._

class ImmdValGen1 extends Bundle {
    val instr = Input (UInt(32.W))
    val immd_se = Output (SInt(32.W))
}

class ImmediateGenerator extends Module {
    val io = IO (new ImmdValGen1)
    
    val S = io.instr(11,7)
    val S2 = io.instr (31,25)
    val SB = Cat(io.instr(7),io.instr(11,8),io.instr(30,25),io.instr(31))
    val U = Cat(io.instr(31,12))
    val UJ = Cat(io.instr(19,12),io.instr(20), io.instr(30,21), io.instr(31))

    when((io.instr(6,0) === I_type1 )| (io.instr(6,0) === I_type2) | (io.instr(6,0) === I_type3)){
    //    io.immd_se := 1.U
        io.immd_se := io.instr(31,20).asSInt

    //     //io.immd_se := Cat()

     }.elsewhen(io.instr(6,0) === S_type) {
         io.immd_se := Cat(S,S2).asSInt
     
     }.elsewhen((io.instr(6,0) === U_type1) | (io.instr(6,0) === U_type2)){
        io.immd_se := U.asSInt

     }.elsewhen(io.instr(6,0) === SB_type ){
         io.immd_se := SB.asSInt

     }.elsewhen(io.instr(6,0) === UJ_type){
         io.immd_se := UJ.asSInt

     }.otherwise{
         io.immd_se := 0.S
     }

}