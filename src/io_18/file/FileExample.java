package io_18.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws Exception {
        File dir = new File("../");
        File file1 = new File("../console/system_in/readme.md");
        File file2 = new File("../console/system_in/SystemInExample1.java");
        File file3 = new File("../console/system_in/SystemInExample2.java");

        if(dir.exists() == false) { dir.mkdirs(); }
        if(file1.exists() == false) { file1.createNewFile(); }
        if(file2.exists() == false) { file2.createNewFile(); }
        if(file3.exists() == false) { file3.createNewFile(); }

        File temp = new File("../");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd    a    HH:mm");
        File[] contents = temp.listFiles();
        System.out.println("날짜              시간         형태       크기    이름");
        System.out.println("-------------------------------------------------------------------");
        for(File file : contents) {
            System.out.print(simpleDateFormat.format(new Date(file.lastModified())));
            if(file.isDirectory()) {
                System.out.print("\t<DIR>\t\t\t" + file.getName());
            } else {
                System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
            }
            System.out.println();
        }

    }
}
