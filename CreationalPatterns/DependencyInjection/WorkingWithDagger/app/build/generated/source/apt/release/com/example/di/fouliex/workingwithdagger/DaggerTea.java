// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.di.fouliex.workingwithdagger;

import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerTea implements Tea {
  private Provider<Teapot> providesTeapotProvider;

  private DaggerTea(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Tea create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.providesTeapotProvider =
        SafewayTeaModule_ProvidesTeapotFactory.create(builder.safewayTeaModule);
  }

  @Override
  public Teapot getTeapot() {
    return providesTeapotProvider.get();
  }

  public static final class Builder {
    private SafewayTeaModule safewayTeaModule;

    private Builder() {}

    public Tea build() {
      if (safewayTeaModule == null) {
        this.safewayTeaModule = new SafewayTeaModule();
      }
      return new DaggerTea(this);
    }

    public Builder safewayTeaModule(SafewayTeaModule safewayTeaModule) {
      this.safewayTeaModule = Preconditions.checkNotNull(safewayTeaModule);
      return this;
    }
  }
}
