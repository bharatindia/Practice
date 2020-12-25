import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/***
 * Input
 * -------------------------------------
 * root, directory, 128, admin, NONE
 * users, directory, 512, admin, root
 * navin, directory, 1024, navin, users
 * navin.jpg, photo, 128000, navin, navin
 * Project.doc, document, 256000, navin, navin
 * Sholay.mpg, video, 4123456123, navin, navin
 * amit, directory, 128, amit, users
 * Resume.doc, document, 256000, amit, amit
 * ---------------------------------------
 *
 * Read the above data from input.txt file and data contains in each line of file as
 * Filename, file type, file permission, owner, parent directory
 * Then find out the user who has maximum number files owned and
 * save the information in output.txt file in below format.
 * ---------------------------------------
 * Output
 * ---------------------------------------
 * navin:4
 */

public class FileOperationMaxOwner{
    public static void main(String argv[]) throws IOException {
        //Array list to store username
        ArrayList<String> usernameList = new ArrayList();
        String fileName = "C:\\Users\\GeekCoder\\Desktop\\input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
            //Spilt line using ',' and get username and add it into username arraylist
            String[] array = line.split(",");
            usernameList.add(array[3]);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        //Create hashmap and put username and its occurrence count into it
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String str : usernameList) {
            if (counts.containsKey(str)) {
                counts.put(str, counts.get(str) + 1);
            } else {
                counts.put(str, 1);
            }
        }
        int max = 0;
        String maxUsername = "";
        //Find the max occurred username from hashmap
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxUsername = entry.getKey();
            }
        }
        // Create a new if not exits and save the expected output in the file
        try {
            String outputFilePath = "C:\\Users\\GeekCoder\\Desktop\\output.txt";
            File myObj = new File(outputFilePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(outputFilePath);
            myWriter.write(maxUsername + ":" + max);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
