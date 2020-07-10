import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputUrl = "https://muic.mahidol.ac.th/eng/wp-content/downloads/catalog/muic_catalog_2017.pdf";
        Downloader.firstmethod(inputUrl);
        Downloader.secondmethod(inputUrl);
        Downloader.thirdmethod(inputUrl);
    }
}