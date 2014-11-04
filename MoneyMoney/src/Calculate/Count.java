package Calculate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeSet;

import InputAndOutput.Output;
import MyAccount.MyAccount;

public class Count {
	public static void TodayCount(TreeSet<MyAccount> myAccounts) {
		System.out.println("本日統計:") ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		TreeSet<MyAccount> tempAccounts = new TreeSet<MyAccount>() ;
		Calendar today = Calendar.getInstance() ; 
		Date tempDate = null ;
	    Calendar tempDateCal = Calendar.getInstance();
		int totalCount = 0 ;

   		for ( MyAccount myAccount : myAccounts ) {
			try {
				tempDate = formatter.parse(myAccount.getDate());
				tempDateCal.setTime(tempDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if ( ((Calendar) today).get(Calendar.DAY_OF_YEAR) == tempDateCal.get(Calendar.DAY_OF_YEAR)) {
				totalCount = totalCount + myAccount.getCost() ;
				tempAccounts.add(myAccount) ;
			} // end if
		} // end for
   		
   	    Output.PrintCountData( totalCount, tempAccounts) ;
	} // TodayCount()

	public static void WeekCount(TreeSet<MyAccount> myAccounts) {
		System.out.println("本週統計:") ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		TreeSet<MyAccount> tempAccounts = new TreeSet<MyAccount>() ;
		Calendar today = Calendar.getInstance() ; 
		Date tempDate = null ;
	    Calendar tempDateCal = Calendar.getInstance();
		int totalCount = 0 ;

   		for ( MyAccount myAccount : myAccounts ) {
			try {
				tempDate = formatter.parse(myAccount.getDate());
				tempDateCal.setTime(tempDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if ( ((Calendar) today).get(Calendar.WEEK_OF_YEAR) == tempDateCal.get(Calendar.WEEK_OF_YEAR) ) {
				totalCount = totalCount + myAccount.getCost() ;
				tempAccounts.add(myAccount) ;
			} // end if
		} // end for
   		
   	    Output.PrintCountData( totalCount, tempAccounts) ;
	}
	
	public static void MonthCount(TreeSet<MyAccount> myAccounts) {
		System.out.println("本月統計:") ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		TreeSet<MyAccount> tempAccounts = new TreeSet<MyAccount>() ;
		Calendar today = Calendar.getInstance() ; 
		Date tempDate = null ;
	    Calendar tempDateCal = Calendar.getInstance();
		int totalCount = 0 ;

   		for ( MyAccount myAccount : myAccounts ) {
			try {
				tempDate = formatter.parse(myAccount.getDate());
				tempDateCal.setTime(tempDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if ( ((Calendar) today).get(Calendar.MONTH) == tempDateCal.get(Calendar.MONTH) ) {
				totalCount = totalCount + myAccount.getCost() ;
				tempAccounts.add(myAccount) ;
			} // end if
		} // end for
   		
   	    Output.PrintCountData( totalCount, tempAccounts) ;
	}	
	
}
