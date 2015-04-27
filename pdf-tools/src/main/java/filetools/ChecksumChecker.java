package filetools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import filetools.executables.CdRom_IsoImageChecker;

public class ChecksumChecker {
	
	
	//needed for CD ROM Workflow, filetools.executables.CdRom_IsoImageChecker

	/**
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 *             Checks known MD5 checksums for Adobe Acrobat Software to
	 *             ignore the file if checksum indicates that file is e. g.
	 *             Acrobat Reader SW.
	 * 
	 * @param File
	 * @return: boolean
	 * @throws
	 */
	
	public static void main(String args[]) throws Exception {
		
				
		String examinedFolder = utilities.BrowserDialogs.chooseFolder();		 
		ArrayList<File> files = utilities.ListsFiles.getPaths(new File(examinedFolder), new ArrayList<File>());
		
		for (int i = 0; i < files.size(); i++) {
			String checksum = DigestUtils.md5Hex(new FileInputStream(files.get(i)));
			System.out.println(files.get(i).toString() + " : " +  checksum);
			
		}

	
	}

	public static boolean testIfChecksumisPdfReaderSoftware(File file) throws NoSuchAlgorithmException, IOException {
		ArrayList<String> checksumlist = new ArrayList<String>();
		
		//this list should be added by all the MD5 checksums of the Adobe Software on our CD ROMs, but I doubt it will ever be really big
		checksumlist.add("bb7c1d820e2a2db263655a799590caab");

		// creates MD5 checksum
		String checksum = null;
		try {
			checksum = DigestUtils.md5Hex(new FileInputStream(file));
			CdRom_IsoImageChecker.outputfile.println("MD5 Checksumme: " + checksum);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e + file.toString(), "error message", JOptionPane.ERROR_MESSAGE);
		}

		if (checksumlist.contains(checksum)) {
			return true;
		} else {
			return false;
		}
	}

}
