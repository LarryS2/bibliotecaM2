package logico;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tiempo {
    
    Calendar date  = new GregorianCalendar();
    
    String year = Integer.toString(date.get(Calendar.YEAR));
    String month = Integer.toString(date.get(Calendar.MONTH));
    String day = Integer.toString(date.get(Calendar.DATE));
    
    public String fecha_completa = year+"-"+month+"-"+day;
    
    String hour = Integer.toString(date.get(Calendar.HOUR_OF_DAY));
    String minute = Integer.toString(date.get(Calendar.MINUTE));
    
    public String hora_completa = hour+":"+minute;
    
}
