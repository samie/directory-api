package org.vaadin.directory.v2.api;

import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public enum EndpointQueryParameters {
    AUTHORS_NAME("author"),
    ADDON_MATURITY("maturity"),
    VAADIN_VERSION("vaadin-version"),
    TYPE("type"),
    SUMMARY("summary"),
    DESCRIPTION("description"),
    NAME("name"),
    FIELDS("fields");

    private String parameter;

    private EndpointQueryParameters(String parameter) {
        this.parameter = parameter;
    }

    public WebTarget set(WebTarget target, String value) {
        return target.queryParam(parameter, value);
    }
}
