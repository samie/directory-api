package org.vaadin.directory.v2.api.parameters;

/**
 *
 * Represents Vaadin version ranges for the queries
 *
 * @author Vaadin Ltd.
 *
 */
public class VaadinVersion {
    private static final String INVALID_MINOR = "The minor version number must be greater than 0!";
    private static final String INVALID_MAJOR = "The major version number must be equal to or greater than 6!";

    private int major = -1;
    private int minor = -1;

    private boolean inclusiveLower;
    private int lowerMajor = -1;
    private int lowerMinor = -1;

    private boolean inclusiveUpper;
    private int upperMajor = -1;
    private int upperMinor = -1;

    /*
     * Through the use of static constructors this class is always in a valid
     * state, i.e. produces a valid version string argument
     */
    private VaadinVersion() {
    }

    /**
     * Creates a {@link VaadinVersion} object that represents a version range
     * whose upper bound is within the given limits.
     *
     * @param major
     *            the major release number of the version
     * @param minor
     *            the minor release number of the version
     * @param inclusive
     *            true if the version range includes the upper bound
     * @return {@link VaadinVersion} object
     */
    public static VaadinVersion upperBound(int major, int minor,
            boolean inclusive) {
        VaadinVersion version = new VaadinVersion();
        version.setUpperBound(major, minor, inclusive);
        return version;
    }

    /**
     * Creates a {@link VaadinVersion} object that represents a version range
     * whose lower bound is within the given limits.
     *
     * @param major
     *            the major release number of the version
     * @param minor
     *            the minor release number of the version
     * @param inclusive
     *            true if the version range includes the lower bound
     * @return {@link VaadinVersion} object
     */
    public static VaadinVersion lowerBound(int major, int minor,
            boolean inclusive) {
        VaadinVersion version = new VaadinVersion();
        version.setLowerBound(major, minor, inclusive);
        return version;
    }

    /**
     * Creates a {@link VaadinVersion} object that represents a specific release
     * version
     *
     * @param major
     *            the major release number of the version
     * @param minor
     *            the minor release number of the version
     *
     * @return {@link VaadinVersion} object
     */
    public static VaadinVersion version(int majorVersion, int minorVersion) {
        VaadinVersion version = new VaadinVersion();
        checkArguments(majorVersion, 0);
        version.major = majorVersion;
        version.minor = minorVersion;

        return version;
    }

    /**
     * Creates a {@link VaadinVersion} object that represents all releases with
     * a particular major number
     *
     * @param major
     *            the major release number
     *
     * @return {@link VaadinVersion} object
     */
    public static VaadinVersion version(int majorVersion) {
        VaadinVersion version = new VaadinVersion();
        checkArguments(majorVersion, 0);
        version.major = majorVersion;

        return version;
    }

    /**
     * Sets the lower bound of this range. It has no effect if the object has
     * been created using {@link VaadinVersion#version(int)} or
     * {@link VaadinVersion#version(int, int)}
     *
     * @param major
     *            the major release number of the version
     * @param minor
     *            the minor release number of the version
     * @param inclusive
     *            true if the version range includes the lower bound
     */
    public void setLowerBound(int major, int minor, boolean inclusive) {
        if (this.major != -1) {
            return;
        }

        checkArguments(major, minor);
        lowerMajor = major;
        lowerMinor = minor;
        inclusiveLower = inclusive;
    }

    /**
     * Sets the upper bound of this range. It has no effect if the object has
     * been created using {@link VaadinVersion#version(int)} or
     * {@link VaadinVersion#version(int, int)}
     *
     * @param major
     *            the major release number of the version
     * @param minor
     *            the minor release number of the version
     * @param inclusive
     *            true if the version range includes the upper bound
     */
    public void setUpperBound(int major, int minor, boolean inclusive) {
        if (this.major != -1) {
            return;
        }

        checkArguments(major, minor);
        upperMajor = major;
        upperMinor = minor;
        inclusiveUpper = inclusive;
    }

    private static void checkArguments(int major, int minor) {
        if (major < 6) {
            throw new IllegalArgumentException(INVALID_MAJOR);
        }
        if (minor < 0) {
            throw new IllegalArgumentException(INVALID_MINOR);
        }
    }

    /**
     * @return the String representation of this version or version range in the
     *         format that the server expects
     */
    public String toVersionString() {
        if (major != -1 && minor != -1) {
            return String.format("%d.%d", major, minor);
        } else if (major != -1) {
            return Integer.toString(major);
        }

        StringBuilder result = new StringBuilder();
        if (lowerMajor != -1) {
            char bound = inclusiveLower ? '[' : '(';
            result.append(bound).append(lowerMajor).append('.')
                    .append(lowerMinor);
        } else {
            result.append('(');
        }

        result.append(',');

        if (upperMajor != -1) {
            char bound = inclusiveUpper ? ']' : ')';
            result.append(upperMajor).append('.').append(upperMinor)
                    .append(bound);
        } else {
            result.append(')');
        }

        return result.toString();
    }
}
