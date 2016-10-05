package org.vaadin.directory.v2.api.parameters;

import java.util.List;

import org.vaadin.directory.v2.api.DirectoryClient;
import org.vaadin.directory.v2.api.parameters.Fields.AddonFields;

/**
 *
 * Represents the query parameters for the underlying query of
 * {@link DirectoryClient#getAddon(AddonQueryParameters, String)}.
 *
 * @author Vaadin Ltd.
 *
 */
public class AddonQueryParameters {
    private List<Maturity> maturity;
    private VaadinVersion vaadinVersion;
    private List<AddonFields> fields;

    public List<Maturity> getMaturity() {
        return maturity;
    }

    public VaadinVersion getVaadinVersion() {
        return vaadinVersion;
    }

    public List<AddonFields> getFields() {
        return fields;
    }

    /**
     * A list of {@link Maturity} constants. The parameter applies to the
     * {@link Addon addon} versions. The versions whose maturity is in the given
     * list are part of the result.
     *
     * @param maturity
     *            a List of {@link Maturity} constants
     */
    public void setMaturity(List<Maturity> maturity) {
        this.maturity = maturity;
    }

    /**
     * The parameter applies to the {@link Addon addon} versions. The addon
     * versions which have support for the specified Vaadin version are part of
     * the result.
     *
     * @param vaadinVersion
     */
    public void setVaadinVersion(VaadinVersion vaadinVersion) {
        this.vaadinVersion = vaadinVersion;
    }

    /**
     * The query result only has the given {@link AddonFields fields} values
     * retrieved and set. The rest of its fields will not retrieved.
     *
     * @param fields
     *            a List of {@link AddonFields} constants
     */
    public void setFields(List<AddonFields> fields) {
        this.fields = fields;
    }

}
