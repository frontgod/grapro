package nuc.sw.util;
/**
 * ?ַ?????????
 * @author 24872
 *
 */
public class StringUtil {

	/**
	 * ?ж??Ƿ?Ϊ??
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * ?ж??Ƿ????ǿ?
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
