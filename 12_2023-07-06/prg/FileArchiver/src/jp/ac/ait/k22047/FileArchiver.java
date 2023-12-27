package jp.ac.ait.k22047;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;

public class FileArchiver {
    public static void makeZip (String fileName) {
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(fileName + ".zip"));
            ZipEntry ze = new ZipEntry(fileName);
            zos.putNextEntry(ze);
            FileInputStream fis = new FileInputStream(fileName);
            int len;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            fis.close();
            zos.closeEntry();
            zos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        makeZip("WildFaceCat.jpeg");
    }
}
