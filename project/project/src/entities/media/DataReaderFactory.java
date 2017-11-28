package entities.media;

/**
 * Created by amour on 24.02.2017.
 */
    public class DataReaderFactory{
        public static DataReader getProduct() {
            DataReader dataReader = new LocalDriveDataReader();
            return dataReader;
        }
    }

