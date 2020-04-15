package com.qiusuo.springboottutorial.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
public class ZipFileController {

    @RequestMapping(value = "/zip", produces="application/zip")
    public @ResponseBody byte[] getZipedFileContent() throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

        final String zipName = "COA_Images";

        ZipEntry entry = new ZipEntry(zipName);
        zipOutputStream.putNextEntry(entry);


        String content = "Example String";
        byte[] byteContent = content.getBytes();

        zipOutputStream.write(byteContent, 0, byteContent.length);


        zipOutputStream.closeEntry();
        zipOutputStream.close();
        zipOutputStream.flush();

        return outputStream.toByteArray();
    }

}
