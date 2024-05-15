package culturemedia.impl;

import java.util.ArrayList;
import java.util.List;

import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;

public class ViewsRepositoryImpl implements ViewsRepository {

    private final List<View> views;

    public ViewsRepositoryImpl() {
        this.views = new ArrayList<>();
    }

    @Override
    public View save(View view) {
        this.views.add( view );
        return view;
    }
}