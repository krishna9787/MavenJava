package com.Collections.app;


import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC001TstNGDtaPrvder {
  @DataProvider
  public Object[] [] fn() {
	  HashMap<String,String> hs = new HashMap();
	  hs.putIfAbsent("Krishnadas", "Mohanan");
	  hs.putIfAbsent("Katha", "Kadam");
	  System.out.println(hs);	
	Set ha = hs.entrySet();
	int k=0,j;
	Object[][] data = new Object[hs.size()][hs.size()];
	Iterator i= ha.iterator(); 
	while(i.hasNext())  {
		j=0;
		Map.Entry mp = (Map.Entry) i.next();
		 data[k][j]=mp.getKey();
		 j++;
		 data[k][j]=mp.getValue();
		 k++;
	};	
	
	return data;
	  
  }
  
  @Test(dataProvider = "fn")
  public void fn1(String u, String v) {
	  
	  System.out.println(u+" "+v);
  }
}
