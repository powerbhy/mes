package com.qcadoo.mes.core.data.beans;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Object represents data from the database tables - with and without custom fields - and virtual tables - build using only custom
 * fields. All fields - database's fields and custom fields - are aggregated into key-value map. The key is the name of the field
 * from its definition - {@link com.qcadoo.mes.core.data.definition.DataFieldDefinition#getName()}.
 * 
 * Value type must be the same as the type defined in {@link com.qcadoo.mes.core.data.definition.DataFieldDefinition#getType()}.
 */
public final class Entity {

    private Long id;

    private final Map<String, Object> fields;

    public Entity(final Long id, final Map<String, Object> fields) {
        this.id = id;
        this.fields = fields;
    }

    public Entity(final Long id) {
        this(id, new HashMap<String, Object>());
    }

    public Entity() {
        this(null, new HashMap<String, Object>());
    }

    public Long getId() {
        return id;
    }

    public Object getField(final String fieldName) {
        return fields.get(fieldName);
    }

    public void setField(final String fieldName, final Object fieldValue) {
        fields.put(fieldName, fieldValue);
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(23, 41).append(id).append(fields).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entity)) {
            return false;
        }
        Entity other = (Entity) obj;
        return new EqualsBuilder().append(id, other.id).append(fields, other.fields).isEquals();
    }

    @Override
    public String toString() {
        return "#" + id + ", " + fields.toString();
    }

}
