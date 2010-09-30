package com.qcadoo.mes.core.internal.types;

import org.apache.commons.lang.StringUtils;

import com.qcadoo.mes.core.api.Entity;
import com.qcadoo.mes.model.FieldDefinition;
import com.qcadoo.mes.model.types.FieldType;

public final class TextType implements FieldType {

    @Override
    public boolean isSearchable() {
        return true;
    }

    @Override
    public boolean isOrderable() {
        return true;
    }

    @Override
    public boolean isAggregable() {
        return false;
    }

    @Override
    public Class<?> getType() {
        return String.class;
    }

    @Override
    public Object toObject(final FieldDefinition fieldDefinition, final Object value, final Entity validatedEntity) {
        String stringValue = String.valueOf(value);
        if (StringUtils.length(stringValue) > 2048) {
            validatedEntity.addError(fieldDefinition, "commons.validate.field.error.stringIsTooLong", String.valueOf(2048));
            return null;
        }
        return stringValue;
    }

    @Override
    public String toString(final Object value) {
        return String.valueOf(value);
    }

}
