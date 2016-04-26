package com.qishon.isw.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @Description:文件IO
 * @Author:li.lin
 * @Time:2016-04-12 19:26:13
 */
public class FileIO {
	/*
	 * @Description:创建文件
	 * @Param:无
	 * @Return:fe 文件对象
	 * @Author:li.lin
	 * @Time:2016-04-12 19:27:32
	 * @Update History:无
	 */
	public static File createFile(String FileName){
		String dir = "e:/Temp";
		File fe = new File(dir,FileName);
		try {
			fe.createNewFile();
		} catch (IOException e){
			e.printStackTrace();
		}
		return fe;
	}
	
	/*
	 * @Description:写文件
	 * @Param:str 写入的字符串
	 *        fe  文件对象
	 * @Return:无
	 * @Author:li.lin
	 * @Time:2016-04-12 19:28:56
	 * @Update History:无
	 */
	public void writeFile(String str,File fe){
		byte bt[] = new byte[1024];
		bt = str.getBytes();
		try {
			FileOutputStream fts = new FileOutputStream(fe);
			try {
				fts.write(bt, 0, bt.length);
				fts.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * @Description:读取文件
	 * @Param:path 文件路径
	 * @Return:sb.toString() 读取的字符串
	 * @Author:li.lin
	 * @Time:2016-04-12 19:29:46
	 * @Update History:无
	 */
	public String readFile(String path) throws IOException{
		File fe = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fe);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] buf = new byte[1024];
		StringBuffer sb = new StringBuffer(); 
		while ((fis.read(buf)) != -1){
			sb.append(new String(buf));
			buf = new byte[1024];
			}
		return sb.toString();
	}
}
