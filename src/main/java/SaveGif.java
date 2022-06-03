import java.io.*;
import java.net.URL;

public class SaveGif {

    public SaveGif(String readerUrl) throws IOException {

        URL url = new URL(readerUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;

        while (-1 != (n = in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Eg\\Desktop//borrowed_image.webp");//поменять пользователя
        fos.write(response);
        fos.close();
    }
}