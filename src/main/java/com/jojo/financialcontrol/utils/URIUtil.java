package com.jojo.financialcontrol.utils;

import java.net.URI;
import java.util.UUID;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class URIUtil {

    /**
     * Build URI for any resource given its base path and ID.
     * 
     * @param id the resource ID to append
     * @return the full URI pointing to the created resource
     */
    public static URI getUri(UUID id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .pathSegment(id.toString())
                .build()
                .toUri();
    }
}
