import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Main {

	
	public static void main(String[] args) {
		
		String sample="minMax.sln" ;
	
		
		String path = "/Users/antonlipchansky/Projects/minMax";
		
		File dir  = new File(path) ;
		
		if (!dir.exists()) {
			System.out.print("Path doesn't exists");
			return;
		}
		
		
		if (!dir.isDirectory()){
			System.out.print("File isn't directory");
			return;
			
		}
		
	
		
		
		
		Set <String> uSearch = new HashSet <String> ();
		Set <String> passed = new HashSet <String> ();
		
		searchForParent (dir, passed ,uSearch, sample);
		
		
		System.out.print(uSearch);
		
		
		
		
		
	}
	
	public static void searchForSample (File dir, Set<String> passed, Set<String>hSet , String sample) {
		
		File [] fileList = dir.listFiles();
		//System.out.println(dir);
		if(dir.getName().equals("Steam")) return;
		if(passed.contains(dir.getAbsolutePath())) return;
		passed.add(dir.getAbsolutePath());
		
		if (fileList !=null) {
				
				for (File file : fileList) {
					
					if (file.isDirectory()) {
						
						searchForSample(file,passed, hSet,sample);
					}
					
					
					if (file.getName ().equals(sample)) {
						
						hSet.add(file.getAbsolutePath());
						
						return;
					}
				}
				
				
		
		}
		
		 
	 }
	
	public static void searchForParent (File dir,Set<String> passed, Set<String> uSearch, String sample) {
		
		
		File fileParent = dir.getParentFile();
		
		
		while(dir.getParentFile()!=null) {
			int k = 0;
			k++;
			
			
			searchForSample(dir,passed, uSearch, sample);
			
			dir = dir.getParentFile();
			
			
				
		}
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}