package org.vaadin.directory.v2.api.entities;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class AddonVersion extends ResponseDetails {
    private String maturity;
    private String versionName;
    private String publishedOn;
    private List<String> supportedBrowsers = new LinkedList<>();
    private Boolean browserIndependent;
    private List<String> licenses = new LinkedList<>();
    private String mavenGroupId;
    private String mavenArtifactId;
    private Boolean hasAddonJar;

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public List<String> getSupportedBrowsers() {
        return supportedBrowsers;
    }

    public void setSupportedBrowsers(List<String> supportedBrowsers) {
        this.supportedBrowsers = supportedBrowsers;
    }

    public Boolean getBrowserIndependent() {
        return browserIndependent;
    }

    public void setBrowserIndependent(Boolean browserIndependent) {
        this.browserIndependent = browserIndependent;
    }

    public List<String> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<String> licenses) {
        this.licenses = licenses;
    }

    public String getMavenGroupId() {
        return mavenGroupId;
    }

    public void setMavenGroupId(String mavenGroupId) {
        this.mavenGroupId = mavenGroupId;
    }

    public String getMavenArtifactId() {
        return mavenArtifactId;
    }

    public void setMavenArtifactId(String mavenArtifactId) {
        this.mavenArtifactId = mavenArtifactId;
    }

    public Boolean getHasAddonJar() {
        return hasAddonJar;
    }

    public void setHasAddonJar(Boolean hasAddonJar) {
        this.hasAddonJar = hasAddonJar;
    }
}