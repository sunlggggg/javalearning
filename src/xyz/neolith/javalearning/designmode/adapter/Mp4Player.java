package xyz.neolith.javalearning.designmode.adapter;

/**
 * @author sunlggggg
 * @date 2018/3/28
 */
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }


}
