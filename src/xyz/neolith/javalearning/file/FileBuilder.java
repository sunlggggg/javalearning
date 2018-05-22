package xyz.neolith.javalearning.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author sunligang
 * @date 2018/05/21
 */
public class FileBuilder {

    private static final int FILE_SIZE = 1024;
    private static final String PATH = "/Users/sunligang/Documents/";
    private static final String FILENAME = "100M.xls";
    private static final  int BEI_SHU = 1024*100;

    public void CreateBigFile() {


        byte[] memFile = new byte[FILE_SIZE];
        for (int i = 0; i < FILE_SIZE; i++) {
            memFile[i] = (byte) (i % 20);
        }


        RandomAccessFile randomFile;
        try {
            File file = new File(PATH + FILENAME);
            file.createNewFile();
            randomFile = new RandomAccessFile(PATH + FILENAME, "rw");


            for (int i = 0; i < BEI_SHU; i++) {
                long fileLength = randomFile.length();
                randomFile.seek(fileLength);
                randomFile.write(memFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileBuilder().CreateBigFile();
    }

}
