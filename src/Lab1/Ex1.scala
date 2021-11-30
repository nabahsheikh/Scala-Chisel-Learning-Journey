// package Lab1
// import chisel3._

// class Ex1(counterbits:UInt) extends Module{
//     val io = IO(new Bundle{
//         val output = Output(Bool())
//      })

//      val max = (1.U << counterbits) - 1.U
//      val count = RegInit(0.U(16.W))

//      when (count === max) {
//          count := 0.U

//      }.otherwise{
//          count := count + 1.U
//      }

//      io.output := count(15.U)
// }