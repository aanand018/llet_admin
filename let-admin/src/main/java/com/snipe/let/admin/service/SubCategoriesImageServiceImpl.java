package com.snipe.let.admin.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.snipe.let.admin.dao.SubCategoriesImageDAO;
import com.snipe.let.admin.domain.SubCategoriesImageDomain;
import com.snipe.let.admin.exception.LetRestException.EMPTY_FILE;
import com.snipe.let.admin.exception.LetRestException.FILE_UPLOAD_FAILED;
import com.snipe.let.admin.exception.LetRestException.NOT_FOUND;
import com.snipe.let.admin.mapper.SubCategoriesImageMapper;
import com.snipe.let.admin.model.SubCategoriesImageModel;

@Service
public class SubCategoriesImageServiceImpl implements SubCategoriesImageService {
	@Autowired
	SubCategoriesImageDAO subCategoriesImageDAO;

	@Autowired
	SubCategoriesImageMapper subCategoriesImageMapper;

	@Override
	public String addSubCategoriesImage(long subCategoriesId, MultipartFile file) throws Exception {
		if (file.isEmpty())
			throw new EMPTY_FILE("Please select a file to upload");
		SubCategoriesImageDomain subCategoriesImageDomain = new SubCategoriesImageDomain();
		subCategoriesImageDomain.setSubCategoriesId(subCategoriesId);
		// subCategoriesImageDomain.setSubCategoriesImageId(CommonUtils.generateRandomId());
		subCategoriesImageDomain.setName(file.getOriginalFilename());
		subCategoriesImageDomain.setType(file.getContentType());
		subCategoriesImageDomain.setSize(file.getSize());

		final String SUFFIX = "/";
		String folderName = "D:/Pooja/liveStock-ui/newlivestocknoncustomer/src/assets/images";
		String fileName = folderName + SUFFIX + subCategoriesImageDomain.getName();

		uploadFile(fileName, file);
		subCategoriesImageDomain.setPath(fileName);
		return subCategoriesImageDAO.addSubCategoriesImage(subCategoriesImageDomain);
	}

	private void uploadFile(String fileName, MultipartFile file) throws IOException {
		try {
			// AWSCredentials credentials = new
			// BasicAWSCredentials(mmgProperties.getAccessKey(),
			// mmgProperties.getSecretKey());
			// @SuppressWarnings("deprecation")
			// AmazonS3 s3client = new AmazonS3Client(credentials);
			// s3client.setRegion(Region.getRegion(Regions.AP_SOUTH_1));
			// String bucketName = "admin-mmg";
			//
			// ObjectMetadata md = new ObjectMetadata();
			// md.setContentLength(file.getSize());
			// md.setContentType(file.getContentType());
			//
			// InputStream is = file.getInputStream();
			// s3client.putObject(new PutObjectRequest(bucketName, fileName, is, md));
			byte[] bytes = file.getBytes();
			Path path = Paths.get(fileName);
			Files.write(path, bytes);
		} catch (Exception e) {
			throw new FILE_UPLOAD_FAILED();
		}

	}

	@Override
	public SubCategoriesImageModel getSubCategoriesImageById(long subCategoriesId) throws Exception {
		SubCategoriesImageDomain subCategoriesImageDomain = subCategoriesImageDAO.getSubCategoriesImageById(subCategoriesId);
		SubCategoriesImageModel subCategoriesImageModel = new SubCategoriesImageModel();
		if (subCategoriesImageDomain == null)
			throw new NOT_FOUND("SubCategoriesImage not found");
		BeanUtils.copyProperties(subCategoriesImageDomain, subCategoriesImageModel);
		return subCategoriesImageModel;
	}

	@Override
	public List<SubCategoriesImageModel> getSubCategoriesImagesbysubCategoriesId(long subCategoriesId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubCategoriesImageModel> getSubCategoriesImageList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
