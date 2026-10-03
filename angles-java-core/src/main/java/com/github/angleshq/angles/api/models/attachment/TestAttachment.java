package com.github.angleshq.angles.api.models.attachment;

import com.github.angleshq.angles.api.models.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A file an automated test uploaded against its build: a log, HAR file, video, Playwright
 * trace, HTML snapshot or image. Listing its id on the execution (or a step) shows it there.
 */
@Getter @Setter @NoArgsConstructor
public class TestAttachment extends BaseModel {

    /**
     * What the file holds, decided by the server from the file extension: image, log, json,
     * har, video, trace, archive or html.
     */
    private String kind;
    /** The uploaded file name, for display. */
    private String originalName;
    /** The type the file is served with, decided from its extension. */
    private String mimeType;
    private Long size;
    private String build;
    /** The execution that listed this attachment, once it has been saved. */
    private String execution;
}
