package org.vaadin.directory.v2.api.parameters;

import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class Fields {

    public static final Collection<AddonFields> ADDONS_COLLECTION_FIELDS = new HashSet<>();
    static {
        ADDONS_COLLECTION_FIELDS.add(AddonFields.NAME);
        ADDONS_COLLECTION_FIELDS.add(AddonFields.IDENTIFIER);
        ADDONS_COLLECTION_FIELDS.add(AddonFields.MATURITY);
        ADDONS_COLLECTION_FIELDS.add(AddonFields.AVAILABLE_VERSIONS);
        ADDONS_COLLECTION_FIELDS.add(AddonFields.VERSIONS);
    }

    public enum AddonFields {
        NAME("name"),
        IDENTIFIER("identifier"),
        MATURITY("maturity"),
        AUTHOR("author"),
        LINK_URL("linkUrl"),
        GROUP_ID("groupdId"),
        SUMMARY("summary"),
        DESCRIPTION("description"),
        TYPE("type"),
        DOWNLOAD_COUNT("downloadCount"),
        AVG_RATING("averageRating"),
        RATING_COUNT("ratingCount"),
        PRO_ACOUNT("proAccount"),
        AVAILABLE_VERSIONS("totalVersions"),
        VERSIONS("versions");

        private String fieldName;

        private AddonFields(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String toString() {
            return fieldName;
        }
    }

    public enum AddonVersionFields {
        MATURITY("maturity"),
        VERSION_NAME("versionName"),
        PUBLISHED_ON("publishedOn"),
        SUPPORTED_BROWSERS("supportedBrowsers"),
        BROWSER_INDEPENDENT("browserIndependent"),
        LICENSES("licenses"),
        MAVEN_GROUP_ID("mavenGroupId"),
        MAVEN_ARTIFACT_ID("mavenArtifactId"),
        HAS_ADDON_JAR("hasAddonJar");

        private String fieldName;

        private AddonVersionFields(String fieldName) {
            this.fieldName = fieldName;
        }

        @Override
        public String toString() {
            return fieldName;
        }
    }
}
