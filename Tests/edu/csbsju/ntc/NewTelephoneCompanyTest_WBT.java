package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	 private NewTelephoneCompany ntc;
	  @Before
	  public void setUp() throws Exception {
	    ntc = new NewTelephoneCompany();
	  }

	@Test (expected=UnsupportedOperationException.class)
	public void testComputeChargeInvalidStartTime() {
		ntc.setStartTime(-1);
		ntc.setDuration(10);
		ntc.computeCharge();
		
	}

	
	@Test (expected=UnsupportedOperationException.class)
	public void testComputeChargeInvalidDuration() {
		ntc.setStartTime(1800);	
		ntc.setDuration(-1);
		ntc.computeCharge();
		}
	
	
	
	@Test
	public void testComputeChargeDiscountStartTimeAndDuration() {
		ntc.setStartTime(759);	
		ntc.setDuration(61);
	double expected = 1078.48;
    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expected ,expected ==ntc.computeCharge());  

	}
	
	

	
	@Test
	public void testComputeChargeDiscountStartTime() {
		ntc.setStartTime(0);	
		ntc.setDuration(60);
	double expected = 1248;
    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expected ,expected ==ntc.computeCharge());  

	}
	
	
	
	
	@Test
	public void testComputeChargeDiscountedDuration() {
		ntc.setStartTime(900);	
		ntc.setDuration(61);
	double expected = 2156.96;
    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expected ,expected ==ntc.computeCharge());  

	}
	
	@Test
	public void testComputeChargeNoDiscounts() {
		ntc.setStartTime(1759);	
		ntc.setDuration(60);
	double expected = 2496.00;
    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expected ,expected ==ntc.computeCharge());  

	}
}
