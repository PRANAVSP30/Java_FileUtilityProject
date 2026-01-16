import java.io.*;
import java.util.Scanner;

public class FileUtility{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ FILE UTILITY PROJECT------");
            System.out.println("1.Writing a File");
            System.out.println("2.Reading a File");
            System.out.println("3.Modifying a File");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Writing a File");
                    writeFile();
                    break;
                case 2:
                    System.out.println("Reading a File");
                    readFile();
                    break;
                case 3:
                    System.out.println("Modifying a File");
                    modifyFile();
                    break;
                case 4:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid Choice! try again.");
            }
        }
    }

    public static void writeFile(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name to write:");
        String fileName = sc.nextLine();

        System.out.println("Enter the content to write into the file:");
        String content = sc.nextLine();

        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(content);
            pw.close();
            bw.close();
            fw.close();

            System.out.println("Content written to file successfully.");
        }
        catch (IOException e){
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void readFile(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name to read:");
        String fileName = sc.nextLine();

        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("File content:");
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            br.close();
            fr.close();
        }
        catch (IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void modifyFile(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file name to modify:");
        String fileName = sc.nextLine();

        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            br.close();
            fr.close();
            System.out.println("Current file content:");
            System.out.println(content);

            System.out.println("Enter the new content to append to the file:");
            String newContent = sc.nextLine();

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(newContent);
            pw.close();
            bw.close();
            fw.close();

            System.out.println("File modified successfully.");

        }
        catch (IOException e){
            System.out.println("An error occurred while modifying the file: " + e.getMessage());
        }
    }
}

