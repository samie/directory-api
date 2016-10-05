package org.vaadin.directory.v2.api.parameters;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public enum AddonType {
    UI_COMPONENTS("ui-components"),
    DATA_COMPONENTS("data-components"),
    THEMES("themes"),
    TOOLS("tools"),
    MISC("misc");

    private String parameter;

    private AddonType(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return parameter;
    }
}
