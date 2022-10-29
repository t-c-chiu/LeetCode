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
			root = new File("/", true);
		}
		
		public List<String> ls(String path) {
			String[] split = path.split("/");
			File cur = root;
			for (int i = 1; i < split.length; i++) {
				cur = cur.next.get(split[i]);
			}
			if (cur.isDirectory) {
				List<String> list = new ArrayList<>(cur.next.keySet());
				list.sort(Comparator.naturalOrder());
				return list;
			}
			return Collections.singletonList(cur.name);
		}
		
		public void mkdir(String path) {
			mkdirWithReturn(path);
		}
		
		public File mkdirWithReturn(String path) {
			File cur = root;
			String[] split = path.split("/");
			for (int i = 1; i < split.length; i++) {
				String name = split[i];
				if (!cur.next.containsKey(name)) {
					cur.next.put(name, new File(name, true));
				}
				cur = cur.next.get(name);
			}
			return cur;
		}
		
		public void addContentToFile(String filePath, String content) {
			int lastSlash = filePath.lastIndexOf('/');
			String fileName = filePath.substring(lastSlash + 1);
			File dir = mkdirWithReturn(filePath.substring(0, lastSlash));
			dir.next.putIfAbsent(fileName, new File(fileName, false));
			dir.next.get(fileName).content += content;
		}
		
		public String readContentFromFile(String filePath) {
			int lastSlash = filePath.lastIndexOf('/');
			String fileName = filePath.substring(lastSlash + 1);
			File dir = mkdirWithReturn(filePath.substring(0, lastSlash));
			return dir.next.get(fileName).content;
		}
		
		class File {
			String name;
			String content;
			boolean isDirectory;
			Map<String, File> next;
			
			File(String name, boolean isDirectory) {
				this.name = name;
				this.content = "";
				this.isDirectory = isDirectory;
				next = new HashMap<>();
			}
		}
	}
}
