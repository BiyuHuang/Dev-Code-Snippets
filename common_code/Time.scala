import java.util.Locale
import java.text.SimpleDateFormat
import java.util.Date 
val loc = new Locale("en")
val fm = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",loc)
val tm = "30/Jul/2015:05:00:50"
val dt2 = fm.parse(tm);
dt2.getTime()