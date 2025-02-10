package com.travel.travelog_server;

import com.travel.travelog_server.util.FileUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class TravelogServerApplication {

	@Value(("${file.upload.path}"))
	String filePath;

	public static void main(String[] args) {
		SpringApplication.run(TravelogServerApplication.class, args);
	}

	@PostConstruct
	public void init() {
		File directory = new File(filePath);
		if(!directory.exists()) {
			directory.mkdirs();
		}

		FileUtils.setFilePath(filePath);
	}
}
