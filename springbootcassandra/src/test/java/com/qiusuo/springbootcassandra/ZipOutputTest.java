package com.qiusuo.springbootcassandra;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

public class ZipOutputTest {

    @Test
    public  void zipOutputTest() throws Exception {
        // create a zip file, and read it in as a byte array
        Path path = Files.createTempFile("bad", ".zip");
        try (OutputStream os = Files.newOutputStream(path);
             ZipOutputStream zos = new ZipOutputStream(os)) {
            ZipEntry e = new ZipEntry("x");
            zos.putNextEntry(e);
            zos.write((int) 'x');
        }
        int len = (int) Files.size(path);
        byte[] data = new byte[len];
        try (InputStream is = Files.newInputStream(path)) {
            is.read(data);
        }
        Files.delete(path);
    }


    @Test
    public void downloadZipFile() throws InterruptedException{
            try {
                final HttpClient httpClient = HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_2)
                        .build();

                HttpRequest.Builder builder = HttpRequest.newBuilder();
                builder.GET();
                builder.uri(URI.create("http://localhost:8080/zip"));


                HttpRequest request = builder
                        .build();

                HttpResponse<byte[]> response =
                        httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

                int statusCode = response.statusCode();


                System.out.println("Request Url: " + request.uri());
                System.out.println("Response Code: " + statusCode);

                byte[] output = response.body();

                String filePath = "file.zip";
                FileOutputStream fos = new FileOutputStream(new File(filePath));

                fos.write(output);
                fos.close();

                System.out.println("File Download Completed!!!");
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    private void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}
