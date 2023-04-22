package src;

import java.io.*;
 
public class FileProgram implements Runnable {

    @Override
    public void run() {
        System.out.println("Running...");
        File f = new File("C:\\Users\\Sivas\\TempFile.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String data = "";
            while ((data = br.readLine()) != null) {
                System.out.println("Reading file information : "+data);
                removeUpperCase(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUpperCase(String data) {
        Thread t = new Thread();
        t.setName("Removing UpperCase Characters");
        t.start();
        String[] tokens = data.split(" ");
        char[] c;
        String str = "";
        for(int i = 0;i<tokens.length;i++) {
            c = tokens[i].toCharArray();
            for (Character d : c) {
                if (Character.isUpperCase(d)) {
                    tokens[i] = tokens[i].replace(d, ' ');
                }
            }
        }
        for(int j = 0;j<tokens.length;j++) {
            System.out.print(" "+tokens[j]
            );
        }
    }

    public static void main(String args[]) {
        FileProgram fp = new FileProgram();
        fp.run();
    }
}

