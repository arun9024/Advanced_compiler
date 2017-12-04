import java.util.HashMap;
import java.util.Map;

class RegisterAllocator {
	Map<String, Boolean> _state;
	public static final String[] AllReg = {"%r10", "%r11", "%rbx", "%r12", "%r13", "%r14", "%r15", "%rax", "%r9", "%r8", "%rcx", "%rdx", "%rsi", "%rdi"};
        public static final String[] ParamReg = {"%rdi", "%rsi", "%rdx", "%rcx", "%r8", "%r9"};
        
        void initialize() {
                for (String reg : AllReg) {
                    _state.put(reg, false);
                }
        }

	RegisterAllocator() {
		_state = new HashMap<String, Boolean>();
                initialize();
	}

        String acquireIfFree(String reg) {
		if (!_state.get(reg)) {
			_state.put(reg, true);
			return reg;
		}
		return null;
        }

	String getFreeReg() {
		for (String reg : AllReg) {
                        String ret = acquireIfFree(reg);
                        if (ret != null) return ret;
		}
		return null;
	}

	String getParamReg(int index) {
                return acquireIfFree(ParamReg[index]);
	}

	boolean freeRegister(String reg) {
		if (!_state.containsKey(reg)) return false;
                _state.put(reg, false);
		return true;
	}
}
