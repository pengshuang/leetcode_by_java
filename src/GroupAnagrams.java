import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


class GroupAnagrams {
	public List<List<String>> anagrams(String[] strs) {
		HashMap<String, List<String>> group = new HashMap<>();
		List<List<String>> res = new ArrayList<>();
		for (String s : strs) {
			char[] chs = s.toCharArray();
			Arrays.sort(chs);
			String key = new String(chs);
			if (group.containsKey(key)) {
				group.get(key).add(s);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(s);
				group.put(key, list);
			}
		}
		Iterator<String> iter = group.keySet().iterator();
		while (iter.hasNext()) {
			List<String> list = group.get(iter.next());
			if (list.size() >= 1) {
				res.add(list);
			}
		}
		return res;
	}

}
