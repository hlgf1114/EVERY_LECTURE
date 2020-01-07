package com.goldenbrothers.everylecture.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	// UUID ��ȯ
	public String getUUID() {
		
		
		UUID uid = UUID.randomUUID();
		
		return uid.toString();
	}
	
	public String saveImage(MultipartFile file) {
		
		// ���� �غ�
		String originalFileName = file.getOriginalFilename();
		String uid = getUUID();
		
		// �� �Ǿ����� Ȯ��
		String result = "";
		
		
		try {
			// ���� ����
			byte[] fileContent = file.getBytes();
			
			String path = "";
//			path = ("/everylecture/resources/video/").concat(path);
			path = ("C:/EVERY-LECTURE-FILES").concat(path);
			
			// ���丮 ���� Ȯ�� �� ������ ����
			File uploadDir = new File(path);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			
			// ���� �����̸��� UUID�� ��ȯ �� �߰�
			String fileName = originalFileName
					.substring(originalFileName.lastIndexOf("."), originalFileName.length());
			
			// ����� ���� �̸�
			String convertName = uid + fileName;
			
			// ���� ����
			File f = new File(path.concat("/").concat(convertName));
			OutputStream out = new FileOutputStream(f);
			out.write(fileContent);
			out.close();
			
			// Ȯ�� ����
			result = path.concat("/").concat(convertName);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

}