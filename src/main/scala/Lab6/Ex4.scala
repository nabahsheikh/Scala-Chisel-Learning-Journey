package Lab6
import chisel3._
import chisel3.util. _


class Ex4 extends Module {
    val io = IO ( new Bundle {
    val in = Flipped (Decoupled(UInt(8. W ))) // valid = Input , ready =Output , bits = Input
    val out = Decoupled (UInt(8.W))// valid = Output , ready =Input , bits = Output
})

val queue1 = Queue ( io.in ,5)
val queue2 =Queue (queue1,5)


queue1.nodeq()
queue2.nodeq()

when (queue2.valid && io.out.ready === 1.B){
        io.out.enq(queue2.deq())
}
// 5 - element queue
io.out <> queue1
}