package jp.sample.java.args4j;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * コマンドライン引数処理(Args4j)
 * 
 */
public class Args4jSample {
    /**
     * リピート回数(デフォルト:3)
     */
    @Option(name = "-c", metaVar = "NUM", usage = "count number")
    static int count = 3;

    /**
     * デバッグオプション
     */
    @Option(name = "-d", usage = "debug options")
    static boolean isDebug;

    /**
     * 繰り返す文字列(名前)
     */
    @Option(name = "-n", usage = "user name", metaVar = "NAME", required = true)
    static String name;

    /**
     * 実行本体
     */
    private void exec() {
        for (int i = 0; i < count; i++) {
            System.out.println(name);
        }
        if (isDebug) {
            System.out.println("Debug mode");
        }
    }

    /**
     * メイン関数
     */
    public static void main(String[] args) {
        Args4jSample app = new Args4jSample();
        CmdLineParser parser = new CmdLineParser(app);
        app.exec();
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
