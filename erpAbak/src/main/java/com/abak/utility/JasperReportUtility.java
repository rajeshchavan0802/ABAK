package com.abak.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.junit.runners.model.TestClass;
import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
 
@Component
public class JasperReportUtility {

	 
	
	public void createReportInPDF(String jrxmlFileLocation, Map<String, Object> map, List<?> dataCollection,String reportLocation,String filename) throws JRException {
		
				/*// Compile jrxml file.
				System.setProperty("java.awt.headless", "true");
				JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFileLocation);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(dataCollection));

				// Make sure the output directory exists.
				 File outDir = new File(reportLocation);
				 outDir.mkdirs();

				// Export to PDF.
				JasperExportManager.exportReportToPdfFile(jasperPrint, outDir.getPath()+"\\"+filename);
				System.out.println(outDir.getPath()+"\\"+filename+" file has been generated!");*/



				/*//new Code from mxns

				JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFileLocation);
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
				JasperPrint report = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(dataCollection));
				byte[] coaSummaryReportPDF = JasperExportManager.exportReportToPdf(report);

				try{

					FileOutputStream fileOuputStream = new FileOutputStream(reportLocation+filename);
					fileOuputStream.write(coaSummaryReportPDF);
					fileOuputStream.close();

				}catch (Exception e){

				}

				System.out.println("File has been genarated");*/











		// Compile jrxml file.
		System.setProperty("java.awt.headless", "true");
		JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFileLocation);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JRBeanCollectionDataSource(dataCollection));
		
		
		File outDir = new File(reportLocation);
		outDir.mkdirs();
		
		Exporter exporter = new JRDocxExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		File exportReportFile = new File(reportLocation+"\\"+filename);
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
		exporter.exportReport();

		 

		// Export to PDF.
		/*
		 * try { JasperExportManager.exportReportToPdfFile(jasperPrint,
		 * outDir.getPath()+"\\"+filename); } catch (JRException e) {
		 * 
		 * e.printStackTrace(); } System.out.println(outDir.getPath()+"\\"+" file has
		 * been generated! rc......");
		 */

 

	}
	
	

			public void copyFileUsingStream(File source, File dest) throws IOException {
				
			    InputStream is = null;
			    OutputStream os = null;
			    try {
			        is = new FileInputStream(source);
			        os = new FileOutputStream(dest);
			        byte[] buffer = new byte[1024];
			        int length;
			        while ((length = is.read(buffer)) > 0) {
			            os.write(buffer, 0, length);
			        }
			    } finally {
			        is.close();
			        os.close();
			    }
				
			
			}

	
	
}
