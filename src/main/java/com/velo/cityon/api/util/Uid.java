package com.velo.cityon.api.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Uid {
	private static String addr = "0000";
	private static Integer seq = 0;
	
	static {
		try {
			byte[] addrByte = InetAddress.getLocalHost().getAddress();
			addr = String.format("%02x%02x", addrByte[2], addrByte[3]);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static synchronized String getUid() {
		String time = String.format("%012x", System.currentTimeMillis());
		String seqStr = String.format("%02x", 0xFF & seq++);
		return time + "-" + addr + "-" + seqStr;
	}
}
