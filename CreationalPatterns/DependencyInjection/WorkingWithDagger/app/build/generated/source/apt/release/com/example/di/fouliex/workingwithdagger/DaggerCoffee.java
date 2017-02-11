// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.example.di.fouliex.workingwithdagger;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerCoffee implements Coffee {
  private Provider<Heater> provideHeaterProvider;

  private Provider<Thermosiphon> thermosiphonProvider;

  private Provider<Pump> providePumpProvider;

  private Provider<CoffeeMaker> coffeeMakerProvider;

  private DaggerCoffee(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Coffee create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideHeaterProvider =
        DoubleCheck.provider(
            DripCoffeeModule_ProvideHeaterFactory.create(builder.dripCoffeeModule));

    this.thermosiphonProvider = Thermosiphon_Factory.create(provideHeaterProvider);

    this.providePumpProvider = (Provider) thermosiphonProvider;

    this.coffeeMakerProvider =
        CoffeeMaker_Factory.create(provideHeaterProvider, providePumpProvider);
  }

  @Override
  public CoffeeMaker maker() {
    return new CoffeeMaker(DoubleCheck.lazy(provideHeaterProvider), providePumpProvider.get());
  }

  public static final class Builder {
    private DripCoffeeModule dripCoffeeModule;

    private Builder() {}

    public Coffee build() {
      if (dripCoffeeModule == null) {
        this.dripCoffeeModule = new DripCoffeeModule();
      }
      return new DaggerCoffee(this);
    }

    public Builder dripCoffeeModule(DripCoffeeModule dripCoffeeModule) {
      this.dripCoffeeModule = Preconditions.checkNotNull(dripCoffeeModule);
      return this;
    }
  }
}