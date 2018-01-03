// The "HCalendar" class.
// Gregory Ho
// June 2016
import java.awt.*;
import hsa.Console;
import java.util.Random;

// This program asks the user to input any date after 1801. The program will then return the calendar for that exact date. The year is not limited at all to how BIG it can be.
// This program can go into an infinite amount of years, where the dates will be fairly accurate. This input is not limited besides that it must be after the year 1801.
// What makes this calendar special is that it not limited to a range of years of which it can compute. Any year after 1801 is allowed. This calendar can be used for everyday purposes.

public class HCalendar
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console (28, 80);   // Extended the height of the console window to fit an extra row into the calendar.


	int yy, mm, yyc, mmc, dd, ddc, dweek, leaps, days, maxdays, fday, x, y;         // Declare local variables.
	String dnumber = "";
	
	leaps = 0;                              // Assign values to certain variables so they can be accessed.
	maxdays = 0;
	fday = 0;
	
	c.println ("Enter The Desired Date Please...");         // Prompt user and retrieve user data.
	c.println ("Enter Any Year After 1801...");
	yy = c.readInt ();
	c.println ("Enter The Number of The Month...");                     
	mm = c.readInt ();                                                  
	c.println ("Enter The Number of The Day...");
	dd = c.readInt ();
	

	yyc = 1802;                             // Constants(forgot to make them CAPITALS)....They are used to calculate the days... This is what limits the user from entering a year less than 1801.
	mmc = 1;                                // Its used as a base-line to determine the day of the month the user selected.
	ddc = 1; // Friday
	
	yyc = yy - yyc;                          // Figuring out how many years and months are from Jan 1st 1802 so that i can determine the first day of the month the user selected.
	mmc = mm - mmc;
	
	leaps = (((yy - (yy % 4)) / 4) - 450);                          // Here I calculate the number of leap years between 1802 and the given year. It takes into account for all situations that form a leap year
	leaps = leaps - (((yy - (yy % 100)) / 100) - 18);
	leaps = leaps + (((yy - (yy % 400)) / 400) - 4);
	if (yy % 4 == 0)                            // Removes a leap year on a year that is a leap year. Otherwise an extra day will be added which is not required. Results would be off by one day for years
	{                                           // that are leap years and are entered.
	    leaps = leaps - 1;
	} 
	
	 // Calculate the number of days from other previous calulations.
	
	days = (yyc - leaps) * 365 + leaps * 366;   // This calculates the days for the years.
	if (mmc == 0)                               // This calculated teh days for the months of that year.
	{
	    maxdays = 31;                           // This also assings a value so that i know how many days are in the month given. ie: 28 or 29 or 30 or 31 days. So i only print that many days on the calendar.
	}
	if (mmc >= 1)
	{
	    days = days + 31;
	    if ((yy % 4) == 0)
	    {
		maxdays = 29;
	    }
	    else
	    {
		maxdays = 28;
	    }
	}
	if (mmc >= 2)
	{
	    if ((yy % 4) == 0)
	    {
		days = days + 29;
	    }
	    else
	    {
		days = days + 28;
	    }
	    maxdays = 31;
	}
	if (mmc >= 3)
	{
	    days = days + 31;
	    maxdays = 30;
	}
	if (mmc >= 4)
	{
	    days = days + 30;
	    maxdays = 31;
	}
	if (mmc >= 5)
	{
	    days = days + 31;
	    maxdays = 30;
	}
	if (mmc >= 6)
	{
	    days = days + 30;
	    maxdays = 31;
	}
	if (mmc >= 7)
	{
	    days = days + 31;
	    maxdays = 31;
	}
	if (mmc >= 8)
	{
	    days = days + 31;
	    maxdays = 30;
	}
	if (mmc >= 9)
	{
	    days = days + 30;
	    maxdays = 31;
	}
	if (mmc >= 10)
	{
	    days = days + 31;
	    maxdays = 30;
	}
	if (mmc >= 11)
	{
	    days = days + 30;
	    maxdays = 31;
	}

	// Removes excess weeks so i can determine the day of the month given.        
	
	dweek = (days % 7);
	
	if (dweek == 0)         // Determine the day of the month given based on the constant for Jan 1st 1802 is a FRIDAY
	{
	    fday = 6;
	}
	else if (dweek == 1)
	{
	    fday = 7;
	}
	else if (dweek == 2)
	{
	    fday = 1;
	}
	else if (dweek == 3)
	{
	    fday = 2;
	}
	else if (dweek == 4)
	{
	    fday = 3;
	}
	else if (dweek == 5)
	{
	    fday = 4;
	}
	else if (dweek == 6)
	{
	    fday = 5;
	}

	c.clear ();          // Clear the screen and prepare for calendar output

	// A nice explosion for looks....

	// START OF EXPLOSION   

	for (int explosion = 40 ; explosion < 62 ; explosion++)
	{
	    Random r = new Random ();
	    int z = r.nextInt (255);
	    int g = r.nextInt (255);
	    int b = r.nextInt (255);
	    c.setCursor (12, 41); //
	    c.print (" ");
	    c.setTextColor (new Color (z, g, b));
	    c.setCursor (12 - (explosion - 40), 40 - (explosion - 40)); //
	    c.print ("X");
	    c.setCursor (12 - (explosion - 40), 40 - 3 * (explosion - 40)); //
	    c.print ("X");
	    c.setCursor (12 - (explosion - 40), 40 - 8 * (explosion - 40)); //
	    c.print ("X");
	    c.setCursor (12, 40 - 3 * (explosion - 40)); //
	    c.print ("X");
	    c.setCursor (12 - (explosion - 40), 40); //
	    c.print ("X");
	    c.setCursor (12 - (explosion - 40), explosion); //
	    c.print ("X");
	    c.setCursor (12 - (explosion - 40), 40 + 3 * (explosion - 40)); //
	    c.print ("X");
	    if (40 + 8 * (explosion - 40) < 81) //
	    {
		c.setCursor (12 - (explosion - 40), 40 + 8 * (explosion - 40)); //
		c.print ("X");
	    }
	    if (40 + 3 * (explosion - 40) < 81)
	    {
		c.setCursor (12, 40 + 3 * (explosion - 40)); //
		c.print ("X");
	    }
	    if (12 + (explosion - 40) < 26)
	    {
		c.setCursor (12 + (explosion - 40), 40 - (explosion - 40)); //
		c.print ("X");
		c.setCursor (12 + (explosion - 40), 40 - 3 * (explosion - 40)); //
		c.print ("X");
		c.setCursor (12 + (explosion - 40), 40 - 8 * (explosion - 40)); //
		c.print ("X");
		c.setCursor (12 + (explosion - 40), 40); //
		c.print ("X");
		c.setCursor (12 + (explosion - 40), explosion); //
		c.print ("X");
		c.setCursor (12 + (explosion - 40), 40 + 3 * (explosion - 40)); //
		c.print ("X");
	    }
	    if (40 + 8 * (explosion - 40) < 81) //
	    {
		c.setCursor (12 + (explosion - 40), 40 + 8 * (explosion - 40)); //
		c.print ("X");
	    }
	    for (int delay = 0 ; delay < 10000000 ; delay++)
	    {
	    }
	}
	c.clear ();

	// END OF EXPLOSION

	// Creates the calendar outlines... borders, columns, and rows...
	
	c.drawRect (62, 60, 525, 490);
	for (int i = 100 ; i <= 475 ; i += 75)
	{
	    c.drawLine (62, i, 587, i);
	}
	for (int i = 62 ; i <= 588 ; i += 75)
	{
	    c.drawLine (i, 60, i, 550);
	}
	
	// Set new font and print the days on the calendar
	c.setFont (new Font ("Times New Roman", Font.PLAIN, 16));
	c.drawString ("Sunday", 75, 85);
	c.drawString ("Monday", 150, 85);
	c.drawString ("Tuesday", 225, 85);
	c.drawString ("Wednesday", 290, 85);
	c.drawString ("Thursday", 370, 85);
	c.drawString ("Friday", 455, 85);
	c.drawString ("Saturday", 525, 85);
	
	
	// This does all the calculations...
	// This prints out all the Numbers of the days given all the information that has been determined from previous calculations.
	// Prints the numbers of the month in proper order 
	// Highlights the day the user selected
	// MaxDays has already been determined...

	x = 21 + ((fday - 1) * 75);
	y = 145;
	for (int i = 1 ; i <= maxdays ; i++)
	{
	    if (x > 500)
	    {
		x = 21;
		y = y + 75;
	    }
	    x += 75;
	    dnumber = Integer.toString (i);
	    if (dd == i)
	    {
		c.setColor (Color.YELLOW);
		c.fillRect (x - 33, y - 44, 74, 74);
	    }
	    c.setColor (Color.BLACK);
	    c.drawString (dnumber, x, y);
	}

	// This determines the name of the month given and Prints out the Date for the Calendar.

	c.setFont (new Font ("Times New Roman", Font.BOLD, 35));
	if (mm == 1)
	{
	    c.drawString (dd + " January, " + yy, 200, 45);
	}
	if (mm == 2)
	{
	    c.drawString (dd + " February, " + yy, 200, 45);
	}
	if (mm == 3)
	{
	    c.drawString (dd + " March, " + yy, 200, 45);
	}
	if (mm == 4)
	{
	    c.drawString (dd + " April, " + yy, 200, 45);
	}
	if (mm == 5)
	{
	    c.drawString (dd + " May, " + yy, 200, 45);
	}
	if (mm == 6)
	{
	    c.drawString (dd + " June, " + yy, 200, 45);
	}
	if (mm == 7)
	{
	    c.drawString (dd + " July, " + yy, 200, 45);
	}
	if (mm == 8)
	{
	    c.drawString (dd + " August, " + yy, 200, 45);
	}
	if (mm == 9)
	{
	    c.drawString (dd + " September, " + yy, 200, 45);
	}
	if (mm == 10)
	{
	    c.drawString (dd + " October, " + yy, 200, 45);
	}
	if (mm == 11)
	{
	    c.drawString (dd + " November, " + yy, 200, 45);
	}
	if (mm == 12)
	{
	    c.drawString (dd + " December, " + yy, 200, 45);
	}

	// Place your program here.  'c' is the output console
    } // main method
} // HCalendar class


