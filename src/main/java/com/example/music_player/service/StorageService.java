package com.example.music_player.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageService {

    private final AmazonS3 storage;

    @Value("${storage.bucket-name}")
    private String bucketName;

    @Value("${storage.region}")
    private String region;

    @Autowired
    public StorageService(
            @Value("${aws.access-key}") String accessKey,
            @Value("${aws.secret-key}") String secretKey,
            @Value("${storage.endpoint}") String endpoint
    ) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        storage = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                endpoint, region
                        )
                )
                .build();
    }

    public List<String> getSongFileNames() {
        List<String> filenames = storage
                .listObjectsV2(bucketName)
                .getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey).collect(Collectors.toList());

        return filenames;
    }

    public void uploadSong(MultipartFile file) {
        // ...
    }
}
