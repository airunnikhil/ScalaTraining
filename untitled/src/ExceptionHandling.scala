import java.io.BufferedInputStream

object ExceptionHandling {
  def main(args: Array[String]): Unit = {

    try {

      val file = new BufferedInputStream()(
        new FileInputStream("auth.csv"))

    }
    catch {
      case ex: Exception =>{
        println(ex)
      }
    }
    finally {

    }
  }
}
