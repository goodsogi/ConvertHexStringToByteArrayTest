package com.example.converthexstringtobytearrayexample;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
public class MainActivity extends Activity {
final String TEST_HEX_STRING = "00A0BF";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		byte[] results = null;
		results = hexStringToByteArray(TEST_HEX_STRING);
		
		for(int i=0;i<results.length;i++) {
			Log.i("hex", "results: " + Byte.valueOf(results[i]));
		}
		
		Toast.makeText(this, "result: " + bytesToHex(results), Toast.LENGTH_SHORT).show();
//		byte[] results = null;
//		try {
//			results = Hex.decodeHex(TEST_HEX_STRING.toCharArray());
//		} catch (DecoderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Toast.makeText(this, "result: " + results.toString(), Toast.LENGTH_SHORT).show();
		
	}
	
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}

	

}
