package io.cloudevents;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum SpecVersion {
    V03(
        "0.3",
        Collections.unmodifiableSet(new HashSet<>(Arrays.asList("specversion", "id", "type", "source"))),
        Collections.unmodifiableSet(new HashSet<>(Arrays.asList("datacontenttype", "datacontentencoding", "schemaurl", "subject", "time")))
    ),
    V1(
        "1.0",
        Collections.unmodifiableSet(new HashSet<>(Arrays.asList("specversion", "id", "type", "source"))),
        Collections.unmodifiableSet(new HashSet<>(Arrays.asList("datacontenttype", "dataschema", "subject", "time")))
    );

    private final String stringValue;
    private final Set<String> mandatoryAttributes;
    private final Set<String> optionalAttributes;

    SpecVersion(String stringValue, Set<String> mandatoryAttributes, Set<String> optionalAttributes) {
        this.stringValue = stringValue;
        this.mandatoryAttributes = mandatoryAttributes;
        this.optionalAttributes = optionalAttributes;
    }

    @Override
    public String toString() {
        return this.stringValue;
    }

    public static SpecVersion parse(String sv) {
        switch (sv) {
            case "0.3":
                return SpecVersion.V03;
            case "1.0":
                return SpecVersion.V1;
            default:
                throw new IllegalArgumentException("Unrecognized SpecVersion " + sv);
        }
    }

    public Set<String> getMandatoryAttributes() {
        return mandatoryAttributes;
    }

    public Set<String> getOptionalAttributes() {
        return optionalAttributes;
    }
}
