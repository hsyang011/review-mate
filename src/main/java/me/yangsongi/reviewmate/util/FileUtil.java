package me.yangsongi.reviewmate.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUtil {

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/reviews/"; // 파일을 저장할 디렉토리 경로

    // 이미지 업로드 메서드
    public static String upload(MultipartFile image) throws IOException {
        // 파일 이름을 고유하게 생성
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path targetLocation = Paths.get(UPLOAD_DIR + fileName); // 파일을 저장할 경로

        // 업로드된 파일을 지정된 경로로 저장
        Files.copy(image.getInputStream(), targetLocation);

        // 저장된 파일의 URL을 반환
        return "/uploads/reviews/" + fileName; // 예시 URL 반환
    }

    // 저장된 파일을 삭제하는 메서드
    public static void delete(String fileName) throws IOException {
        Path targetLocation = Paths.get(UPLOAD_DIR + fileName);
        Files.deleteIfExists(targetLocation); // 파일이 존재하면 삭제
    }

}
