package util;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by bao on 2017/7/20.
 */
public class FileTool {
    public static String readLine(String fileName) throws Exception{
        return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
    }

    /** readLine("xx.txt").split("[\\P{L}]+");*/
    public static List<String> readLines(String fileName) throws Exception{
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        return lines;
    }
}
