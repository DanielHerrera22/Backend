package culturemedia.controllers;

import java.util.Collections;
import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CultureMediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {
    private final CultureMediaService cultureMediaService;

    public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public CultureMediaController() {
        this.cultureMediaService = new CultureMediaServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }
    @GetMapping
    public ResponseEntity<List<Video>> findAll() throws VideoNotFoundException {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cultureMediaService.findAll());
        } catch (VideoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("Error_name", e.getMessage())
                    .body(Collections.emptyList());
        }
    }

    @PostMapping("/videos")
    public Video addVideo(@RequestBody Video video){
        return cultureMediaService.save(video);
    }
}
