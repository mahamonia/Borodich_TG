package test;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.StreamPrintService;
import javax.print.StreamPrintServiceFactory;
import javax.print.attribute.Attribute;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintJobAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.MediaName;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrinterName;
import javax.print.attribute.standard.Sides;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.FontManager;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDInlinedImage;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

public class PrintToZebra {
	public static void main(String[] args) throws IOException {
		System.out.println("Готовлю к печати");

		try {
			//printinpdf();
			print();
			//printzebrapdf();
			/* Socket clientSocket = new Socket("192.168.1.50", 9100);
	           DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	           outToServer.writeBytes("^XA^FO100,40^BY3^B3,,30^FD123ABC^XZ");
	           clientSocket.close();*/

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Отправил на печать");

	}

	public static void printinpdf() throws PrintException, IOException {
		OutputStream fin=new FileOutputStream(PrintToZebra.class.getResource("doc").getPath());
		PrintWriter writer = new PrintWriter(fin, true);
		String ZPLString =
				  "^XA"
				+ "^BY2"
				+ "^FO0,200"
				+ "^FB632,2,0,C,0"
				+ "^ASN,60,60"
				+ "^FDHELLO HABRAHABR!!!^FS" + "^XZ";
		writer.println(ZPLString);
		writer.flush();


	}

	public static void print() throws PrintException, IOException, COSVisitorException{
		InputStream is = null;

			DocFlavor docFlavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
			MediaSizeName mediaSizeName = MediaSize.findMedia(3, 2, MediaPrintableArea.INCH);
			//System.out.println(MediaSizeName.ISO_A5);
			aset.add(MediaSizeName.ISO_A5);
			PrintServiceAttributeSet printAttr = new HashPrintServiceAttributeSet();
			printAttr.add(new PrinterName("Zebra-Technologies-ZTC-ZT220-200dpi-ZPL", null));
			//printAttr.add(new PrinterName("Canon-MF4800-UFRII-LT", null));

			// PrintService printService =
			// PrintServiceLookup.lookupDefaultPrintService();

			PrintService[] printServices = PrintServiceLookup.lookupPrintServices(docFlavor, printAttr);
			PrintService printService = printServices[0];
			for (PrintService pr : printServices) {
				//System.out.println(pr.getName());
			}
			DocPrintJob job = printService.createPrintJob();

			//out = new FileInputStream(PrintToZebra.class.getResource("imgpsh_fullsize.jpeg").getPath());

			String s ="! U1 setvar \"device.languages\" \"zpl\"\r\n ^XA^BY2^FO0,200^FB632,2,0,C,0^ASN,60,60^FDHELLO HABRAHABR!!!^FS^XZ";
/*
			is = new ByteArrayInputStream( ZPLString.getBytes() );
			//System.out.println(ZPLString.getBytes());
			byte[] by = ZPLString.getBytes();*/
			/*String s =  "R0,0\n" +   // Set Reference Point
	                "N\n" +         // Clear Image Buffer
	                "ZB\n" + // Print direction (from Bottom of buffer)
	                "Q122,16\n" +  // Set label Length and gap
	                "A160,2,0,3,1,1,N,\"DATA: " + "DATA" + " - CARUGATE\"\n" +
	                "B160,30,0,1A,2,7,50,N,\"612041600021580109\"\n" +
	                "A160,92,0,1,1,1,N,\"AIA AGRICOLA IT.ALIMENT.S - 594679/VR                       \"\n" +
	                "P1\n";   // Print content of buffer, 1 label
*/
	    byte[] by = s.getBytes();

			DocAttributeSet docAttr = new HashDocAttributeSet();
			//docAttr.add(MediaSizeName.ISO_A9);

			Doc doc = new SimpleDoc(by, docFlavor, null);
			//byte [] b = (byte[])doc.getPrintData();
			//for (byte c : b) {
				//System.out.print(c);
			//}
			//System.out.println();

			//job.print(doc, aset);

			//is.close();

	}

















	public static void printzebrapdf() throws IOException, COSVisitorException{

		PDDocument docementPdf = new PDDocument();
		PDPage page = new PDPage();
		docementPdf.addPage(page);

		PDPageContentStream contentStream = new PDPageContentStream(docementPdf, page);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
		//contentStream.addLine(10, 10, 20, 20);
		contentStream.drawString("Hellow java pdf");
		contentStream.endText();
		contentStream.close();
		//docementPdf.addPage(page);
		//OutputStream  output = new FileOutputStream(PrintToZebra.class.getResource("SamplePDF.pdf").getPath());
		//output.write(by);
		//output.flush();
		docementPdf.save("newPDF.pdf");
		System.out.println(docementPdf);
		docementPdf.close();


		// These are values we'll set from the command-line arguments
	    boolean query = false;
	    String printerName = "ZDesigner ZT410-203dpi ZPL";

	    //String inputFileName = "\\resource\\barcode.pdf";
	    String inputFileName ="C:/barcode.pdf";
	    PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
	    attributes.add(OrientationRequested.LANDSCAPE);

	    if (query) {
	        // Look for a named printer that can support the
	        // attributes and print its status
	        queryPrinter(printerName, attributes);
	    } else {
	        // print to the named printer, or to the default
	        // printer otherwise.
	        print(printerName, inputFileName, attributes);
	    }
	    // The main() method ends here, but there may be a printing thread
	    // operating in the background. So the program may not terminate
	    // until printing completes.
	}

	 // List names of all PrintServices that can support the attributes
	  public static void queryServices(PrintRequestAttributeSet attributes) {
	    // Find all services that can support the specified attributes
	    PrintService[] services = PrintServiceLookup.lookupPrintServices(null, attributes);
	    // Loop through available services
	    for (int i = 0; i < services.length; i++) {
	      // Print service name
	      System.out.print(services[i].getName());

	      // Then query and print the document types it can print
	      DocFlavor[] flavors = services[i].getSupportedDocFlavors();
	      for (int j = 0; j < flavors.length; j++) {
	        // Filter out DocFlavors that have a representation class other
	        // than java.io.InputStream.
	        String repclass = flavors[j].getRepresentationClassName();
	        if (!repclass.equals("java.io.InputStream"))
	          continue;
	        System.out.println("\t" + flavors[j].getMimeType());
	      }
	    }
	  }

	  // List details about the named printer
	  public static void queryPrinter(String printerName, PrintRequestAttributeSet attributes) {
	    // Find the named printer
	    PrintService service = getNamedPrinter(printerName, attributes);
	    if (service == null) {
	      System.out.println(printerName + ": no such printer capable of "
	          + "handling the specified attributes");
	      return;
	    }

	    // Print status and other information about the printer
	    System.out.println(printerName + " status:");
	    Attribute[] attrs = service.getAttributes().toArray();
	    for (int i = 0; i < attrs.length; i++)
	      System.out.println("\t" + attrs[i].getName() + ": " + attrs[i]);

	  }

	  // Print the contents of the named file to the named printer (or to a
	  // default printer if printerName is null) requesting the specified
	  // attributes.
	  public static void print(String printerName, String filename, PrintRequestAttributeSet attributes)
	      throws IOException {
	    // Look for a printer that can support the attributes
	    PrintService service = getNamedPrinter(printerName, attributes);
	    if (service == null) {
	      System.out.println("Can't find a printer " + "with specified attributes");
	      return;
	    }
	    // Print the file to that printer. See method definition below
	    printToService(service, filename, attributes);
	    // Let the user know where to pick up their printout
	    System.out.println("Printed " + filename + " to " + service.getName());
	  }

	  // Print to an output file instead of a printer
	  public static void printToFile(String outputFileName, String outputFileType,
	      String inputFileName, PrintRequestAttributeSet attributes) throws IOException {

	    // Determine whether the system can print to the specified type, and
	    // get a factory object if so.
	    // The name of this static method is way too long!
	    StreamPrintServiceFactory[] factories = StreamPrintServiceFactory
	        .lookupStreamPrintServiceFactories(null, outputFileType);

	    // Error message if we can't print to the specified output type
	    if (factories.length == 0) {
	      System.out.println("Unable to print files of type: " + outputFileType);
	      return;
	    }

	    // Open the output file
	    FileOutputStream out = new FileOutputStream(outputFileName);
	    // Get a PrintService object to print to that file
	    StreamPrintService service = factories[0].getPrintService(out);
	    // Print using the method below
	    printToService(service, inputFileName, attributes);
	    // And remember to close the output file
	    out.close();
	  }

	  // Print the contents of the named file to the specified PrintService,
	  // requesting the specified attributes.
	  // This is shared code used by print() and printToFile() above.
	  public static void printToService(PrintService service, String filename,
	      PrintRequestAttributeSet attributes) throws IOException {
	    // Figure out what type of file we're printing
	    DocFlavor flavor = getFlavorFromFilename(filename);
	    // Open the file
	    System.out.println(filename);

	    PDDocument document = null;
	    try
	    {
	        document = PDDocument.load(new File(filename));
	    }
	    catch (Exception e)
	    {
	        System.out.println("Unable to open PDF file ");
	    }

	    // Create a Doc object to print from the file and flavor.
	    Doc doc = new SimpleDoc(document, flavor, null);
	    // Create a print job from the service
	    DocPrintJob job = service.createPrintJob();

	    // Monitor the print job with a listener
	    job.addPrintJobListener(new PrintJobAdapter() {
	      public void printJobCompleted(PrintJobEvent e) {
	        System.out.println("Print job complete");
	        System.exit(0);
	      }

	      public void printDataTransferCompleted(PrintJobEvent e) {
	        System.out.println("Document transfered to printer");
	      }

	      public void printJobRequiresAttention(PrintJobEvent e) {
	        System.out.println("Print job requires attention");
	        System.out.println("Check printer: out of paper?");
	      }

	      public void printJobFailed(PrintJobEvent e) {
	        System.out.println("Print job failed");
	        System.exit(1);
	      }
	    });

	    // Now print the document, catching errors
	    try {
	      job.print(doc, attributes);
	    } catch (PrintException e) {
	      System.out.println(e);
	      System.exit(1);
	    }
	  }

	  // A utility method to look up printers that can support the specified
	  // attributes and return the one that matches the specified name.
	  public static PrintService getNamedPrinter(String name, PrintRequestAttributeSet attrs) {
	    PrintService[] services = PrintServiceLookup.lookupPrintServices(null, attrs);
	    if (services.length > 0) {
	      if (name == null)
	        return services[0];
	      else {
	        for (int i = 0; i < services.length; i++) {
	          if (services[i].getName().equals(name))
	            return services[i];
	        }
	      }
	    }
	    return null;
	  }

	  // A utility method to return a DocFlavor object matching the
	  // extension of the filename.
	  public static DocFlavor getFlavorFromFilename(String filename) {
	    String extension = filename.substring(filename.lastIndexOf('.') + 1);
	    extension = extension.toLowerCase();
	    if (extension.equals("gif"))
	      return DocFlavor.INPUT_STREAM.GIF;
	    else if (extension.equals("jpeg"))
	      return DocFlavor.INPUT_STREAM.JPEG;
	    else if (extension.equals("jpg"))
	      return DocFlavor.INPUT_STREAM.JPEG;
	    else if (extension.equals("png"))
	      return DocFlavor.INPUT_STREAM.PNG;
	    else if (extension.equals("ps"))
	      return DocFlavor.INPUT_STREAM.POSTSCRIPT;
	    else if (extension.equals("txt"))
	      return DocFlavor.INPUT_STREAM.TEXT_PLAIN_HOST;
	    else if (extension.equals("pdf"))
	        return DocFlavor.SERVICE_FORMATTED.PAGEABLE;
	    // Fallback: try to determine flavor from file content
	    else
	      return DocFlavor.INPUT_STREAM.AUTOSENSE;
	  }


	  /*+^XA

		+^FX Second section with recipient address and permit information.
		+^CFA,30
		+^FO50,300^FDJohn Doe^FS
		+^FO50,340^FD100 Main Street^FS
		+^FO50,380^FDSpringfield TN 39021^FS
		+^FO50,420^FDUnited States (USA)^FS
		+^CFA,15
		+^FO600,300^GB150,150,3^FS
		+^FO638,340^FDPermit^FS
		+^FO638,390^FD123456^FS
		+^FO50,500^GB700,1,3^FS

		+^FX Third section with barcode.
		+^BY5,2,270
		+^FO175,550^BC^FD1234567890^FS

		+^XZ*/
}
