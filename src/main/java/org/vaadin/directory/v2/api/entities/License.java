package org.vaadin.directory.v2.api.entities;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class License {
    private String name;

    private String licenseFileUri;

    private boolean free;

    private String artifactId;

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseFileUri() {
        return licenseFileUri;
    }

    public void setLicenseFileUri(String licenseFileUri) {
        this.licenseFileUri = licenseFileUri;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

}