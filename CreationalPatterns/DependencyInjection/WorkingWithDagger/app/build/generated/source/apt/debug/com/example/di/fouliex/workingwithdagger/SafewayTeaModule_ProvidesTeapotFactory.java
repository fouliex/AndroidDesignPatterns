// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.di.fouliex.workingwithdagger;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SafewayTeaModule_ProvidesTeapotFactory implements Factory<Teapot> {
  private final SafewayTeaModule module;

  public SafewayTeaModule_ProvidesTeapotFactory(SafewayTeaModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Teapot get() {
    return Preconditions.checkNotNull(
        module.providesTeapot(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Teapot> create(SafewayTeaModule module) {
    return new SafewayTeaModule_ProvidesTeapotFactory(module);
  }

  /** Proxies {@link SafewayTeaModule#providesTeapot()}. */
  public static Teapot proxyProvidesTeapot(SafewayTeaModule instance) {
    return instance.providesTeapot();
  }
}