package utilities;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BrowserDialogs {

	/**
	 * Chooses the folder which is examined via a simple folder browser Dialog
	 * 
	 * @param Does
	 *            not need any to begin with.
	 * @return: string for folder path
	 */
	// TODO: search zip file

	public static String chooseFolder() throws FileNotFoundException {
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		j.showOpenDialog(j);
		if (j.getSelectedFile() == null) {
			JOptionPane.showMessageDialog(null, "No folder was chosen", "Info Message", JOptionPane.PLAIN_MESSAGE);
			return null;
		} else {
			String folder = j.getSelectedFile().getPath();
			return folder;
		}
	}

	/**
	 * Chooses the file which is examined via a simple folder browser Dialog
	 *
	 * @param Does
	 *            not need any to begin with.
	 * @return: string for file path
	 */
	public static String chooseFile() throws FileNotFoundException {
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.FILES_ONLY);
		j.showOpenDialog(j);
		if (j.getSelectedFile() == null) {
			JOptionPane.showMessageDialog(null, "No file was chosen");
		} else {
			String file = j.getSelectedFile().getPath();
			return file;
		}
		return null;
	}

	public static String chooseFileOrFolder() throws FileNotFoundException {
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		j.showOpenDialog(j);
		if (j.getSelectedFile() == null) {
			JOptionPane.showMessageDialog(null, "No file or folder was chosen", "Info Message", JOptionPane.PLAIN_MESSAGE);
			return null;
		} else {
			String folder = j.getSelectedFile().getPath();
			return folder;
		}
	}

}