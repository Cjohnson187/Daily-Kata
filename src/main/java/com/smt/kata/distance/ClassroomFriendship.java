package com.smt.kata.distance;

import java.util.ArrayList;
// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: ClassroomFriendship.java <b>Project</b>: SMT-Kata
 * <b>Description: </b> Classroom Friendship Kata
 * 
 * A classroom consists of N students, whose friendships can be represented in
 * an adjacency list. For example, the following descibes a situation where 0 is
 * friends with 1 and 2, 3 is friends with 6, and so on.
 * 
 * {0: [1, 2], 1: [0, 5], 2: [0], 3: [6], 4: [], 5: [1], 6: [3]}
 * 
 * Each student can be placed in a friend group, which can be defined as the
 * transitive closure of that student's friendship relations. In other words,
 * this is the smallest set such that no student in the group has any friends
 * outside this group. For the example above, the friend groups would be {0, 1,
 * 2, 5}, {3, 6}, {4}.
 * 
 * Given a friendship list such as the one above, determine the number of friend
 * groups in the class.
 * 
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
public class ClassroomFriendship {

	/**
	 * Counts the groups of friends
	 * @param friends friend assignments
	 * @return count of the number of friend groups
	 */
	public int countGroups(Map<Integer, List<Integer>> friends) {
		if(friends == null) return 0;
		
		List<List<Integer>> groups = new ArrayList<>();
		
		for(Map.Entry<Integer, List<Integer>> v : friends.entrySet()) {
			if(v.getKey() == null || v.getValue() == null) continue;
			int loc = containsNum(groups, v.getKey());                      
			if( loc != -1) {
				for(Integer i : v.getValue()) {
					if(i == null) continue;
					else if( !groups.get(loc).contains(i))
						groups.get(loc).add(i);
					
				}
			}
			else {
				List<Integer> nList = new ArrayList<>();
				nList.add(v.getKey());
				if(v.getValue() == null) continue;
				for(Integer i : v.getValue()) {
					if(i == null || nList.contains(i)) continue;
					else 
						nList.add(i);
				}
				groups.add(nList);
			}
		}	
		return groups.size();
	}

	public int containsNum(List<List<Integer>> nums, Integer num) {
		for(int i=0; i< nums.size(); i++) {
			if(nums.get(i) == null) continue;
			for (Integer l : nums.get(i)) {
				if (l == null) continue;
				if (l == num) return i;
			}
		}
		return -1;
	}
}
