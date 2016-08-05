package com.vdlm.service.export;

import java.util.List;

/**
 *
 * @author:  chenxi
 */

public interface EntityExporter 
{
    public String exportEntityAsFile(Object entity) throws Exception;
    
    public String exportEntitiesAsFile(List<?> entities) throws Exception;

//    public InputStream exportAsStream(Object entity) throws Exception;
}
