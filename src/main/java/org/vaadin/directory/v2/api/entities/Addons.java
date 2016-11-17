package org.vaadin.directory.v2.api.entities;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class Addons extends ResponseDetails {
    private List<Addon> addons = Collections.emptyList();

    public List<Addon> getAddons() {
        return addons;
    }

    public void setAddons(List<Addon> addons) {
        this.addons = addons;
    }
}