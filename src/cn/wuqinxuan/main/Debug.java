package cn.wuqinxuan.main;

/**
 * Created by lrtwjhs on 2018/6/19.
 */

public class Debug {

    private static boolean DEBUG = true;

    public static void debug(String msg) {
        if (DEBUG) {
            System.out.println(msg);
        }
    }
}
