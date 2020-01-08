package com.goldenbrothers.everylecture.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	// UUID ��ȯ
	public String getUUID() {
		
		
		UUID uid = UUID.randomUUID();
		
		return uid.toString();
	}
	
	public String saveImage(MultipartFile file, HttpServletRequest request) {
		
		// ���� �غ�
		String originalFileName = file.getOriginalFilename();
		String uid = getUUID();
		
		// �� �Ǿ����� Ȯ��
		String result = "";
		
		
		try {
			// ���� ����
			byte[] fileContent = file.getBytes();
			
			String path = "/resources/lecture/";
			String result_path = request.getContextPath().concat(path);
//			path = ("/everylecture/resources/video/").concat(path);
//			path = ("C:/EVERY-LECTURE-FILES").concat(path);
			path = request.getSession().getServletContext().getRealPath(path);
			
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
			result = result_path.concat(convertName);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteImage(String filePath, HttpServletRequest request) {
		
//		String path = "/resources/lecture/";
//		String result_path = request.getContextPath().concat(path);
//		path = request.getSession().getServletContext().getRealPath(path);
		
		// ���� �غ�
		filePath = filePath.substring(filePath.lastIndexOf("/"), filePath.length());
		
		String path = "/resources/lecture/";
		path = request.getSession().getServletContext().getRealPath(path).concat(filePath);
		
		System.out.println(path);
		
		int result = 0;
		
		try {
			
			File file = new File(path);
			
			if(file.delete()) {
				result = 1;
			}
			else {
				result = -1;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return result;
	}

}
