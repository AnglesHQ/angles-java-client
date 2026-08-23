package com.github.angleshq.angles.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Distinguishes a build or execution produced by an automated test framework from one
 * produced by a manual test run in the Angles UI.
 *
 * This is read-only from a reporting client's point of view. The value is assigned by the
 * Angles server - a client that could set it to MANUAL would put a build on the dashboard
 * with no manual test run to explain it, so it is deliberately absent from CreateBuild and
 * CreateExecution.
 */
public enum ExecutionType {

    @SerializedName("automated")
    AUTOMATED("automated"),

    @SerializedName("manual")
    MANUAL("manual");

    private final String value;

    ExecutionType(String value) {
        this.value = value;
    }

    /** The wire value used by the Angles API, e.g. for a query string parameter. */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
