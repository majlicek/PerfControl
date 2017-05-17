package org.perfcake.scenario;

import org.perfcake.PerfCakeConst;
import org.perfcake.PerfCakeException;
import org.perfcake.ScenarioExecution;
import org.perfcake.message.MessageTemplate;
import org.perfcake.message.correlator.Correlator;
import org.perfcake.message.generator.MessageGenerator;
import org.perfcake.message.receiver.Receiver;
import org.perfcake.message.sender.MessageSenderManager;
import org.perfcake.message.sequence.SequenceManager;
import org.perfcake.reporting.ReportManager;
import org.perfcake.validation.ValidationManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Properties;

public class PerfCakeController {

   private static final Logger log = LogManager.getLogger(Scenario.class);

   private String scenario;

   private Scenario scenarioA;

   public PerfCakeController(String scenario) {
      setScenario(scenario);
      load();
   }

   public String getScenario() {
      return scenario;
   }

   private void setScenario(String scenario) {
      this.scenario = scenario;
   }

   public String hello() {
      System.out.println("Funguje mi Hello!!!!!");
      System.out.println("A mam Scenario!!!!" + scenario);
      return "Ahoj";
   }

   private void load() {
      try {
         scenarioA = ScenarioLoader.load(scenario);
      } catch (final Exception e) {
         log.fatal(String.format("Cannot load scenario '%s': ", scenario), e);
         System.exit(PerfCakeConst.ERR_SCENARIO_LOADING);
      }
   }

   public void runWithProp(Properties prop) throws PerfCakeException {
      ScenarioExecution.execute(scenario, prop);
   }

   /**
    * Runs the loaded scenario.
    */
   public void run() {
      boolean err = false;

      try {
         scenarioA.init();
         scenarioA.run();
      } catch (PerfCakeException e) {
         log.fatal("Error running scenario: ", e);
         err = true;
      } finally {
         try {
            scenarioA.close();
         } catch (PerfCakeException e) {
            log.fatal("Scenario did not finish properly: ", e);
            err = true;
         }
      }

      if (err) {
         System.exit(PerfCakeConst.ERR_SCENARIO_EXECUTION);
      }
   }

   public void stop() {
      scenarioA.stop();
   }

   public void close() {
      try {
         scenarioA.close();
      } catch (PerfCakeException e) {
         log.fatal("Error closing scenario: ", e);
      }
   }

   public void reset() {
   }
   /**
    * Gets the scenario generator.
    *
    * @return The generator.
    */
   public MessageGenerator getGenerator() {
      return scenarioA.getGenerator();
   }

   /**
    * Gets the message sender manager.
    *
    * @return The message sender manager.
    */
   public MessageSenderManager getMessageSenderManager() {
      return scenarioA.getMessageSenderManager();
   }

   /**
    * Gets the report manager.
    *
    * @return The report manager.
    */
   public ReportManager getReportManager() {
      return scenarioA.getReportManager();
   }

   /**
    * Gets the validation manager.
    *
    * @return The validation manager.
    */
   public ValidationManager getValidationManager() {
      return scenarioA.getValidationManager();
   }

   /**
    * Gets the {@link SequenceManager}.
    *
    * @return The {@link SequenceManager}.
    */
   public SequenceManager getSequenceManager() {
      return scenarioA.getSequenceManager();
   }

   /**
    * Gets the message store.
    *
    * @return The list of all message templates.
    */
   public List<MessageTemplate> getMessageStore() {
      return scenarioA.getMessageStore();
   }

   /**
    * Gets the {@link Receiver}.
    * @return The {@link Receiver}.
    */
   public Receiver getReceiver() {
      return scenarioA.getReceiver();
   }

   /**
    * Gets the {@link Correlator}.
    * @return The {@link Correlator}.
    */
   public Correlator getCorrelator() {
      return scenarioA.getCorrelator();
   }
}
