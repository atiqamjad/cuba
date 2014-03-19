/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */

package com.haulmont.cuba.core.config.type;

import java.util.UUID;

/**
 * @author krivopustov
 * @version $Id$
 */
public class UuidTypeFactory extends TypeFactory {
    @Override
    public Object build(String string) {
        if (string == null) {
            return null;
        }

        return UUID.fromString(string);
    }
}