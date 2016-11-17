package org.vaadin.directory.v2.api.entities;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class ResponseDetails {
    private List<String> warnings = new LinkedList<String>();
    private List<String> errors = new LinkedList<String>();
    private Integer totalResults;

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
}