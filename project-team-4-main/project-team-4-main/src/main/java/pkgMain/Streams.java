package pkgMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Tool class of IO
 */
public class Streams {


	/**
	 *Get BufferedReader through file path
	 * @param path
	 * @return BufferedReader
	 */
	public static BufferedReader getBufferedReader(String path) {
		return getBufferedReader(new File(path));
	}

	/**
	 * Get BufferedReader through file
	 * @param file
	 * @return BufferedReader
	 */
	public static BufferedReader getBufferedReader(File file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;
	}

	/**
	 * Get BufferedReader through file path,and charset
	 * @param path
	 * @param charset
	 * @return BufferedReader
	 */
	public static BufferedReader getBufferedReader(String path, String charset) {
		return getBufferedReader(new File(path), charset);
	}

	/**
	 * Get BufferedReader through file,and charset
	 * @param file
	 * @param charset
	 * @return BufferedReader
	 */
	public static BufferedReader getBufferedReader(File file, String charset) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return br;
	}

	/**
	 * Get BufferedWriter through  path
	 * @param path
	 * @return BufferedWriter
	 */
	public static BufferedWriter getBufferedWriter(String path) {
		return getBufferedWriter(new File(path));
	}

	/**
	 * Get BufferedWriter through  path,and charset
	 * @param path
	 * @param charset
	 * @return BufferedWriter
	 */
	public static BufferedWriter getBufferedWriter(String path, String charset) {
		return getBufferedWriter(new File(path), charset);
	}

	/**
	 *  Get BufferedWriter through  file
	 * @param file
	 * @return BufferedWriter
	 */
	public static BufferedWriter getBufferedWriter(File file) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bw;
	}

	/**
	 *Get BufferedWriter through  file,and charset
	 * @param file
	 * @param charset
	 * @return BufferedWriter
	 */
	public static BufferedWriter getBufferedWriter(File file, String charset) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return bw;
	}


	/**
	 * You can use this method to close most methods that need to close resources
	 * @param items
	 */
	public static void close(AutoCloseable... items) {
		for (AutoCloseable item : items) {
			if (item != null) {
				try {
					item.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * Pass in a file path to get the data containing each line of the file
	 * @param path
	 * @return  List<String>
	 */
	public static List<String> lines(String path) {
		BufferedReader br = getBufferedReader(path);
		List<String> list = new ArrayList<String>();
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(br);
		}
		return list;
	}

	/**
	 * Create directory in batch
	 * @param file
	 */
	public static void mkdirs(File file) {
		File parentFile = file.getParentFile();
		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}
	}
	
	
	
}
