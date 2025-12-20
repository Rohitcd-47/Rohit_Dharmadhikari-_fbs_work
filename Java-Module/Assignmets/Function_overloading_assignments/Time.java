class Time
{
	int hr, min, sec;
	
	Time(int hr, int min, int sec)
	{
		this.hr = hr;
		this.min = min;
		this.sec = sec;
	
		normalize();
	}
	
	Time add(Time t)
	{
		Time result = new Time(this.hr+t.hr, this.min+t.min, this.sec+t.sec);
		return result;
	}
	
	Time add(int value)
	{
		Time result = new Time(this.hr, this.min, this.sec + value);
		return result;
	}
	
	void normalize()
	{
        	if (sec >= 60)
        	{
        		min += sec / 60;
        		sec = sec % 60;
        	}

        	if (min >= 60)
        	{
            		hr += min / 60;
            		min = min % 60;
        	}

        	if (hr >= 24)
        	{
            		hr = hr % 24;
        	}
 	}

	String show()
   	{
        	return hr + ":" + min + ":" + sec;
    	}
}
	
class TestTime
{
	public static void main(String [] args)
	{
		Time t1 = new Time(10,50,75);
		Time t2 = new Time(5,70,59);

		Time sum1 = t1.add(t2);
		Time sum2 = t2.add(50);
	
		System.out.println("Add two times: "+sum1.show());
		System.out.println("Add Time + Seconds: "+sum2.show());		
	
		
	}
}