package org.vaadin.directory.v2.api.entities;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class Addon extends ResponseDetails {
    private String author;
    private String name;
    private String identifier;
    private String linkUrl;
    private String groupId;
    private String summary;
    private String description;
    private String type;
    private String maturity;

    private Long downloadCount;
    private Double avgerageRating;
    private Integer ratingCount;
    private Boolean proAccount;

    private Integer availableVersions;
    private List<String> versions = Collections.emptyList();

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Double getAverageRating() {
        return avgerageRating;
    }

    public void setAverageRating(Double averageRating) {
        avgerageRating = averageRating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Boolean isProAccount() {
        return proAccount;
    }

    public void setProAccount(Boolean proAccount) {
        this.proAccount = proAccount;
    }

    public Integer getAvailableVersions() {
        return availableVersions;
    }

    public void setAvailableVersions(Integer availableVersions) {
        this.availableVersions = availableVersions;
    }

    public List<String> getVersions() {
        return versions;
    }

    public void setVersions(List<String> versions) {
        this.versions = versions;
    }

}