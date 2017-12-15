package entities.media;

/**
 * Created by amour on 24.02.2017.
 */

import java.io.File;
import java.net.URI;

public class LocalDriveDataReader implements DataReader {

    @Override
    public File read(URI uri) {
        return new File(uri);
    }
}
