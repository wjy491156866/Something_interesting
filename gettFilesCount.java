package csvtest;

import java.io.File;    //先导包

public class gettFilesCount {
    static int count = 0;   // 初始化统计变量
    
    public static void main(String[] args) {
        File file = new File("F:\\AGI\\test");   // 需要查找的文件目录
        System.out.println(getTxtFilesCount(file)); //调用方法
    }
    
    
    /*
    * 方法名：getTxtFilesCount
    * 作用：统计.csv文件个数
    */
    public static int getTxtFilesCount(File srcFile){
        // 判断传入的文件是不是为空
        if (srcFile == null) {
            throw new NullPointerException();
        }
        // 把所有目录、文件放入数组
        File[] files = srcFile.listFiles();
        // 遍历数组每一个元素
        for (File f : files) {
            // 判断元素是不是文件夹，是文件夹就重复调用此方法（递归）
            if (f.isDirectory()) {
                getTxtFilesCount(f);
            }else {
                // 判断文件是不是以.txt结尾的文件，并且count++（注意：文件要显示扩展名）
                if (f.getName().endsWith(".csv")) {
                    count++;
                }
            }
        }
        // 返回.txt文件个数
        return count;
    }
}
