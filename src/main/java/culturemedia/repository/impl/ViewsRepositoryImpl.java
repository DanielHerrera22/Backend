package culturemedia.repository.impl;
import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewsRepositoryImpl implements ViewsRepository{
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
