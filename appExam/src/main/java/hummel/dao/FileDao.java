package hummel.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public interface FileDao {
	File getFile(String filePath);
	FileInputStream getFileInputStream(String filePath) throws FileNotFoundException;
}
