package main;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
	
	//TODO  write read file
	public List<String> read(){
		return null;
		
	
	}

	public void write(List<String> text){
		Path file = Paths.get("output.txt");
		try {
			Files.write(file, text, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
