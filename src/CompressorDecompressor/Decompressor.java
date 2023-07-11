package CompressorDecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class Decompressor {
    public static void method(File file)throws IOException{
        String fileDirectory=file.getParent();

        FileInputStream fis=new FileInputStream(file);

        GZIPInputStream gzip=new GZIPInputStream(fis);

        FileOutputStream fos=new FileOutputStream(fileDirectory+"/Decompressedfilecheck");

        byte[] buffer=new byte[1024];

        int length;

        while((length=gzip.read(buffer))!=-1) {
            // Continue reading data from the FileInputStream into the buffer array until the end of the stream is reached
            // The 'length' variable is assigned the number of bytes read from the stream
            // The read() method of FileInputStream reads data from the stream into the 'buffer' array,
            // and the 'length' variable holds the number of bytes read during this operation
            // The loop continues as long as the 'length' variable is not equal to -1,
            // which indicates that there is more data to read from the stream
            fos.write(buffer, 0, length);
        }
        gzip.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args)throws IOException{
        File path=new File("C:\\Users\\maviy\\Downloads/Compressedfile.gz");
        // Create a File object with a specific file path
        // The 'path' variable is assigned a new instance of the File class, representing a file located
        // at the specified path
        // The provided path is "/Users/shivenduac/Downloads/Compressor/compressordecompressor/DecompressedFile.gz"
        // This creates a File object pointing to the file located at the given path
        // The 'path' variable can now be used to reference and perform operations on the file


        method(path);// call method and passing path of File type as a parameter
    }
}
