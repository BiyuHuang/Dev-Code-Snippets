import java.util.Locale
import java.text.SimpleDateFormat
import java.util.Date 

object Time {
  val loc = new Locale("en")
  val fm = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",loc)
  val tm = "30/Jul/2015:05:00:50"
  val dt2 = fm.parse(tm);
  dt2.getTime()

  //将指定日期转换为xxxx年的xx周
  def getWeekInYear(dateStr:String):DateInfo1X = {
    val date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr)
    val calendar = Calendar.getInstance()
    calendar.setFirstDayOfWeek(Calendar.MONDAY)
    calendar.setMinimalDaysInFirstWeek(4)
    calendar.setTime(date)
    val week = calendar.get(Calendar.WEEK_OF_YEAR)
    val month = calendar.get(Calendar.MONTH)+1
    val year = calendar.get(Calendar.YEAR)
    val yearofweek = {
      if (week == 1 && month == 12) year + 1
      else if (week >= 52 && month == 1) year - 1
      else year
    }
    DateInfo1X(year,-1,-1,week,yearofweek)
  }
 }
}
