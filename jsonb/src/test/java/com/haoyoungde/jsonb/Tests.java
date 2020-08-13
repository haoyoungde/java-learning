package com.haoyoungde.jsonb;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyVisibilityStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Tests {
    public static class FieldPojo {

        private String afield;
        private String bfield;
        public String cfield;
        public String dfield;

        public FieldPojo(String afield, String bfield, String cfield, String dfield) {
            this.afield = afield;
            this.bfield = bfield;
            this.cfield = cfield;
            this.dfield = dfield;
        }
    }

    /**
     * Tests applying for both public and nonpublic fields.
     */
    @Test
    public void testFieldVisibilityStrategy() {
        JsonbConfig customizedConfig = new JsonbConfig();
        customizedConfig.setProperty(JsonbConfig.PROPERTY_VISIBILITY_STRATEGY, new PropertyVisibilityStrategy() {
            @Override
            public boolean isVisible(Field field) {
                final String fieldName = field.getName();
                return fieldName.equals("afield") || fieldName.equals("dfield");
            }

            @Override
            public boolean isVisible(Method method) {
                throw new IllegalStateException("Not supported");
            }
        });

        FieldPojo fieldPojo = new FieldPojo("avalue", "bvalue", "cvalue", "dvalue");

        Jsonb jsonb = JsonbBuilder.create(customizedConfig);
        String json = jsonb.toJson(fieldPojo);
        System.out.println(json);
        Assert.assertEquals("{\"afield\":\"avalue\",\"dfield\":\"dvalue\"}", json);
    }
}
