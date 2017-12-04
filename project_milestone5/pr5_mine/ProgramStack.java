import java.util.HashMap;
import java.util.Map;

class ProgramStack {
        public static final int WIDTH = 8;
	private Map<String, Integer> _layout;
	int _curr;

	ProgramStack() {
		_layout = new HashMap<String, Integer>();
		_curr = -WIDTH;
	}
	
	boolean containKey(String value) {
		return _layout.containsKey(value);
	}
	void push(String name) {
		if (containKey(name)) return;
		_layout.put(name, _curr);
		_curr -= WIDTH;
	}
	int getOffset(String name) {
		return _layout.get(name);
	}
	String getMemory(String name) {
		return ("[%rbp" + _layout.get(name) + "]");
	}
	int getFrameSize() {
		return -(_curr+WIDTH);
	}
}
