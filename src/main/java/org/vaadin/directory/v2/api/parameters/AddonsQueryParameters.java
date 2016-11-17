package org.vaadin.directory.v2.api.parameters;

import java.util.List;

import org.vaadin.directory.v2.api.DirectoryClient;
import org.vaadin.directory.v2.api.entities.Addon;
import org.vaadin.directory.v2.api.entities.AddonVersion;
import org.vaadin.directory.v2.api.parameters.Fields.AddonFields;

/**
 *
 * Represents the query parameters for the underlying query of
 * {@link DirectoryClient#getAddons(AddonsQueryParameters)}.
 *
 * @author Vaadin Ltd.
 *
 */
public class AddonsQueryParameters {
    private String authorsName;
    private List<Maturity> addonMaturity;
    private VaadinVersion vaadinVersion;
    private List<AddonType> types;
    private String summary;
    private String description;
    private String name;
    private List<AddonFields> fields;

    public String getAuthorsName() {
        return authorsName;
    }

    /**
     * The full name of the {@link Addon addon}'s Author
     *
     * @param authorsName
     */
    public void setAuthorsName(String authorsName) {
        this.authorsName = authorsName;
    }

    public List<Maturity> getAddonMaturity() {
        return addonMaturity;
    }

    /**
     * A list of {@link Maturity} constants. The parameter applies to the latest
     * version of the {@link Addon addon}.The {@link Addon addons} whose latest
     * version maturity is in the given list are part of the result.
     *
     * @param addonMaturity
     *            a List of {@link Maturity} constants
     */
    public void setAddonMaturity(List<Maturity> addonMaturity) {
        this.addonMaturity = addonMaturity;
    }

    public VaadinVersion getVaadinVersion() {
        return vaadinVersion;
    }

    /**
     * The parameter applies to the {@link Addon addon} versions. Returns all
     * the {@link Addon addons} where at least one of their versions is within
     * range.
     *
     * The contents {@link Addon#getVersions()} are filtered to only include the
     * identifiers for the {@link AddonVersion versions} that support a Vaadin
     * version within the given version range.
     *
     * @param vaadinVersion
     *
     */
    public void setVaadinVersion(VaadinVersion vaadinVersion) {
        this.vaadinVersion = vaadinVersion;
    }

    public List<AddonType> getTypes() {
        return types;
    }

    /**
     * A list of {@link AddonType} constants. The {@link Addon addons} whose
     * type is in the given list are part of the result.
     *
     * @param types
     *            a List of {@link

     */
    public void setType(List<AddonType> types) {
        this.types = types;
    }

    public String getSummary() {
        return summary;
    }

    /**
     * A String which must be part of the {@link Addon addon} summary. The
     * {@link Addon addons} whose summary includes the given String are part of
     * the result.
     *
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    /**
     * A String which must be part of the {@link Addon addon} description. The
     * {@link Addon addons} whose description includes the given String are part
     * of the result.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    /**
     * A String which must be part of the {@link Addon addon} name. The
     * {@link Addon addons} whose description includes the given String are part
     * of the result.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<AddonFields> getFields() {
        return fields;
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
