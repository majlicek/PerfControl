package org.perfcake.perfcontrol.impl;

import org.perfcake.perfcontrol.api.PerfControl;
import org.perfcake.scenario.PerfCakeController;

import org.jboss.arquillian.core.api.Injector;
import org.jboss.arquillian.core.api.Instance;
import org.jboss.arquillian.core.api.InstanceProducer;
import org.jboss.arquillian.core.api.annotation.ApplicationScoped;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.test.spi.TestClass;
import org.jboss.arquillian.test.spi.event.suite.BeforeClass;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Statically injects {@link PerfCakeController} into a test class.
 *
 */
public class PerfCakeControllerBuilder {

   @Inject
   private Instance<Injector> injector;

   @Inject
   @ApplicationScoped
   private InstanceProducer<PerfCakeController> perfCakeControllerInstanceProducer;

   /**
    * Injects {@link PerfCakeController} into a test class with specified scenario.
    *
    */
   public void onBeforeClass(@Observes BeforeClass event) throws Exception {

      final TestClass testClass = event.getTestClass();

      final Field[] fields = testClass.getJavaClass().getDeclaredFields();

      for (final Field field : fields) {
         if (field.getAnnotation(PerfControl.class) == null) {
            continue;
         }

         if (field.isAnnotationPresent(PerfControl.class)) {
            PerfControl myAnn = field.getAnnotation(PerfControl.class);
            String scenario = myAnn.scenario();
            if (scenario.equals("")) {
               throw new Exception("You haven't eneterd scenario address." + scenario);
            }
         }

         if (perfCakeControllerInstanceProducer.get() == null) {
            perfCakeControllerInstanceProducer.set(injector.get()
                    .inject(new PerfCakeController(field.getAnnotation(PerfControl.class).scenario())));
         }
         if (!Modifier.isStatic(field.getModifiers()) || field.getType() != PerfCakeController.class) {
            continue;
         }

         AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            field.setAccessible(true);
            return null;
         });

         try {
            field.set(null, perfCakeControllerInstanceProducer.get());
         } catch (Exception ex) {
            throw new RuntimeException(
                    "Could not set static PerfCakeController field for test class" + testClass.getName(), ex);
         }

      }
   }
}