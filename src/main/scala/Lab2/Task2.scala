package Lab2

import chisel3._
import chisel3.util._

class Task2 extends Module {
    val io = IO ( new Bundle {
    val in = Vec (4,Input (Bool()))
    val sel = Vec (2,Input (Bool()))
    val shift_type =Input (Bool())
    val out = Vec (4 , Output (Bool()))
})
// Start you code here



// End your code here
}