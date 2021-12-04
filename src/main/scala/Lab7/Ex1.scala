package Lab7

import chisel3._
import chisel3.util._


class Ex1 extends Module{
   
    val io = IO ( new Bundle {
    val in = Flipped (Vec(2,Decoupled (UInt(8.W))) )// valid = Input , ready =Output , bits = Input
    val out = Decoupled (UInt (8.W))
    })
    val queue1 = Queue (io.in(0),5)
    val queue2 =Queue( io.in(1),5)

io.out.valid := 1.U
io.out.bits  := 0.U
 
queue1.nodeq() 
queue2.nodeq()

val a_prior = Module ( new Arbiter (UInt(),2) )
a_prior.io.in(0) <> queue1
a_prior.io.in(1)<> queue2


io.out <> a_prior.io.out
}