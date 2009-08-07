/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Dmitry Abramov
 * Created: 26.01.2009 16:15:29
 * $Id$
 */
package com.haulmont.cuba.gui;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.cache.StringTemplateLoader;
import freemarker.ext.beans.BeansWrapper;

import java.util.Map;
import java.util.HashMap;
import java.io.StringWriter;

public class TemplateHelper {
    public static String processTemplate(String templateStr, Map<String, Object> parameterValues) {

        Map<String, Object> params = new HashMap<String, Object>(parameterValues);
        params.put("statics", BeansWrapper.getDefaultInstance().getStaticModels());

        final StringWriter writer = new StringWriter();

        try {
            final Configuration configuration = new Configuration();

            final StringTemplateLoader templateLoader = new StringTemplateLoader();
            templateLoader.putTemplate("template", templateStr);
            configuration.setTemplateLoader(templateLoader);

            final Template template = configuration.getTemplate("template");
            template.process(params, writer);

            return writer.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
