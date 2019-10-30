package java1030;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class start {
	start(){
		File folder1= new File("D:\\My Data\\test");
		File folder2= new File("D:\\My Data\\test2");
		start.start2(folder1,folder2);
		start.delete(folder1.toString());
	}

	private static void start2(File sourceF, File targetF) {
		// TODO Auto-generated method stub
		File[] target_file=sourceF.listFiles();
		for(File file:target_file) {
			File temp =new File(targetF.getAbsolutePath()+File.separator+file.getName());
			if(file.isDirectory()) {
				temp.mkdir();
				start2(file,temp);
			}
			else {
				FileInputStream fis=null;
				FileOutputStream fos=null;
				try {
					fis = new FileInputStream(file);
					fos = new FileOutputStream(temp);
					byte[]b=new byte[400];
					int cnt=0;
					while((cnt=fis.read(b))!=-1) {
						fos.write(b,0,cnt);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					try {
						fis.close();
						fos.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
	}
	public static void delete(String path) {
		File folder= new File(path);
		try {
			if(folder.exists()) {
				File[] folder_list=folder.listFiles();
				
			for(int i =0;i<folder_list.length;i++) {
					if(folder_list[i].isFile()) {
						folder_list[i].delete();
					}
					else {
						delete(folder_list[i].getPath());
					}
					folder_list[i].delete();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
