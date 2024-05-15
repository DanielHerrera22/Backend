package culturemedia.controllers;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CultureMediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;

public class CultureMediaController {
    private final CultureMediaService cultureMediaService;

    public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public List<Video> findAllVideos() throws VideoNotFoundException {
        return cultureMediaService.findAll();
    }
}