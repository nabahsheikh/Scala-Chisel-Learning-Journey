package Lab3

import chisel3._
import chisel3.util._

object Aluop {
// ALU Operations , may expand / modify in future
val ALU_ADD = 0.U (4.W )
val ALU_SUB = 1.U (4.W )
val ALU_AND = 2.U (4.W )
val ALU_OR = 3.U (4.W )
val ALU_XOR = 4.U (4.W )
val ALU_SLT = 5.U (4.W )
val ALU_SLL = 6.U (4.W )
val ALU_SLTU = 7.U (4.W )
val ALU_SRL = 8.U (4.W )
val ALU_SRA = 9.U (4.W )
val ALU_COPY_A = 10.U (4.W )
val ALU_COPY_B = 11.U (4.W )
val ALU_XXX = 15.U (4.W )
}

trait Config1 {
    // word length configuration parameter
    val WLEN = 32

    // ALU operation control signal width
    val ALUOP_SIG_LEN = 4
}

import Aluop._

class Ex2 extends Bundle with Config1{
    val in_A = Input(UInt(WLEN.W))
    val in_B = Input(UInt(WLEN.W))
    val alu_Op = Input(UInt(ALUOP_SIG_LEN.W))
    val out = Output(UInt(WLEN.W))
    val sum = Output(UInt(WLEN.W))
}
class SwitchAlu extends Module with Config1 {
    val io = IO ( new Ex2 )

    val sum = io.in_A + Mux ( io.alu_Op (0), -io.in_B, io.in_B )
    
    val cmp = Mux ( io.in_A (WLEN-1) === io.in_B(WLEN-1), sum (WLEN-1) ,Mux (io.alu_Op (1) ,io.in_B (WLEN-1), io.in_A (WLEN -1)))

    val shamt = io.in_B (4,0).asUInt

    val shin = Mux ( io.alu_Op(3) ,io.in_A, Reverse(io.in_A))

    val shiftr = (Cat(io.alu_Op(0) && shin( WLEN -1),shin). asSInt >> shamt) (WLEN-1 ,0)

    val shiftl = Reverse (shiftr)

    io.out := 0.U
    switch (io.alu_Op) {
        is (0.U){
            io.out := sum
        }
        is (1.U){
            io.out := sum
        }
        is(2.U){
            io.out := (io.in_A & io.in_B)
        }
        is(3.U){
            io.out := (io.in_A | io.in_B)
        }
        is(4.U){
            io.out := (io.in_A ^ io.in_B)

        }
        is(5.U){
            io.out := cmp
        }
        is(6.U){
            io.out := shiftl
        }
        is(7.U){
            io.out := cmp
        }
        is(8.U){
            io.out := shiftr
        }
        is(9.U){
            io.out := shiftr
        }
        is(10.U){
            io.out := io.in_A
        }
        is(11.U){
            io.out := io.in_B
        }
    }
    io.sum := sum
}