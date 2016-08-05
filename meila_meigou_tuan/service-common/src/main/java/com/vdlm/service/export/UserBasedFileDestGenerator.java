package com.vdlm.service.export;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vdlm.dal.model.User;

/**
 *
 * @author:  chenxi
 */

//@Component("fdg")
public class UserBasedFileDestGenerator extends AbstractFileDestGenerator implements FileDestGenerator {

	private static final String ANONYMOUS_PATH = "/anonymous/";
	
    @Override
    public String getFileDest() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return rootPath + ANONYMOUS_PATH + UUID.randomUUID() + "/" + fileName;
        }

        Object principal = auth.getPrincipal();
        if (principal instanceof User) {
            return rootPath + ((User) principal).getId() + "/" + UUID.randomUUID() + "/" + fileName;
        }

        return rootPath + ANONYMOUS_PATH + UUID.randomUUID() + "/" + fileName;
    }

}
