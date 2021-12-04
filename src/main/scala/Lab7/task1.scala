package Lab7
import chisel3._
import chisel3.util._

class task1 extends Module {
    val io = IO (new Bundle{
    val f1 = Input (Bool())
    val f2 = Input(Bool())
    val r1 = Input(Bool())
    val r2 = Input(Bool())
    val out = Output (UInt(32.W) )
    })
    val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum(6)
    val register = RegInit (s0)

    io.out := (register === s5) & (!io.f1)
    switch (register){
        is(s0) {
    when ((io.f1 === 0.U) && (io.f2 === 0.U)) {

    register := s0
    io.out := 0.U
    
    }.elsewhen((io.f1 === 1.U) && (io.f2 === 0.U)){

    register := s1
    io.out := 0.U
    }.elsewhen( (io.f1 === 0.U) && (io.f2 === 1.U)) {

    register := s5
    io.out := 0.U
    }.otherwise{
        register := s1
        io.out:= 0.U
    }
    }
    is (s1) {
    when ((io.f1 === 0.U) & (io.r1 === 0.U)) {

    register := s1
    io.out := 0.U
    
    }.elsewhen((io.f1 === 1.U)) {

    register := s2
    io.out := 0.U
    }.otherwise{
    register := s0
    io.out := 0.U
    }
    }
    is (s2) {
    when ((io.f1 === 0.U) && (io.r1 === 0.U)) {

    register := s2
    io.out := 3.U
    
    }.elsewhen((io.f1 === 1.U)) {

    register := s3
    io.out:= 3.U
    }.otherwise{

    register := s1
    io.out := 3.U
    }
    }
    is (s3) {
    
    register := s0
    io.out:= 0.U
    }
    is (s4) {
    
    when ((io.f2 === 1.U)) {
    register := s3
    io.out := 7.U

    }.elsewhen((io.f2 === 0.U) && (io.r2=== 0.U)) {
    register := s4
    io.out := 7.U

    }.otherwise{
    register := s5
    io.out:= 7.U
    }
    }
    is ( s5) {

    when ((io.f2 === 1.U)) {
    register := s4
    io.out:= 0.U

    }.elsewhen((io.f2 === 0.U) && (io.r2=== 0.U)) {
    register := s5
    io.out := 0.U

    }.otherwise{
        
    register := s0
    io.out:= 0.U
    }
    }
}
}