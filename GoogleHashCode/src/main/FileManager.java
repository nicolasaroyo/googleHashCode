package main;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
	
	//TODO  write read file
	public static List<String> read() {
		Path file = Paths.get("input.txt");
		List<String> ans = null;
		try {
			ans = Files.lines(file).collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ans;
	}

	public static void write(List<String> text){
		Path file = Paths.get("output.txt");
		try {
			Files.write(file, text, Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
