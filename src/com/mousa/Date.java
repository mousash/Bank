package com.mousa;

import java.text.DecimalFormat;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 1970;
	}
	
	public Date(int day, int month, int year) {
		setDate(day, month, year);
	}
	
	public Date(Date date) {
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}
	
	public boolean setDate(int day, int month, int year) {
		boolean result = false;
		if (checkDate(day, month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
			result = true;
		}else {
			backToDefault();
		}
		
		return result;
	}
	
	
	public boolean checkDate(int day, int month, int year) {
		boolean result = false;
				
		if(day<=0 || day>31 || month<=0 || month>12 || year<=0) {
			System.out.println("Error");
//			backToDefault();
			return result;
		}else {
			switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(day<=31) {
					result = true;
				}
				break;
			case 2:
				if(isLeapYear(year)) {
					if(day<=29) {
						result = true;
					}
				}else {
					if(day<=28) {
						result = true;
					}
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(day<=30) {
					result = true;
				}
				break;
				
				default:
					System.out.println("Error3");
			}
		}

		return result; 
	}
	
	public boolean isBefore(Date date) {
		boolean flag = false;
		
		if(date.year > year) {
			flag = true;
		}
		if(date.year>=year && date.month>month) {
			flag = true;
		}
		if(date.year>=year && date.month>=month && date.day>day) {
			flag = true;
		}
		
		return flag;
	}
	
	private void checkingAddingDay() {
		day = 1;
		int tempMonth = month + 1;

		if(tempMonth>12) {
			month = 1;
			year++;
		}else {
			month++;
		}
	}
	
	public Date addDay() {

		int temp = this.day + 1;
		
		switch (this.month) {
		//Jan, March, May, July, August, Oct, December
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(temp > 31) {
				checkingAddingDay();
			}else {
				day++;
			}
			break;
			//Feb
		case 2:
			if(isLeapYear(year)) {
				if(temp > 29) {
					checkingAddingDay();
				}else {
					day++;
				}
			}else {
				if(temp > 28) {
					checkingAddingDay();
				}else {
					day++;
				}
			}
			
			break;
			//April, June, Sep, Nov, 
		case 4:
		case 6:
		case 9:
		case 11:
			if(temp > 30) {
				checkingAddingDay();
			}else {
				day++;
			}
			break;
			
		default:
			
		}
		
		return new Date(day,month,year);
	}
	
	private boolean isLeapYear(int year) {
        boolean flag = false;
        
        if(year % 400 == 0) {
            flag = true;
        }
        else if (year % 100 == 0) {
            flag = false;
        }
        else if(year % 4 == 0) {
            flag = true;
        }
        else {
            flag = false;
        }
        if(flag) {
            System.out.println("Year "+year+" is a Leap Year");
        }
        else {
            System.out.println("Year "+year+" is not a Leap Year");
        }
        
        return flag;
	}
	
	
	private void backToDefault() {
		day = 1;
		month = 1;
		year = 1970;
	}
	

	public String toString() {
		 DecimalFormat df = new DecimalFormat("00");
		return df.format(this.day)+"."+df.format(this.month)+"."+df.format(this.year); //[day=" + this.day + ", month=" + this.month + ", year=" + this.year + "]";
	}

	
	static int noOfObjects = 0;
    { 
        noOfObjects++; 
    }

	
}
