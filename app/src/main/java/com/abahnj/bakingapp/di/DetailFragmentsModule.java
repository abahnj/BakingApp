package com.abahnj.bakingapp.di;

import com.abahnj.bakingapp.ui.SelectStepFragment;
import com.abahnj.bakingapp.ui.ViewStepFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailFragmentsModule {
    @ContributesAndroidInjector
    abstract SelectStepFragment contributeSelectStepFragment();

    @ContributesAndroidInjector
    abstract ViewStepFragment contributeViewStepFragment();
}
