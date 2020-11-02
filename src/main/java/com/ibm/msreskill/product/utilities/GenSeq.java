package com.ibm.msreskill.product.utilities;

import java.util.concurrent.atomic.AtomicLong;

public class GenSeq {
	
	    private static AtomicLong numberGenerator = new AtomicLong(101);

	    public static long getNext() {
	        return numberGenerator.getAndIncrement();
	    }
	    
	
	
}
