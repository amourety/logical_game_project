package entities.media;

/**
 * Created by amour on 24.02.2017.
 */

import java.io.File;
import java.net.URI;

public interface DataReader {
    File read(URI uri);
}
