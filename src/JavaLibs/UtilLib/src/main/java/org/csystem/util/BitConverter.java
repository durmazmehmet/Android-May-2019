/*----------------------------------------------------------------------
	FILE        : BitConverter.java
	AUTHOR      : Oguz Karan
	LAST UPDATE : 03.04.2019
	
	BitConverter class for byte operations with built-in types
	
	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/

package org.csystem.util;

import java.nio.ByteBuffer;

public class BitConverter {
	private BitConverter() {}

	private static ByteBuffer allocate(int capacity)
	{
		return ByteBuffer.allocate(capacity);
	}

	private static ByteBuffer wrap(byte [] data, int offset, int length)
	{
		return ByteBuffer.wrap(data, offset, length);
	}
	
	public static byte [] getBytes(String str)
	{
		return str.getBytes();
	}
	
	public static byte [] getBytes(byte value)
	{
		return new byte [] {value};
	}
	
	public static byte[] getBytes(short value)
	{
		return allocate(2).putShort(value).array();
	}
	
	public static byte[] getBytes(int value)
	{
		return allocate(4).putInt(value).array();
	}
	
	public static byte[] getBytes(long value)
	{
		return allocate(8).putLong(value).array();
	}	
	
	public static byte[] getBytes(char value)
	{
		return allocate(2).putChar(value).array();
	}
	
	public static byte[] getBytes(double value)
	{
		return allocate(8).putDouble(value).array();
	}
	
	public static byte[] getBytes(float value)
	{
		return allocate(4).putFloat(value).array();
	}
	
	public static byte[] getBytes(boolean value)
	{
		return new byte[] {(byte)(value ? 1 : 0)};
	}	
	
	public static String toString(byte [] data)
	{
		return new String(data);
	}
	
	public static short toShort(byte [] data)
	{
		return toShort(data, 0);		
	}
	
	public static short toShort(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 2).getShort();
	}
	
	public static int toInt(byte [] data)
	{
		return toInt(data, 0);		
	}
	
	public static int toInt(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 4).getInt();
	}
	
	public static long toLong(byte [] data)
	{
		return toLong(data, 0);		
	}
	
	public static long toLong(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 8).getLong();
	}
	
	public static char toChar(byte [] data)
	{
		return toChar(data, 0);		
	}
	
	public static char toChar(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 2).getChar();
	}
		
	
	public static double toDouble(byte [] data)
	{
		return toDouble(data, 0);		
	}
	
	public static double toDouble(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 8).getDouble();
	}	
	
	public static float toFloat(byte [] data)
	{
		return toFloat(data, 0);		
	}
	
	public static float toFloat(byte [] data, int startIndex)
	{
		return wrap(data, startIndex, 4).getFloat();
	}	
	
	public static boolean toBoolean(byte [] data)
	{
		return toBoolean(data, 0);		
	}
	
	public static boolean toBoolean(byte [] data, int startIndex)
	{
		return data[startIndex] == 1;
	}
}
