package Lab4

import chisel3._
import chisel3.util._

object instruction_identifier1{
    val beq = "b000".U (3.W)
    val bne = "b001".U (3.W)
    val blt = "b100".U (3.W)
    val bltu = "b110".U (3.W)
    val bge = "b101".U (3.W)
    val bgeu = "b111".U (3.W)
}

import instruction_identifier1._

class Interface_BranchControl extends Bundle {
    val func3 = Input (UInt(3.W))
    val branch = Input (Bool())
    val in_A = Input (UInt(32.W))
    val in_B = Input (UInt(32.W))
    val br_taken = Output (Bool())
}

class Branch extends Module {
    val io = IO (new Interface_BranchControl )
// Start Coding here
    when ((io.func3 === beq) & (io.branch === true.B) & (io.in_A === io.in_B)){
        io.br_taken := true.B
    
    }.elsewhen ((io.func3 === bne) & (io.branch === true.B) & (io.in_A =/= io.in_B)){
        io.br_taken := true.B
    
    }.elsewhen (((io.func3 === blt) | (io.func3 === bltu))& (io.branch === true.B) & (io.in_A < io.in_B)){
        io.br_taken := true.B
    
    }.elsewhen (((io.func3 === bge) | (io.func3 === bgeu )) & (io.branch === true.B) & (io.in_A >= io.in_B)){
        io.br_taken := true.B
        

    }.otherwise{
        io.br_taken := false.B
    }
}

    // io.br_taken := false.B
    // switch (io.func3){
    //     is("b000"){
    //         io.br_taken := true.B
    //     }
    //     is ("b001"){
    //         io.br_taken := true.B
    //     }
    //     is("b100"){
    //         io.br_taken := true.B
    //     }
    //     is("b101"){
    //         io.br_taken := true.B
    //     }
    //     is("b110"){
    //         io.br_taken := true.B
    //     }
    //     is("b111"){
    //         io.br_taken := true.B
    //     }
    // }
