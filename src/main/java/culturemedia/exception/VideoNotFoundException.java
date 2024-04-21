package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CulturemediaException{
    public VideoNotFoundException(String title) {
        super(MessageFormat.format("Invalid title for de video {}", title));
    }

    public VideoNotFoundException() {
        super("Videos not found ");
    }
}
