package dev.simplesolution.sftp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.simplesolution.sftp.service.FileTransferService;

@Component
public class TestSftpFileTransfer implements CommandLineRunner {

	@Autowired
	private FileTransferService fileTransferService;
	
	private Logger logger = LoggerFactory.getLogger(TestSftpFileTransfer.class);
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("Start download file");
		boolean isDownloaded = fileTransferService.downloadFile("hello.txt", "/home/admiral/hello.txt");
		logger.info("Download result: " + String.valueOf(isDownloaded));
		
		logger.info("Start upload file");
		boolean isUploaded = fileTransferService.uploadFile("/Users/krantipatil/Projects/JAVA/intelij/spring-boot-sftp/hello2.txt", "/home/admiral/readme2.txt");
		logger.info("Upload result: " + String.valueOf(isUploaded));
	}

}
