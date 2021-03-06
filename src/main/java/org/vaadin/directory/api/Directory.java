package org.vaadin.directory.api;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Remote API to Vaadin Directory.
 *
 * @author Sami Ekblad
 */
public class Directory {

    private static final String DIRECTORY_API = "https://vaadin.com/Directory/resource/addon/all";
    private static final String QUERY_DETAILS = "detailed";
    private static final String QUERY_VAADIN = "vaadin";
    private static final String LATEST7_URL = "https://vaadin.com/download/LATEST7";

    /**
     * List all addons from Directory.
     *
     * @param vaadinVersion
     * @return
     */
    public static List<Addon> listAll(final String vaadinVersion) {

        Client client = ClientBuilder.newClient();
        client.register(JsonConfig.class);

        WebTarget target = client.target(DIRECTORY_API);
        Addons result = target
                .queryParam(QUERY_DETAILS, true)
                .queryParam(QUERY_VAADIN, vaadinVersion)
                .request(MediaType.APPLICATION_JSON)
                .get(Addons.class);

        return result != null ? result.getAddon() : null;
    }

    public static List<Addon> search(final String vaadinVersion, final String search, boolean searchSummary) {
        List<Addon> list = Directory.listAll(vaadinVersion);
        if (list == null) {
            return null;
        }
        List<Addon> matches = new ArrayList<>();
        for (Addon a : list) {
            if (searchSummary) {
                if (a.getSummary() != null
                        && a.getSummary().toLowerCase().contains(search.toLowerCase())
                        || a.getName().toLowerCase().contains(search.toLowerCase())
                        || (a.getArtifactId() != null && a.getArtifactId().contains(search.toLowerCase()))) {
                    matches.add(a);
                }
            } else {
                if (a.getName().toLowerCase().contains(search.toLowerCase())
                        || (a.getArtifactId() != null && a.getArtifactId().contains(search.toLowerCase()))) {
                    matches.add(a);
                }

            }
        }
        return matches;
    }

    public static String getLatestVaadinVersion() {
        try {
            InputStream in = new URL(LATEST7_URL).openStream();
            BufferedReader inR = new BufferedReader(new InputStreamReader(in));
            return inR.readLine().trim();
        } catch (IOException ex) {
            Logger.getLogger(Directory.class.getName()).log(Level.SEVERE, "Failed to query latest Vaadin version", ex);
        } finally {
        }
        return null;
    }

    /**
     * ObjectMapper configuration.
     *
     * We need to configure the ObjectMapper to allow single value as array for
     * add-on licenses.
     *
     */
    @Provider
    @Produces({MediaType.APPLICATION_JSON})
    public static class JsonConfig implements ContextResolver<ObjectMapper> {

        private static final ObjectMapper mapper = new ObjectMapper();

        static {
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        }

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return mapper;
        }
    }

}
