package culturemedia.exception;

import java.text.MessageFormat;

public class DuracionNotValidException extends CulturemediaException{
    public DuracionNotValidException(String title, Double duration ) {
        super(MessageFormat.format("No videos found with title {} and duration {}", title,duration));
    }
}
