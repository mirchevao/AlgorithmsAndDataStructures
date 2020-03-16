import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
	public static void main(String[] args) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		String s = "АБВГДЃЕЖЗЅИЈКЛЊМНЊОПРСТЌУФХЦЧЏШ";
		for (int i = 0; i < s.length(); i++) {
			m.put(s.charAt(i), i);// se polni hash mapata
		}

		System.out.println(m);
		// ja zemame vrednosta za bukavata Ш
		System.out.println("Kofichkata vo koja se naoga Ш e " + m.get('Ш'));
	}

}