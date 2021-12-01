package Lab4

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import org.scalatest.FreeSpec
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

import scala.util.Random

object instruction_identifier2{
    val beq = 0 
    val bne = 1
    val blt = 4
    val bltu = 6
    val bge = 5
    val bgeu = 7
}
import instruction_identifier2._

class Branchtesting extends FreeSpec with ChiselScalatestTester {
    "Branch unit Test" in {
    test (new Branch) {c =>
    val array_branch = Array (beq, bne, blt, bltu, bge, bgeu)
    
    for ( i <- 0 until 5) {
        val src_a = Random.nextLong () & 0xFFFFFFFFL
        val src_b = Random.nextLong () & 0xFFFFFFFFL
        val sel = Random.nextInt(5)
        val branch_sel = array_branch(sel)
        val branch_signal = Random.nextBoolean()

        val result = branch_sel match{
            case beq => src_a == src_b 

           case bne => src_a != src_b
                                                
           case blt => src_a < src_b
           case bltu => src_a < src_b
           case bge => src_a >= src_b
           case bgeu => src_a >= src_b
        }
        
       
        
//else result //& 0xFFFFFFFFL

    println(src_a)
    println(src_b)
    println(branch_sel)
    println(branch_signal)
    println(result)
    
    
        c.io.in_A.poke(src_a.U)
        c.io.in_B.poke(src_b.U)
        c.clock.step(1)
        
        if((result == true) & (branch_signal == true)) 
            c.io.br_taken.expect (true.B)

        
        else c.io.br_taken.expect(false.B)

    }
        c.clock.step(2)
    }
    }

    }

