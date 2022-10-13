package util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileAsStringReader {
	private static final int BUFFER_SIZE = 1024;

    /** 
     * Read a file content to a string variable
     * @param filePath The path of the file
     * @return The file's content
     * @throws IOException
     */
    public static String readFileAsStringx(File filePath) throws IOException {
        return readFileAsString(filePath.getAbsolutePath());
    }

    /**
     * Read a file content to a string variable
     * @param filePath The path of the file
     * @return The file's content
     * @throws IOException
     */
    public static String readFileAsString(String filePath) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream is = new BufferedInputStream(new FileInputStream(filePath));
        byte[] buf = new byte[BUFFER_SIZE];
        int numOfBytes = is.read(buf);
        while (numOfBytes != -1) {
            baos.write(buf, 0, numOfBytes);
            numOfBytes = is.read(buf);
        }
        is.close();
        return new String(baos.toByteArray(), "UTF-8");
    }

}
