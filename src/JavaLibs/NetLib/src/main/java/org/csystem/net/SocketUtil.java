/*----------------------------------------------------------------------
FILE        : SocketUtil.java
AUTHOR      : Oguz Karan
LAST UPDATE : 26.01.2018

SocketUtil class for socket applications

Copyleft (c) 1993 by C and System Programmers Association (CSD)
All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.net;

import org.csystem.util.BitConverter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SocketUtil {
	private SocketUtil() {}

	public static int read(DataInputStream dis, byte [] data, int offset, int length) throws IOException
	{
	    int result;
	    int left = length, index = 0;

	    while (left > 0) {
	        if ((result = dis.read(data, offset, left)) == -1)
	            return -1;
	        
	        if (result == 0)
	            break;
	        
	        index += result;
	        left -= result;
	    }

	    return index;
	}
	
	public static int read(DataInputStream dis, byte [] data) throws IOException
	{
	    return read(dis, data, 0, data.length);
	}

	public static int readInt(DataInputStream dis) throws IOException
    {
        byte [] data = new byte[4];

        read(dis, data);

        return BitConverter.toInt(data);
    }

    public static String readString(DataInputStream dis) throws IOException
    {
        byte [] dataLen = new byte[4];
        read(dis, dataLen);
        byte [] data = new byte[BitConverter.toInt(dataLen)];

        read(dis, data);

        return BitConverter.toString(data);
    }

	public static int write(DataOutputStream dos, byte [] data, int offset, int length) throws IOException
	{						
		int curOffset = offset;		
		int left = length;
		int total = 0;
		int written;
		int initWritten = dos.size();
		
		while (curOffset < length) {
			dos.write(data, curOffset, left);
			dos.flush();
			written = dos.size() - initWritten;
			total += written;			
			left -= written;
			curOffset += written;
		}	
		
		return total;
	}
	
	public static int write(DataOutputStream dos, byte [] data) throws IOException
	{
	    return write(dos, data, 0, data.length);
	}

	public static void writeInt(DataOutputStream dos, int val) throws IOException
    {
        write(dos, BitConverter.getBytes(val));
    }

    public static void writeString(DataOutputStream dos, String str) throws IOException
    {
        byte [] data = BitConverter.getBytes(str);
        byte [] dataLen = BitConverter.getBytes(data.length);

        write(dos, dataLen);
        write(dos, data);
    }
}
