package com.briup.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Properties;

import com.briup.util.BIDR;
import com.briup.util.BackUP;

/**
 * 备份模块
 */
public class BackUpImpl implements BackUP {
	private static String backFile = null;

	@Override
	public void init(Properties prop) {
		backFile = prop.getProperty("back-temp");
	}

	// 读取，参数一：IP；参数二：判断是否读取
	@Override
	public Object load(String str, boolean flag) throws Exception {
		if (flag) {
			@SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					backFile));
			@SuppressWarnings("unchecked")
			Map<String, BIDR> map = (Map<String, BIDR>) ois.readObject();
			for (String key : map.keySet()) {
				if (key.equals(str)) {
					return map.get(key);
				}
			}
		}
		return null;
	}

	// 存储,参数一：描述信息；参数二：需要备份的对象；参数三：如果数据已存在，设置是追加还是覆盖
	@Override
	public void store(String str, Object map, boolean flag) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				backFile + str, flag));
		oos.writeObject(map);
		oos.flush();
		oos.close();
	}

}
