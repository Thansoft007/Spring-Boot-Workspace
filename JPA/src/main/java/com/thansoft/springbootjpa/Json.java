package com.thansoft.springbootjpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Json {

	public static void main(String[] args) {
		
		int num = 7044; 
		  
        // Output is 3 zero's("000") + "7044", 
        // in total 7 digits 
        String gfg3 = String.format("%07d", num); 
  
        System.out.println(gfg3); 
		// TODO Auto-generated method stub
		/*try {
			List<String> lines = Files.readAllLines(Paths.get("D:\\test.txt"));
			ArrayList<String> refs = new ArrayList<>();
			for (String line : lines) {
				if (line.contains("\"refNo\": ")) {
					String data = line.substring("\"refNo\": ".length() + 5, line.length() - 2);
					if (!refs.contains("'"+data+"'"))
						refs.add("'"+data+"'");
				}
			}
			System.out.println(refs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
