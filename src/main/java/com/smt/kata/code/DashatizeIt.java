package com.smt.kata.code;

import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: DashatizeIt.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Dashatize It
 * 
 * Given a variable n,
 * 
 * If n is an integer, Return a string with dash'-'marks before and after each
 * odd integer, but do not begin or end the string with a dash mark. If n is
 * negative, then the negative sign should be removed.
 * 
 * If n is not an integer, return an empty value.
 * 
 * Ex:
 * dashatize(274) -> '2-7-4' 
 * dashatize(6815) -> '68-1-5'
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class DashatizeIt {

	/**
	 * Formats the string of numbers into a Dashatize format
	 * @param input String to be processed.  All non numeric characters are omitted
	 * @return Formatted string.  Empty string if input is empty or null
	 */
    public String process(String input) {
    	String ret = "";
    	if(StringUtil.isEmpty(input)) {
    		return ret;
    	}

    	char[] chars = input.toCharArray();
    	for(char c: chars) {
    		if (c < 48 || c > 57) continue;
    		else if(c%2 == 1) {
    			if (ret.length() > 1 && ret.charAt(ret.length()-1) == '-')
    				ret += c +"-";
    			else {
    				ret += "-" +c+"-";
    			}
    		}
    		else {
    			ret+=c;
    		}
    	}
   
    	if(ret.length() > 1 && ret.charAt(0)== '-' ) ret = ret.substring(1);
    	if(ret.length() > 1 && ret.charAt(ret.length()-1)== '-' ) ret = ret.substring(0 , ret.length()-1);
    	
    	return ret;
    }
}
