import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MDAExtract_FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println(" Please enter input files path - ");
		String inputpath = input.next();
		System.out.println(" Please enter output files path -");
		String outputpath = input.next();
		
		File folder = new File(inputpath);
		File[] listOfFiles = folder.listFiles(); //Reading all files in folder
		List<Integer> indexval = new ArrayList<>();
		List<String> notProcessed = new ArrayList<>();
		int count = 0;
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
		String filename = "";
		BufferedReader br;
		StringBuffer data = new StringBuffer();

		for (File file : listOfFiles) {
			System.out.println("Processing file - " + file.toString());
			count = 0;
			filename = file.toString();
			
			try  {
				FileInputStream fs= new FileInputStream(file);
				br = new BufferedReader(new InputStreamReader(fs));
				data.append(br.readLine()); //Reading data from each file
				
				for (int index = data.indexOf("Item 7");index >= 0;index = data.indexOf("Item 7", index+1))  //Identifying the indexes of Item 7
					{
					indexval.add(index);
					}
				count = indexval.get(2); //Taking 3rd occurance of word Item 7
				sb1.append(data.substring(count));
				sb.append(sb1.substring(0,sb1.indexOf("°")-1));  //Reading data from 3rd occurance of Item 7 to next degree
							
			//Below code is writing data to output file
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(outputpath+filename.substring(filename.lastIndexOf('\\'), filename.lastIndexOf('.'))+"_mda.txt")));
			bwr.write(sb.toString());
			
			//Clearing all buffers
			bwr.flush();
			bwr.close();
			data.setLength(0);
			indexval.clear();
			sb.setLength(0);
			sb1.setLength(0);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				notProcessed.add(filename);
			}
		}
		System.out.println("Below files are not processed ::");
		notProcessed.forEach((k)->{
			System.out.println( k );
		});
	}
}
