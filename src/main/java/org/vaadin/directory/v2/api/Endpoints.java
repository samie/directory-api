package org.vaadin.directory.v2.api;

/**
 *
 * @author Vaadin Ltd.
 *
 */
enum Endpoints {
    ADDONS("addons"),
    ADDON("addon/{id}"),
    ADDON_VERSION("addon/{id}/{version}");

    private String endpoint;

    private Endpoints(String endpoint) {
        this.endpoint = endpoint;

    }

    public String url() {
        return String.format("%s/%s", DirectoryClient.DIRECTORY_API, endpoint);
    }
}