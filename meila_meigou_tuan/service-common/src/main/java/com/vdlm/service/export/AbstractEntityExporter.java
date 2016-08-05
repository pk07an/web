package com.vdlm.service.export;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author:  chenxi
 */

public abstract class AbstractEntityExporter implements EntityExporter {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTCHAR = '\0';

    protected char separator = DEFAULT_SEPARATOR;
    protected char quotechar = DEFAULT_QUOTCHAR;

    private FileDestGenerator fdg;
    private final OrderedProperties headerProps = new OrderedProperties();

    @Override
    public String exportEntityAsFile(Object entity) throws Exception {
        Iterator<String> it = headerProps.keySet().iterator();
        String key;
        String value;
        String[] headerNames = new String[headerProps.size()];
        String[] entityValues = new String[headerProps.size()];
        int index = 0;
        Object propValue;
        while (it.hasNext()) {
            key = it.next();
            value = headerProps.getProperty(key);
            headerNames[index] = value;
            propValue = PropertyUtils.getProperty(entity, key);
            if (propValue == null)
            	entityValues[index] = "";
            else
            	entityValues[index] = propValue.toString();
            index++;
        }
        String dest = fdg.getFileDest();
        File file = prepareDestFile(dest);
        exportFile(file, headerNames, entityValues);
        return dest;
    }
    
    @Override
    public String exportEntitiesAsFile(List<?> entities) throws Exception {
    	 Iterator<String> it = headerProps.keySet().iterator();
         String key;
         String value;
         String[] headerNames = new String[headerProps.size()];
         int index = 0;
         while (it.hasNext()) {
             key = it.next();
             value = headerProps.getProperty(key);
             headerNames[index] = value;
             index++;
         }
         List<String[]> valuesList = new ArrayList<String[]>();
         String[] entityValues;
         
         for (Object entity : entities) {
        	 index = 0;
        	 entityValues = new String[headerProps.size()];
        	 it = headerProps.keySet().iterator();
        	 Object propValue = null;
        	 while (it.hasNext()) {
                 key = it.next();
                 propValue = PropertyUtils.getProperty(entity, key);
                 if (propValue == null)
                 	entityValues[index++] = "";
                 else
                 	entityValues[index++] = propValue.toString();
        	 }
        	 valuesList.add(entityValues);
         }
         String dest = fdg.getFileDest();
         File file = prepareDestFile(dest);
         exportFile(file, headerNames, valuesList);
         return dest;
    }
    
    private File prepareDestFile(String dest) {
    	int lastSlash = dest.lastIndexOf("/");
    	if (lastSlash > 0) {
    		String dirPath = dest.substring(0, lastSlash);
    		File dir = new File(dirPath);
    		dir.mkdirs();
    	}
    	return new File(dest);
    }
    
//    @Override
//    public InputStream exportAsStream(Object entity) throws Exception {
//        Iterator<String> it = headerProps.keySet().iterator();
//        String key;
//        String value;
//        String[] headerNames = new String[headerProps.size()];
//        String[] entityValues = new String[headerProps.size()];
//        int index = 0;
//        while (it.hasNext()) {
//            key = it.next();
//            value = headerProps.getProperty(key);
//            headerNames[index] = value;
//            entityValues[index] = PropertyUtils.getProperty(entity, key).toString();
//            index++;
//        }
//        StringWriter writer = new StringWriter();
//        exportWriter(writer, headerNames, entityValues);
//        return new StringInputStream(writer.getBuffer().toString());
//    }

    protected abstract void exportFile(File dest, String[] headerNames, String[] entityValues) throws IOException;
    
    protected abstract void exportFile(File dest, String[] headerNames, List<String[]> valuesList) throws IOException;

//    protected abstract void exportWriter(Writer writer, String[] headerNames, String[] entityValues) throws IOException;

	public char getSeparator() {
		return separator;
	}

	public void setSeparator(char separator) {
		this.separator = separator;
	}

	public char getQuotechar() {
		return quotechar;
	}

	public void setQuotechar(char quotechar) {
		this.quotechar = quotechar;
	}

	public FileDestGenerator getFdg() {
		return fdg;
	}

	public void setFdg(FileDestGenerator fdg) {
		this.fdg = fdg;
	}
	
	public void setHeaderFile(String headerFile) {
		InputStream resource = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(headerFile);
        try {
        	headerProps.load(resource);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file from "
                    + headerFile, e);
        }
	}

}
