package io.quarkus.bom.decomposer.detector;

import io.quarkus.bom.decomposer.BomDecomposerException;
import io.quarkus.bom.decomposer.ReleaseId;
import io.quarkus.bom.decomposer.ReleaseIdDetector;
import io.quarkus.bom.decomposer.ReleaseIdFactory;
import io.quarkus.bom.decomposer.ReleaseIdResolver;
import org.eclipse.aether.artifact.Artifact;

public class QuarkusSecurityReleaseIdDetector implements ReleaseIdDetector {

    @Override
    public ReleaseId detectReleaseId(ReleaseIdResolver releaseResolver, Artifact artifact)
            throws BomDecomposerException {
        if (artifact.getArtifactId().equals("quarkus-security") && artifact.getGroupId().equals("io.quarkus.security")
                && artifact.getVersion().equals("1.1.4.Final")) {
            return ReleaseIdFactory.forScmAndTag("https://github.com/quarkusio/quarkus-security", artifact.getVersion());
        }
        return null;
    }

}
