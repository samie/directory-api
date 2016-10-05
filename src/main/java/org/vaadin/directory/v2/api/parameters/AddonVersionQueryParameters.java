package org.vaadin.directory.v2.api.parameters;

import java.util.List;

import org.vaadin.directory.v2.api.DirectoryClient;
import org.vaadin.directory.v2.api.parameters.Fields.AddonVersionFields;

/**
 *
 * Represents the query parameters for the underlying query of
 * {@link DirectoryClient#getAddonVersion(AddonVersionQueryParameters, String, String)}
 *
 * @author Vaadin Ltd.
 *
 */
public class AddonVersionQueryParameters {
    private List<AddonVersionFields> fields;

    /**
     * The query result only has the given {@link AddonVersionFields fields}
     * values retrieved and set. The rest of its fields will not retrieved.
     *
     * @param fields
     *            a List of {@link AddonVersionFields} constants
     */
    public void setFields(List<AddonVersionFields> fields) {
        this.fields = fields;
    }

    public List<AddonVersionFields> getFields() {
        return fields;
    }
}
