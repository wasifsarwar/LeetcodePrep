import java.util.Map;
import java.util.HashMap;

public class TinyURLEncodeDecode {
    private final Map<Integer, String> map;

    public TinyURLEncodeDecode() {
        this.map = new HashMap<Integer, String>();
    }

    public String shortenedURL(String longURL) {
        int hashCode = longURL.hashCode();
        map.put(hashCode, longURL);
        return "https://tinyurl.com/" + hashCode;
    }

    public String url(String shortURL) {
        int hashCode = Integer.parseInt(shortURL.replace("https://tinyurl.com/", ""));
        return map.get(hashCode);
    }

    public static void main(String[] args) {
        TinyURLEncodeDecode encodeDecode = new TinyURLEncodeDecode();
        String github = "www.github.com/wasifsarwar";
        System.out.println("tinyURL: " + encodeDecode.shortenedURL(github));
        String tinyURL = encodeDecode.shortenedURL(github);
        System.out.println("actualURL: " + encodeDecode.url(tinyURL));
    }
}
