package xyz.neolith.javalearning.designmode.adapterpattern;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/**
 * 适配器模式
 * Audio player 真能够播放 mp3, 但是 advancedMedia player 可以播放多种格式
 * 于是使用适配器模式 使得 Audio player 可以播放多种格式
 *
 * Arrays.asList 就是使用适配器模式
 * Returns a fixed-size list backed by the specified array.  (Changes to
 * the returned list "write through" to the array.)  This method acts
 * as bridge between array-based and collection-based APIs, in
 * combination with {@link Collection#toArray}.  The returned list is
 * serializable and implements {@link RandomAccess}.
 *
 * <p>This method also provides a convenient way to create a fixed-size
 * list initialized to contain several elements:
 * <pre>
 *     List&lt;String&gt; stooges = Arrays.asList("Larry", "Moe", "Curly");
 * </pre>
 *
 * @param <T> the class of the objects in the array
 * @param a the array by which the list will be backed
 * @return a list view of the specified array
 *
 * @SafeVarargs
 * @SuppressWarnings("varargs")
 * public static <T> List<T> asList(T... a) {
 *        return new ArrayList<>(a);
 * }
 *
 * @author sunlggggg
 * @date 2018/3/28
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
        Arrays.asList();
    }
}
