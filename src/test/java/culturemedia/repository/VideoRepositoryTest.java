package culturemedia.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import culturemedia.model.Video;
import culturemedia.repository.impl.VideoRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class VideoRepositoryTest {

    private VideoRepository videoRepository;

    @BeforeEach
    void init(){

        videoRepository = new VideoRepositoryImpl();

        List<Video> videos = List.of(
                new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1));


        for ( Video video : videos ) {
            videoRepository.save( video );
        }

    }

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() {
        List<Video> videos = videoRepository.findAll( );
        assertEquals(6, videos.size());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( "Clic " );
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find( 4.5, 5.5 );
        assertEquals(3, videos.size());
        assertTrue(videos.stream().map(Video::code).toList().containsAll(List.of("01","02","06")));
    }

    @Test
    void when_FindByTitle_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find("Not valid title");
        assertNull(videos);
    }

    @Test
    void when_FindByDuration_does_not_match_any_video_an_empty_list_should_be_returned_successfully() {
        List<Video> videos = videoRepository.find("Not valid duration");
        assertNull(videos);

    }

}