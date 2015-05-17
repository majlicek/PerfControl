/*
 * -----------------------------------------------------------------------\
 * PerfCake
 *  
 * Copyright (C) 2010 - 2013 the original author or authors.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -----------------------------------------------------------------------/
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.15 at 12:48:41 AM CEST 
//


package org.perfcake.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.perfcake.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.perfcake.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Scenario }
     * 
     */
    public Scenario createScenario() {
        return new Scenario();
    }

    /**
     * Create an instance of {@link Scenario.Validation }
     * 
     */
    public Scenario.Validation createScenarioValidation() {
        return new Scenario.Validation();
    }

    /**
     * Create an instance of {@link Scenario.Messages }
     * 
     */
    public Scenario.Messages createScenarioMessages() {
        return new Scenario.Messages();
    }

    /**
     * Create an instance of {@link Scenario.Messages.Message }
     * 
     */
    public Scenario.Messages.Message createScenarioMessagesMessage() {
        return new Scenario.Messages.Message();
    }

    /**
     * Create an instance of {@link Scenario.Reporting }
     * 
     */
    public Scenario.Reporting createScenarioReporting() {
        return new Scenario.Reporting();
    }

    /**
     * Create an instance of {@link Scenario.Reporting.Reporter }
     * 
     */
    public Scenario.Reporting.Reporter createScenarioReportingReporter() {
        return new Scenario.Reporting.Reporter();
    }

    /**
     * Create an instance of {@link Scenario.Reporting.Reporter.Destination }
     * 
     */
    public Scenario.Reporting.Reporter.Destination createScenarioReportingReporterDestination() {
        return new Scenario.Reporting.Reporter.Destination();
    }

    /**
     * Create an instance of {@link Scenario.Sequences }
     * 
     */
    public Scenario.Sequences createScenarioSequences() {
        return new Scenario.Sequences();
    }

    /**
     * Create an instance of {@link Scenario.Generator }
     * 
     */
    public Scenario.Generator createScenarioGenerator() {
        return new Scenario.Generator();
    }

    /**
     * Create an instance of {@link Scenario.Properties }
     * 
     */
    public Scenario.Properties createScenarioProperties() {
        return new Scenario.Properties();
    }

    /**
     * Create an instance of {@link Scenario.Sender }
     * 
     */
    public Scenario.Sender createScenarioSender() {
        return new Scenario.Sender();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link Scenario.Validation.Validator }
     * 
     */
    public Scenario.Validation.Validator createScenarioValidationValidator() {
        return new Scenario.Validation.Validator();
    }

    /**
     * Create an instance of {@link Scenario.Messages.Message.ValidatorRef }
     * 
     */
    public Scenario.Messages.Message.ValidatorRef createScenarioMessagesMessageValidatorRef() {
        return new Scenario.Messages.Message.ValidatorRef();
    }

    /**
     * Create an instance of {@link Scenario.Reporting.Reporter.Destination.Period }
     * 
     */
    public Scenario.Reporting.Reporter.Destination.Period createScenarioReportingReporterDestinationPeriod() {
        return new Scenario.Reporting.Reporter.Destination.Period();
    }

    /**
     * Create an instance of {@link Scenario.Sequences.Sequence }
     * 
     */
    public Scenario.Sequences.Sequence createScenarioSequencesSequence() {
        return new Scenario.Sequences.Sequence();
    }

    /**
     * Create an instance of {@link Scenario.Generator.Run }
     * 
     */
    public Scenario.Generator.Run createScenarioGeneratorRun() {
        return new Scenario.Generator.Run();
    }

}