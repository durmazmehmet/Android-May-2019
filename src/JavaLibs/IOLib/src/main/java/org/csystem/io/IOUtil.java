package org.csystem.io;

import java.io.*;

public class IOUtil {
	private IOUtil() {}	
	public static void copy(InputStream src, OutputStream dest, int blockSize, boolean flush) throws IOException
    {
		int read;		
		byte [] buf = new byte[blockSize];
		
		while ((read = src.read(buf)) > 0)
			dest.write(buf, 0, read);
		
		if (flush)
			dest.flush();					
    }
	
	public static void copy(InputStream src, OutputStream dest, int blockSize) throws IOException
    {
		copy(src, dest, blockSize, true);
    }

	@SuppressWarnings("unchecked")
	public static <T> T deSerialize(InputStream is) throws IOException, ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(is);

		return (T)ois.readObject();
	}

	public static <T> void serialize(OutputStream os, T t) throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(os);

		oos.writeObject(t);
	}
}
