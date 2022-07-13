package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignInMemoryFileSystem {
	
	public static void main(String[] args) {
		FileSystem fileSystem = new FileSystem();
		List<String> list = fileSystem.ls("/");                         // return []
		System.out.println(list);
		fileSystem.mkdir("/a/b/c");
		fileSystem.addContentToFile("/a/b/c/d", "hello");
		list = fileSystem.ls("/");                         // return ["a"]
		System.out.println(list);
		String content = fileSystem.readContentFromFile("/a/b/c/d"); // return "hello"
		System.out.println(content);
	}
	
	static class FileSystem {
		
		File root;
		
		public FileSystem() {
			root = new File("/");
		}
		
		public List<String> ls(String path) {
			File cur = root;
			String[] files = path.split("/");
			for (int i = 1; i < files.length; i++) {
				cur = cur.next.get(files[i]);
			}
			List<String> res = new ArrayList<>();
			if (cur.isFile) {
				res.add(cur.name);
			} else {
				res.addAll(cur.next.keySet().stream().sorted().toList());
			}
			return res;
		}
		
		
		public void mkdir(String path) {
			mkdirAndReturn(path);
			
		}
		
		private File mkdirAndReturn(String path) {
			File cur = root;
			String[] files = path.split("/");
			for (int i = 1; i < files.length; i++) {
				String name = files[i];
				cur.next.putIfAbsent(name, new File(name));
				cur = cur.next.get(name);
			}
			return cur;
		}
		
		public void addContentToFile(String filePath, String content) {
			int i = filePath.lastIndexOf("/");
			File dir = mkdirAndReturn(filePath.substring(0, i));
			String fileName = filePath.substring(i + 1);
			File file = dir.next.get(fileName);
			if (file == null) {
				file = new File(fileName);
				dir.next.put(fileName, file);
				file.isFile = true;
			}
			file.content += content;
		}
		
		public String readContentFromFile(String filePath) {
			File cur = root;
			String[] files = filePath.split("/");
			for (int i = 1; i < files.length; i++) {
				cur = cur.next.get(files[i]);
			}
			return cur.content;
		}
		
		class File {
			Map<String, File> next = new HashMap<>();
			String name;
			String content = "";
			boolean isFile;
			
			File(String name) {
				this.name = name;
			}
		}
	}
}
