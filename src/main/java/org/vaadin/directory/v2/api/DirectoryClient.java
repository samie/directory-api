package org.vaadin.directory.v2.api;

import java.io.Closeable;
import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.vaadin.directory.api.Directory.JsonConfig;
import org.vaadin.directory.v2.api.entities.Addon;
import org.vaadin.directory.v2.api.entities.AddonVersion;
import org.vaadin.directory.v2.api.entities.Addons;
import org.vaadin.directory.v2.api.parameters.AddonQueryParameters;
import org.vaadin.directory.v2.api.parameters.AddonVersionQueryParameters;
import org.vaadin.directory.v2.api.parameters.AddonsQueryParameters;

/**
 *
 * @author Vaadin Ltd.
 *
 */
public class DirectoryClient implements Closeable {
    public static final String DIRECTORY_API = "https://vaadin.com/Directory/resource/v2";

    private Client client;

    public DirectoryClient() {
        this(ClientBuilder.newBuilder());
    }

    /**
     * Uses the provided {@link ClientBuilder builder} to construct and further
     * configure the client used to make the requests to the server.
     *
     * Use this if you have specific configuration needs.
     *
     * @param builder
     */
    public DirectoryClient(ClientBuilder builder) {
        client = builder.build();
        client.register(JsonConfig.class);
    }

    /**
     * Returns a list of {@link Addon addons}
     *
     * @param parameters
     *            the query parameters used to limit the result.
     *
     * @return list of {@link Addon addons}
     *
     * @throws WebApplicationException
     *
     * @see AddonsQueryParameters
     */
    public List<Addon> getAddons(AddonsQueryParameters parameters) {
        WebTarget target = client.target(Endpoints.ADDONS.url());

        target = fill(parameters, target);

        Addons response = target.request(MediaType.APPLICATION_JSON).get(
                Addons.class);

        return response.getAddons();
    }

    private WebTarget fill(AddonsQueryParameters params, WebTarget target) {
        target = setAuthorsName(params, target);
        target = setAddonMaturity(params, target);
        target = setVaadinVersion(params, target);
        target = setType(params, target);
        target = setSummary(params, target);
        target = setDescription(params, target);
        target = setName(params, target);
        target = setFields(params, target);
        return target;
    }

    private WebTarget setAuthorsName(AddonsQueryParameters params,
            WebTarget target) {
        if (params.getAuthorsName() != null) {
            return EndpointQueryParameters.AUTHORS_NAME.set(target,
                    params.getAuthorsName());
        }
        return target;
    }

    private WebTarget setAddonMaturity(AddonsQueryParameters params,
            WebTarget target) {
        if (params.getAddonMaturity() != null
                && !params.getAddonMaturity().isEmpty()) {
            String value = toCommaSeparated(params.getAddonMaturity());
            return EndpointQueryParameters.ADDON_MATURITY.set(target, value);

        }
        return target;
    }

    private static <T extends Enum<?>> String toCommaSeparated(List<T> values) {
        StringBuilder result = new StringBuilder();
        for (T value : values) {
            result.append(value).append(",");
        }
        return result.toString();
    }

    private WebTarget setVaadinVersion(AddonsQueryParameters params,
            WebTarget target) {
        if (params.getVaadinVersion() != null) {
            return EndpointQueryParameters.VAADIN_VERSION.set(target, params
                    .getVaadinVersion().toVersionString());
        }
        return target;
    }

    private WebTarget setType(AddonsQueryParameters params, WebTarget target) {
        if (params.getTypes() != null && !params.getTypes().isEmpty()) {
            String value = toCommaSeparated(params.getTypes());
            return EndpointQueryParameters.TYPE.set(target, value);
        }
        return target;
    }

    private WebTarget setSummary(AddonsQueryParameters params, WebTarget target) {
        if (params.getSummary() != null) {
            return EndpointQueryParameters.SUMMARY.set(target,
                    params.getSummary());
        }
        return target;
    }

    private WebTarget setDescription(AddonsQueryParameters params,
            WebTarget target) {
        if (params.getDescription() != null) {
            return EndpointQueryParameters.DESCRIPTION.set(target,
                    params.getDescription());
        }
        return target;
    }

    private WebTarget setName(AddonsQueryParameters params, WebTarget target) {
        if (params.getName() != null) {
            return EndpointQueryParameters.NAME.set(target, params.getName());
        }
        return target;
    }

    private WebTarget setFields(AddonsQueryParameters params, WebTarget target) {
        if (params.getFields() != null) {
            String value = toCommaSeparated(params.getFields());
            return EndpointQueryParameters.FIELDS.set(target, value);
        }
        return target;
    }

    /**
     * Returns the {@link Addon addon} with a given identifier.
     *
     * @param parameters
     *            the query parameters used to limit the result. They are mostly
     *            applied to the list of {@link AddonVersion versions} of the
     *            {@link Addon addon}.
     *
     * @param identifier
     *            the {@link Addon addon}'s identifier
     *
     * @return the {@link Addon addon}
     *
     * @throws NotFoundException
     *             when an addon with the specified identifier is not found
     *
     * @see AddonQueryParameters
     */
    public Addon getAddon(AddonQueryParameters parameters, String identifier) {
        WebTarget target = client.target(Endpoints.ADDON.url())
                .resolveTemplate("id", identifier);

        target = fill(parameters, target);

        return target.request().get(Addon.class);
    }

    private WebTarget fill(AddonQueryParameters parameters, WebTarget target) {
        target = setMaturity(parameters, target);
        target = setVaadinVersion(parameters, target);
        target = setFields(parameters, target);
        return target;
    }

    private WebTarget setMaturity(AddonQueryParameters params, WebTarget target) {
        if (params.getMaturity() != null && !params.getMaturity().isEmpty()) {
            String value = toCommaSeparated(params.getMaturity());
            return EndpointQueryParameters.ADDON_MATURITY.set(target, value);
        }
        return target;
    }

    private WebTarget setVaadinVersion(AddonQueryParameters params,
            WebTarget target) {
        if (params.getVaadinVersion() != null) {
            return EndpointQueryParameters.VAADIN_VERSION.set(target, params
                    .getVaadinVersion().toVersionString());
        }
        return target;
    }

    private WebTarget setFields(AddonQueryParameters params, WebTarget target) {
        if (params.getFields() != null && !params.getFields().isEmpty()) {
            String value = toCommaSeparated(params.getFields());
            return EndpointQueryParameters.FIELDS.set(target, value);
        }
        return target;
    }

    /**
     * Returns the {@link AddonVersion addon version} of an {@link Addon addon}.
     *
     * @param parameters
     *            the query parameters used to limit the result
     * @param addonIdentifier
     *            the identifier of the addon
     * @param versionIdentifier
     *            the identifier of the version. This is the same as the one
     *            found in the {@link Addon#getVersions()}
     * @return the {@link AddonVersion addon version}
     *
     * @throws NotFoundException
     *
     * @see AddonVersionQueryParameters
     */
    public AddonVersion getAddonVersion(AddonVersionQueryParameters parameters,
            String addonIdentifier, String versionIdentifier) {
        WebTarget target = client.target(Endpoints.ADDON_VERSION.url());

        target = target.resolveTemplate("id", addonIdentifier).resolveTemplate(
                "version", versionIdentifier);

        target = fill(target, parameters);

        AddonVersion version = target.request(MediaType.APPLICATION_JSON).get(
                AddonVersion.class);

        return version;
    }

    private WebTarget fill(WebTarget target,
            AddonVersionQueryParameters parameters) {
        if (parameters.getFields() != null && !parameters.getFields().isEmpty()) {
            String value = toCommaSeparated(parameters.getFields());
            return EndpointQueryParameters.FIELDS.set(target, value);
        }
        return target;
    }

    @Override
    public void close() {
        client.close();
    }
}