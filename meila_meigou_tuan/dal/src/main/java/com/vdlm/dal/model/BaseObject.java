package com.vdlm.dal.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Base class for Model objects. Child objects should implement toString().
 * 
 */
@SuppressWarnings("serial")
public abstract class BaseObject implements Serializable {

    /**
     * 
     */

    private static final long serialVersionUID = 1L;

    /**
     * Returns a multi-line String with key=value pairs.
     * 
     * @return a String representation of this class.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
