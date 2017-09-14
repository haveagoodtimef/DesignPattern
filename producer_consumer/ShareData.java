package oneHundred;

/**
 * 共享数据模型(不变模式)
 * @author feng-hong-zhang
 *
 * 2017年9月14日
 */
public final class ShareData {
	private final int Data;

	public ShareData(int Data) {
		this.Data = Data;
	}
	
	public ShareData(String StringData) {
		this.Data = Integer.valueOf(StringData);
	}
	
	public int getData() {
		return Data;
	}

	@Override
	public String toString() {
		return "ShareData [Data=" + Data + "]";
	}
	
	
	
}
