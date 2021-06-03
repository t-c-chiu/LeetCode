package hard;

import java.util.*;
import java.util.stream.Collectors;

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
			root = new File(true);
		}
		
		public List<String> ls(String path) {
			String[] dirs = path.split("/");
			File cur = root;
			for (int i = 1; i < dirs.length; i++) {
				Map<String, File> children = cur.children;
				cur = children.get(dirs[i]);
			}
			return cur.isDir ? cur.children.keySet().stream().sorted().collect(Collectors.toList())
					: Collections.singletonList(cur.name);
		}
		
		public void mkdir(String path) {
			mkdirAndReturn(path);
		}
		
		public File mkdirAndReturn(String path) {
			String[] dirs = path.split("/");
			File cur = root;
			for (int i = 1; i < dirs.length; i++) {
				String name = dirs[i];
				Map<String, File> children = cur.children;
				File dir = children.get(name);
				if (dir == null) {
					dir = new File(true);
					dir.name = name;
					children.put(name, dir);
				}
				cur = dir;
			}
			return cur;
		}
		
		public void addContentToFile(String filePath, String content) {
			int lastSlash = filePath.lastIndexOf("/");
			File dir = mkdirAndReturn(filePath.substring(0, lastSlash));
			String fileName = filePath.substring(lastSlash + 1);
			File file = dir.children.get(fileName);
			if (file == null) {
				file = new File(false);
				file.name = fileName;
				dir.children.put(fileName, file);
			}
			file.content += content;
		}
		
		public String readContentFromFile(String filePath) {
			String[] files = filePath.split("/");
			File cur = root;
			for (int i = 1; i < files.length; i++) {
				cur = cur.children.get(files[i]);
			}
			return cur.content;
		}
		
		class File {
			boolean isDir;
			String name;
			String content;
			Map<String, File> children;
			
			File(boolean isDir) {
				this.isDir = isDir;
				content = "";
				children = new HashMap<>();
			}
		}
	}
}
