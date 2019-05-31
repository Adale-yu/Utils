package constant.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum ResultCode {

	OK(1),
	LOGIN_FALI_OPENID_ERROR(2),
	LOGIN_FALI_PASSWORD_ERROR(3),
	PVE_GAME_FAIL_HERO_ERROR(4),

	;

	private final int value;

	private static Map<Integer, ResultCode> map = new HashMap<>();

	static {
		ResultCode[] types = ResultCode.values();
		for (int i = 0, len = types.length; i < len; i++) {
			map.put(types[i].intValue(), types[i]);
		}
	}

	private ResultCode(int value) {
		this.value = value;
	}

	public int intValue() {
		return this.value;
	}

	public static final ResultCode valueOf(int value) {
		return map.get(value);
	}

	public static final Set<Integer> getAllType() {
		return map.keySet();
	}

}
