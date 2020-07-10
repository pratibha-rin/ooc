import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader {
    public static void firstmethod(String inputUrl) throws IOException {
        int rtimeout = 10000;
        int ctimeout = 10000;
        String ext = FilenameUtils.getExtension(inputUrl);
        FileUtils.copyURLToFile(new URL(inputUrl), new File(
                "test1." + ext), ctimeout, rtimeout
        );
    }

    public static void secondmethod(String inputUrl) {
        String ext = FilenameUtils.getExtension(inputUrl);
        try (BufferedInputStream in = new BufferedInputStream(new URL(inputUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("test2." + ext)) {
            byte[] buffer_data = new byte[1024];
            int reader;
            while ((reader = in.read(buffer_data, 0, 1024)) != -1) {
                fileOutputStream.write(buffer_data, 0, reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void thirdmethod(String inputUrl) throws IOException {
        String ext = FilenameUtils.getExtension(inputUrl);
        URL url = new URL(inputUrl);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream("test3." + ext);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
}