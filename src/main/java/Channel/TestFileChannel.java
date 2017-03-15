package Channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by bacon on 2017/3/15.
 */
public class TestFileChannel {

    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("G:\\大三下\\Message Systems\\nio\\src\\main\\java\\data\\nio-filechannel-data.txt","rw");
        FileChannel fileInChannel = accessFile.getChannel();

        //allocate the buffer with the capacity as 48
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        //channel read into buffer
        int bytesRead = fileInChannel.read(byteBuffer);
        while (bytesRead != -1){
            System.out.println("Read :" + bytesRead);

            //buffer反转，从写模式切换到读模式
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            System.out.print("\n");

            byteBuffer.clear();
            bytesRead = fileInChannel.read(byteBuffer);
        }
        accessFile.close();
    }
}
