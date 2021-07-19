package com.smt.kata.object;

// JDK 11.x
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: JsonParser.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Json Parser
 * Write a function to flatten a nested dictionary. Namespace the keys with a period.
 * 
 * For example, given the following dictionary:
 * 
 * {
 *     "key": 3,
 *     "foo": {
 *         "a": 5,
 *         "bar": {
 *             "baz": 8
 *         }
 *     }
 * }
 * 
 * it should become:
 * 
 * {
 *     "key": 3,
 *     "foo.a": 5,
 *     "foo.bar.baz": 8
 * }
 * 
 * You can assume keys do not contain dots in them, i.e. no clobbering will occur.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 19, 2021
 * @updates:
 ****************************************************************************/
public class JsonParser {

	/**
	 * Parses the json string and returns a map of unique keys and values
	 * @param json Json object to parse
	 * @return Map of keys and values.  Values are mapped to their data types
	 * @throws IOException 
	 */
	public Map<String, Object> parse(String json) throws IOException {
		Map<String, Object> data = new HashMap<>();
		//for 
		String s = json.replace("\n", "").replace(" ", "").replace("\t", "");
		s = s.substring(s.indexOf("{")+1, s.lastIndexOf("}")-1);
//		List<String> lines =  Arrays.asList(s.split('{'));
//		System.out.println("lns = "+ lines.size());
//		for(var  v: lines) {
//			System.out.println("line = " + v);
//		}
		System.out.println("s= " + s);
		
		String j = json.substring(json.indexOf("{")+1, json.lastIndexOf("}")-1 );
		//System.out.println("line = " + j);
		//List<String> obj =  Arrays.asList(line.split(","));
		//System.out.println("len" + obj.size());
		data.putAll(  mapJson("",j)  );
	
		for(var v: data.entrySet()) {
			System.out.println("key = " + v.getKey() +"   "+ v.getValue());
		}
		

		return data;
	}
	
	public Map<String, Object> mapJson(String key, String j){
		Map<String, Object> data = new HashMap<>();
		String cur = j.substring(j.indexOf("'") );
		String ln = cur.substring(cur.indexOf("'")+1, cur.indexOf("\n") );
		
		//System.out.println("str = " + key + "cur = "+ cur+"  ln = "+ ln);
		if(key.length() < 1)
		key = ln.substring(0, ln.indexOf("'"));
		else {
			key +="." +  ln.substring(0, ln.indexOf("'"));
		}
		System.out.println("keeeyeyeye = " +  key);
		String val = j.split("\\n")[1];
		j = j.substring(j.indexOf(",") );
		if (val.contains("{")) {
			System.out.println("crap");
			data.putAll(  mapJson(key, j)  );
			
		}
		else {
			try {
				data.put(key, Integer.valueOf(val.substring(val.indexOf(":")+1, val.indexOf(",")).trim()));
			} catch (Exception e) {
				data.put(key, val.substring(val.indexOf(":")+1, val.indexOf(",")).trim());
			}
			
			
		}
		//System.out.println("str = " + key +" val "+ val );
		
		
		
		return data;
	}
}
