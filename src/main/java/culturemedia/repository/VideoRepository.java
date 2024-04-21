package culturemedia.repository;

import culturemedia.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> findAll();
    Video save(Video video);
    List<Video> find(String title);
    List<Video> find(Double fromDuration, Double toDuration);
}
