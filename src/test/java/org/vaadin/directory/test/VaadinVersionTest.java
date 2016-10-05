package org.vaadin.directory.test;

import org.junit.Assert;
import org.junit.Test;
import org.vaadin.directory.v2.api.parameters.VaadinVersion;

public class VaadinVersionTest {

    @Test
    public void singleVersion_checkValidMajor_Success() {
        VaadinVersion.version(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void singleVersion_checkInvalidMajor_ExceptionIsThrown() {
        VaadinVersion.version(5);
    }

    @Test
    public void buildVersion_checkBuildString_ValidNotationIsProduced() {
        VaadinVersion version = VaadinVersion.version(7);
        Assert.assertEquals("7", version.toVersionString());

        version = VaadinVersion.lowerBound(6, 8, true);
        version.setUpperBound(7, 5, false);
        Assert.assertEquals("[6.8,7.5)", version.toVersionString());

        version = VaadinVersion.lowerBound(6, 8, true);
        Assert.assertEquals("[6.8,)", version.toVersionString());

        version = VaadinVersion.lowerBound(6, 8, false);
        Assert.assertEquals("(6.8,)", version.toVersionString());

        version = VaadinVersion.upperBound(6, 8, true);
        Assert.assertEquals("(,6.8]", version.toVersionString());

        version = VaadinVersion.upperBound(6, 8, false);
        Assert.assertEquals("(,6.8)", version.toVersionString());

        version.setLowerBound(6, 8, true);
        version.setUpperBound(7, 5, true);
        Assert.assertEquals("[6.8,7.5]", version.toVersionString());

        version.setLowerBound(6, 8, false);
        version.setUpperBound(7, 5, false);
        Assert.assertEquals("(6.8,7.5)", version.toVersionString());

        Assert.assertEquals("7.4", VaadinVersion.version(7, 4)
                .toVersionString());
        Assert.assertEquals("6.4", VaadinVersion.version(6, 4)
                .toVersionString());
        Assert.assertEquals("7.7", VaadinVersion.version(7, 7)
                .toVersionString());
    }
}
