package Lab6
// shift register example
import chisel3._

class Ex1(val init : Int = 1) extends Module {

    val io = IO (new Bundle{
    val in = Input(Vec(4,Bool()))
    val out = Output(Vec(4, (UInt(4.W))))
})

// register initialization
val state = RegInit (init.U(4.W))

// serial data in at LSB
val nextState1 = ( state << 1) | io.in(0)
val nextState2 = ( state << 1) | io.in(1)
val nextState3 = ( state << 1) | io.in(2)
val nextState4 = ( state << 1) | io.in(3)


//state := nextState1
io.out(0) := nextState1

//state := nextState2
io.out(1) := nextState2//state

//state := nextState3
io.out(2) := nextState3//state


//state := nextState4
io.out(3) := nextState4 //state

}