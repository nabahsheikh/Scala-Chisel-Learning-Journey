import chisel3._
import chisel3.util._

class Task4 ( val max : Int = 10) extends Module {
val io = IO ( new Bundle {
val out = Output (UInt (log2Ceil( max ) . W ) )
val up_down = Input ( Bool () )
})
// Start code here

// End your code here
}