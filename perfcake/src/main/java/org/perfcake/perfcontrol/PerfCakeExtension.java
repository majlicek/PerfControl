package org.perfcake.perfcontrol;

import org.perfcake.perfcontrol.impl.PerfCakeControllerBuilder;

import org.jboss.arquillian.core.spi.LoadableExtension;



public class PerfCakeExtension implements LoadableExtension {

   @Override
   public void register(ExtensionBuilder builder) {
      builder.observer(PerfCakeControllerBuilder.class);
   }

}