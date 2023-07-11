package CompressorDecompressor;

import java.io.File;
// Importing the File class from the java.io package
// The File class provides an abstraction for working with files and directories

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compressor {
    public static void method(File file) throws IOException {
        // taking File type as input
        // Perform a specific operation on the provided file or directory

        // Parameter:
        //   file - The file or directory to be processed
        //         It should be an instance of the File class representing a specific file or directory
        //          Pass the file or directory that needs to be processed by the method

        String fileDirectory = file.getParent();
        // Retrieve the parent directory path of the given file
        // Using the getParent() method of the File class to obtain the parent directory path
        // The getParent() method returns a String representing the parent directory of the file
        // The value assigned to the 'fileDirectory' variable is the parent directory path of the provided file

        FileInputStream fis = new FileInputStream(file);
        // Create a FileInputStream to read from the specified file
        // The 'fis' variable is assigned a new instance of FileInputStream,
        // which reads data from the 'file' file object

        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Compressedfile.gz");
        // Create a FileOutputStream to write to the specified file path with a filename
        // The 'fio' variable is assigned a new instance of FileOutputStream,
        // which writes data to the file located at the concatenation of 'fileDirectory' and "/CompressedFile.gz"
        // This creates a new file named "CompressedFile.gz" in the 'fileDirectory' directory,
        // and the 'fio' variable can be used to write data to this file

        GZIPOutputStream gzip = new GZIPOutputStream(fos);

        byte[] buffer = new byte[1024];// keeps input provide in byte form

        int length;

        while((length=fis.read(buffer))!=-1){
            // Continue reading data from the FileInputStream into the buffer array until the end of the stream is reached
            // The 'length' variable is assigned the number of bytes read from the stream
            // The read() method of FileInputStream reads data from the stream into the 'buffer' array,
            // and the 'length' variable holds the number of bytes read during this operation
            // The loop continues as long as the 'length' variable is not equal to -1,
            // which indicates that there is more data to read from the stream

            gzip.write(buffer,0,length);
        }

        gzip.close();
        fis.close();
        fos.close();
    }

    public static void main(String[] args)throws IOException{
        File path=new File("C:\\Users\\maviy\\Downloads/Testfile");
        // Create a File object with a specific file path
        // The 'path' variable is assigned a new instance of the File class, representing a file located
        // at the specified path
        // The provided path is "/Users/shivenduac/Downloads/Compressor/compressordecompressor/Testfile"
        // This creates a File object pointing to the file located at the given path
        // The 'path' variable can now be used to reference and perform operations on the file


        method(path);// call method and passing path of File type as a parameter
    }
}
