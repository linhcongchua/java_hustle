package java_core.io;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;


public class WriteFile {
    public static void main(String[] args) throws Exception {
        final String filelog = "C:\\Users\\Havey Hoang\\Documents\\log-stuff\\production\\fty\\gpl-fty-m3-integration.2024-11-21.0.log";
        final String fileExtractLog = "C:\\Users\\Havey Hoang\\Documents\\log-stuff\\production\\fty\\log-extract-report-delivery.txt";
        boolean isNeedCopy = false;
        final File input = new File(filelog);
        final File output = new File(fileExtractLog);

        try (InputStream inputStream = new FileInputStream(input);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             RandomAccessFile stream = new RandomAccessFile(output, "rw");
             FileChannel channel = stream.getChannel()
        ) {
            FileLock lock = null;
            try {
                lock = channel.tryLock();
            } catch (final OverlappingFileLockException e) {
                stream.close();
                channel.close();
            }

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("[LinhDV-report-delivery-1]")) {
                    isNeedCopy = !isNeedCopy;
                    stream.writeBytes(line);
                    stream.writeBytes("\n");
                    continue;
                }
                if (isNeedCopy) {
                    stream.writeBytes(line);
                    stream.writeBytes("\n");
                }
            }
        }

        System.out.println("Extract Log successfully!");
    }
}
