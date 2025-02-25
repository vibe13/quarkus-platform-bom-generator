package io.quarkus.bom.decomposer.detector;

import io.quarkus.bom.decomposer.BomDecomposerException;
import io.quarkus.bom.decomposer.ReleaseId;
import io.quarkus.bom.decomposer.ReleaseIdDetector;
import io.quarkus.bom.decomposer.ReleaseIdFactory;
import io.quarkus.bom.decomposer.ReleaseIdResolver;
import org.eclipse.aether.artifact.Artifact;

public class JakartaInterceptorReleaseIdDetector implements ReleaseIdDetector {

    @Override
    public ReleaseId detectReleaseId(ReleaseIdResolver releaseResolver, Artifact artifact)
            throws BomDecomposerException {
        if (artifact.getGroupId().equals("jakarta.interceptor")) {
            ReleaseId releaseId = releaseResolver.defaultReleaseId(artifact);
            if (!releaseId.origin().toString().startsWith("https://github.com/eclipse-ee4j/interceptor-api")) {
                return releaseId;
            }
            return ReleaseIdFactory.forScmAndTag("https://github.com/jakartaee/interceptors",
                    artifact.getVersion() + "-RELEASE");
        }
        return null;
    }

}
