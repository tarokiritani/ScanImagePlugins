import ij.*;
import ij.gui.GenericDialog;
import ij.plugin.*;
import ij.plugin.frame.*;

public class Scanimage_To_Imagej implements PlugIn {

	public void run(String arg) {
		ImagePlus imp = IJ.openImage();
		HyperStackConverter hsc = new HyperStackConverter();
		int nSlice = imp.getStack().getSize();
		GenericDialog gd = new GenericDialog("Set Channel Number");
		gd.addNumericField("channel number: ", 2, 0);
		gd.showDialog();
		int chNum = (int)gd.getNextNumber();
		ImagePlus impHyper = hsc.toHyperStack(imp, chNum, nSlice/chNum, 1);
		impHyper.show();
	}
}