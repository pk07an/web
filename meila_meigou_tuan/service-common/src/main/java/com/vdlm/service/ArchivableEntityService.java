package com.vdlm.service;

import com.vdlm.dal.Archivable;

public interface ArchivableEntityService<E extends Archivable> extends BaseEntityService<E> {

	int delete(String id);

	int undelete(String id);
}
