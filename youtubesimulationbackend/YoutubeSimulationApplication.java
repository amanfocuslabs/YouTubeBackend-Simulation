package com.mpp.youtubesimulationbackend;

import com.mpp.youtubesimulationbackend.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
		FileStorageProperties.class
})
@SpringBootApplication
public class YoutubeSimulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeSimulationApplication.class, args);
	}

}
