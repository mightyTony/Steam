package tony.project.steam.configuration.s3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

// TODO 나중에 구현 지금은 의미없음
@Component
@Slf4j
@RequiredArgsConstructor
public class S3Uploader {

    private final S3Presigner s3Presigner;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
}
