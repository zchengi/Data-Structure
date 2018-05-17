package utils;

/**
 * @author cheng
 *         2018/5/17 13:53
 */
public interface UF {

    void unionElements(int p, int q);

    boolean isConnected(int p, int q);

    int getSize();
}
