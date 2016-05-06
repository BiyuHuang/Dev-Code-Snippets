import java.io._

object Test {
	def main(args:Array[String]){
		val writer = new FileWriter(new File("Test.txt"))
		writer.write("菜鸟教程！！")
		writer.close()


		//读取路径下的文本文件
		// val source =Source.fromFile("G:\\MyCode\\common_code\\test.txt","UTF-8")
		// val contents = source.mkString
		// println(contents) 
	}
}
