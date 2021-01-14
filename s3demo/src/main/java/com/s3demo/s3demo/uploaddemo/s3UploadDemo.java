package com.s3demo.s3demo.uploaddemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@RestController
public class s3UploadDemo {

	@Autowired
	private AmazonS3 s3Client;

	private String bucketName = "s2demobucket";

	@PostMapping(value = "/upload/file")
	public String uploadFile(@RequestParam(name = "file") MultipartFile file) throws IOException {

		// converting multipartFile into file Type object

		File modifiedFile = new File(file.getOriginalFilename());
		FileOutputStream os = new FileOutputStream(modifiedFile);
		os.write(file.getBytes());

		// generating unique fileName
		String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

		// logic to upload file to s3 bucket
		s3Client.putObject(bucketName, fileName, modifiedFile);

		// delete the file
		 modifiedFile.delete();
		return "file uploaded successfully in s3Bucket " + fileName;
	}

	@GetMapping("/file/download")
	public ResponseEntity<ByteArrayResource> downloadFileFromS3(@RequestParam(name = "file") String fileName)
			throws IOException {
		com.amazonaws.services.s3.model.S3Object s3Object = s3Client.getObject(bucketName, fileName);

		S3ObjectInputStream objectContent = s3Object.getObjectContent();

		byte[] byteArray = IOUtils.toByteArray(objectContent);

		// to download the file

		ByteArrayResource resource = new ByteArrayResource(byteArray);

		return ResponseEntity.ok()
				.contentLength(byteArray.length)
				.header("content-type", "application/octet-stream")
				.header("content-disposition", "attachment;fileName=\"" + fileName +"\"")
				.body(resource);

	}

	@DeleteMapping("/delete/File")
	public String deleteFileFromS3(@RequestParam(name = "file") String fileName) {
		s3Client.deleteObject(bucketName, fileName);
		return "file deleted successfully" + fileName;
	}
}
