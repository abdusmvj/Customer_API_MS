package com.tcs.ecom.utility;

import java.util.Random;

public class CommonUtility {
	
	public int getOrderId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}

}
