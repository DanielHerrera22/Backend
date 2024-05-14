package culturemedia.Service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.CultureMediaService;
import culturemedia.service.impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CultureMediaServiceTest {
    private CultureMediaService cultureMediaService;

    @BeforeEach
    void init(){

        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewsRepository ViewsRepository = new ViewsRepositoryImpl();

        cultureMediaService = new CultureMediaServiceImpl(videoRepository, ViewsRepository);
    }

    private void createVideos() {
        List<Video> videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));


        for ( Video video : videos ) {
            cultureMediaService.save(video);
        }
    }
    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        createVideos();
        List<Video> videos= cultureMediaService.findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        VideoNotFoundException thrown = assertThrows(
                VideoNotFoundException.class,
                () -> cultureMediaService.findAll()
        );
    }

    @Test
    void when_findByTitle_returns_the_videos_successfully() throws VideoNotFoundException {
        createVideos();
        List<Video> videos = cultureMediaService.findByTitle("Título 3");
        assertTrue(videos.stream().map(Video::code).toList().equals(List.of("03")));
    }

    @Test
    void when_findByTitle_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findByTitle("non_existent_title"));
    }

    @Test
    void when_findByDuration_returns_the_videos_successfully() throws VideoNotFoundException {
        createVideos();
        List<Video> videos = cultureMediaService.findByDuration(1.0, 4.5);
        assertTrue(videos.stream().map(Video::code).toList().equals(List.of("01","03","04")));
    }

    @Test
    void when_findByDuration_throws_the_exception_successfully() {
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.findByDuration(0.0, 0.0));
    }
}
