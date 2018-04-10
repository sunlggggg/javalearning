package xyz.neolith.javalearning.designmode.adapterpattern;

/**
 * @author sunlggggg
 * @date 2018/3/28
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
