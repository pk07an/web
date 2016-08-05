package com.vdlm.service.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVWriter;

/**
 *
 * @author:  chenxi
 */

@Component("entityExporter")
public class CSVEntityExporter extends AbstractEntityExporter implements EntityExporter {

	@Override
    protected void exportFile(File file, String[] headerNames,
            String[] entityValues) throws IOException {
      Writer writer = new FileWriter(file);
      CSVWriter csvWriter = new CSVWriter(writer, separator, quotechar);
      csvWriter.writeNext(headerNames);
      csvWriter.writeNext(entityValues);
      csvWriter.close();
    }

	@Override
	protected void exportFile(File file, String[] headerNames,
            List<String[]> valuesList) throws IOException {
      Writer writer = new FileWriter(file);
      CSVWriter csvWriter = new CSVWriter(writer, separator, quotechar);
      csvWriter.writeNext(headerNames);
      for (String[] entityValues : valuesList) {
    	  csvWriter.writeNext(entityValues);
      }
      csvWriter.close();
    }

//    @Override
//    protected void exportWriter(Writer writer, String[] headerNames,
//            String[] entityValues) throws IOException {
//      CSVWriter csvWriter = new CSVWriter(writer, separator, quotechar);
//      csvWriter.writeNext(headerNames);
//      csvWriter.writeNext(entityValues);
//      csvWriter.close();
//    }

}
