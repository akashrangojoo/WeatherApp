package edu.niu.cs.z1717009.weatherapp;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


/**
 * Created by z1717009 on 5/5/2016.
 */
public class Weather
{
    public final String dayOfWeek,
            lowTemp, highTemp,
            humidity,
            description,
            iconURL;

    public Weather( long timeStamp, double newLowTemp, double newHighTemp, double newHumidity, String descrip, String iconName )
    {
        //Get an object that can be used to format the numeric data with no digits after
        //a decimal point
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);

        //Convert the numeric day representation to a string representation
        dayOfWeek = convertTimeStampToDay(timeStamp);

        //Format the temperatures and add a degree marker and F for Fahrenheit
        lowTemp = numberFormat.format(newLowTemp) + "\u00B0F";
        highTemp = numberFormat.format(newHighTemp) + "\u00B0F";

        //Format the humidity with a percent sign
        humidity = NumberFormat.getPercentInstance().format(newHumidity / 100.0);

        //Initialize the weather conditions
        description = descrip;

        //Set up the url for the icon that displayes the weather conditions
        iconURL = "http://openweathermap.org/img/w/" + iconName + ".png";
    }//end of constructor


    //Convert the numeric day representation to Monday, Tuesday, etc...
    private static String convertTimeStampToDay( long timeStamp )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp * 1000);
        TimeZone timeZone = TimeZone.getDefault();

        calendar.add(Calendar.MILLISECOND, timeZone.getOffset(calendar.getTimeInMillis()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(calendar.getTime());
    }//end convertTimeStampToDay

}//end Weather class




