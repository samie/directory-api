package org.vaadin.directory.v2.api.entities;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class Dependency extends ResponseDetails {
    private String dependency;

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }
}