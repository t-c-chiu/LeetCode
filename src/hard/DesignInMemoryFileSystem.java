package hard;

import java.util.*;

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
			root = new File("", true);
		}
		
		public List<String> ls(String path) {
			File file = mkdirAndReturn(path);
			List<String> res = new ArrayList<>();
			if (file.isDir) {
				res.addAll(file.map.keySet());
				res.sort(Comparator.naturalOrder());
			} else {
				res.add(file.name);
			}
			return res;
		}
		
		public void mkdir(String path) {
			mkdirAndReturn(path);
		}
		
		private File mkdirAndReturn(String path) {
			String[] split = path.split("/");
			File cur = root;
			for (int i = 1; i < split.length; i++) {
				String name = split[i];
				if (!cur.map.containsKey(name)) {
					cur.map.put(name, new File(name, true));
				}
				cur = cur.map.get(name);
			}
			return cur;
		}
		
		public void addContentToFile(String filePath, String content) {
			int i = filePath.lastIndexOf("/");
			String dirPath = filePath.substring(0, i);
			String fileName = filePath.substring(i + 1);
			File dir = mkdirAndReturn(dirPath);
			if (!dir.map.containsKey(fileName)) {
				dir.map.put(fileName, new File(fileName, false));
			}
			dir.map.get(fileName).content += content;
		}
		
		public String readContentFromFile(String filePath) {
			File file = mkdirAndReturn(filePath);
			return file.content;
		}
		
		class File {
			boolean isDir;
			String name;
			String content;
			Map<String, File> map;
			
			File(String name, boolean isDir) {
				this.name = name;
				this.isDir = isDir;
				content = "";
				map = new HashMap<>();
			}
		}
	}
	
}
