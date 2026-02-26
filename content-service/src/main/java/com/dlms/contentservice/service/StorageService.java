package com.dlms.contentservice.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dlms.contentservice.model.MinioProperties;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

@Service
public class StorageService {
	
    private final MinioClient client;
  
    private final MinioProperties props;
    
    public StorageService(MinioClient client, MinioProperties props)
       
    {
        this.client = client;
        
        this.props=props;
    }

    public void put(String objectKey, InputStream data, long size, String contentType,String title,String type, String loginId) throws Exception {
        ensureBucket();
        
        Map<String, String> metadata = new HashMap<>();
        metadata.put("title", title);
        metadata.put("type", type);
        metadata.put("teacherLoginID",loginId);

        PutObjectArgs args = PutObjectArgs.builder()
            .bucket(props.getBucket()).object(objectKey)
            .stream(data, size, -1)
            .userMetadata(metadata)  
            .contentType(contentType).build();
        client.putObject(args);
    }

    public GetObjectResponse get(String objectKey) throws Exception {
        ensureBucket();
        return client.getObject(GetObjectArgs.builder().bucket(props.getBucket()).object(objectKey).build());
    }

    private void ensureBucket() throws Exception {
        boolean exists = client.bucketExists(BucketExistsArgs.builder().bucket(props.getBucket()).build());
        if(!exists){
            client.makeBucket(MakeBucketArgs.builder().bucket(props.getBucket()).build());
        }
    }
}
