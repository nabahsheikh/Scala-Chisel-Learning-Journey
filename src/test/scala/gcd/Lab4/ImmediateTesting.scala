package Lab4

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import org.scalatest.FreeSpec
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

import scala.util.Random


class ImmediateTesting extends FreeSpec with ChiselScalatestTester {
    "Immediate unit Test" in {
    test (new ImmediateGenerator) {c =>

    val array_imm = Array("h00300193","h00600213","h00418263")

    for ( i <- 0 until 100) {
        val imm = Random.nextInt(2)
        val imm_sel = array_imm(imm)
    
    val result = imm_sel match{
        case "h00300193" =>  3
        case "h00600213" => 6
        case "h00418263" => 4
    
    }
        c.io.instr.poke(imm_sel.U)
        c.clock.step(1)
        c.io.immd_se.expect(result.S)
    }
        c.clock.step(2)
    }
    }
}


