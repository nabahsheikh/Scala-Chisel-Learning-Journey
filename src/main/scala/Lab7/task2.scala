package Lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

// Sequence to detect is 110
class Task2 extends Module {
    val io = IO ( new Bundle {
    val in = Input ( Bool () )
    val out = Output ( Bool () )
    })
    val s0 :: s1 :: s2 :: Nil = Enum (3)
    val reg = RegInit ( s0 )
    io . out := (reg === s2) & (!io.in)

    switch (reg) {
    is(s0) {
    when(io.in) {


    reg := s1
    }
    }
    is ( s1 ) {
    when ( io.in ) {
    

    reg := s2
    } .otherwise {
    reg := s0
}
}
    is ( s2 ) {
    when (!io.in ) {
    reg := s0
        }
    }
    }
}