package com.vam.task;



import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vam.mapper.AdminMapper;
import com.vam.mapper.ProductMapper;
import com.vam.model.AttachImageVO;

@Component
public class AttachFileCheckTask {
	@Autowired
	private ProductMapper mapper;
	
	
private String getFolderYesterDay() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator);
	}	
	
	@Scheduled(cron="0 * * * * *")
	public void checkFiles() throws Exception{	
		

		// DB�� ����� ���� ����Ʈ
		List<AttachImageVO> fileList = mapper.checkFileList();		
		
		
		// �� ���� ���� ����Ʈ(Path��ü)
		List<Path> checkFilePath = new ArrayList<Path>();
			//���� �̹���
		fileList.forEach(vo -> {
			Path path = Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName());
			checkFilePath.add(path);
		});		
			//����� �̹���
		fileList.forEach(vo -> {
			Path path = Paths.get("C:\\upload", vo.getUploadPath(), "s_" +  vo.getUuid() + "_" + vo.getFileName());
			checkFilePath.add(path);
		});
		
		
		// ���丮 ���� ����Ʈ
		File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
		File[] targetFile = targetDir.listFiles();
		
		
		// ���� ��� ���� ����Ʈ(�з�)
		List<File> removeFileList = new ArrayList<File>(Arrays.asList(targetFile));		
		for(File file : targetFile){
			checkFilePath.forEach(checkFile ->{
				if(file.toPath().equals(checkFile)) 
					removeFileList.remove(file);	
			});
		}
		
		
		// ���� ��� ���� ����

		for(File file : removeFileList) {

			file.delete();
		}		
	
		
	}
}
