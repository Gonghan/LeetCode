package Jan;

/*
 * Implement strStr().

 Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
public class strStrSolution {

	public String strStr(String haystack, String needle) {
		int nLen = needle.length();
		int hLen = haystack.length();
		if (needle.isEmpty()) {
			return haystack;
		}
		if (nLen == hLen) {
			if (haystack.equals(needle)) {
				return haystack;
			} else {
				return null;
			}
		}
		for (int i = 0; i < hLen - nLen; i++) {
			String sub = haystack.substring(i, i + nLen);
			if (sub.equals(needle)) {
				return haystack.substring(i, hLen);
			}
		}
		return null;
	}
}
