package Service.impl;

import Service.CultureMediaService;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private VideoRepository videoRepository;
    private ViewsRepository viewRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewRepository) {
        this.videoRepository = videoRepository;
        this.viewRepository = viewRepository;
    }

        @Override
        public Video save(Video video) {
        Video videoSave = videoRepository.save(video);
        return videoSave;
    }

        @Override
        public View save(View view) {
        View viewSave = viewRepository.save(view);
        return viewSave;
    }

        @Override
        public List<Video> findAll() {
        List<Video> videos = videoRepository.findAll();
        return videos;
    }
}
