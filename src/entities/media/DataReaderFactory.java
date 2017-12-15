package entities.media;

/**
 * Created by amour on 24.02.2017.
 */
    public class DataReaderFactory{
        public static DataReader getProduct() {
            return new LocalDriveDataReader();
        }
    }

