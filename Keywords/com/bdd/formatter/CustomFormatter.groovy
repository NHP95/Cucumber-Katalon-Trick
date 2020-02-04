package com.bdd.formatter

import cucumber.api.event.EmbedEvent
import cucumber.api.event.EventHandler
import cucumber.api.event.EventPublisher
import cucumber.api.event.TestStepFinished
import cucumber.api.event.TestStepStarted
import cucumber.api.formatter.Formatter

public class CustomFormatter implements Formatter {
	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestStepStarted.class, testStepStartedHandler)
		publisher.registerHandlerFor(TestStepFinished.class, testStepFinishedHandler)
		publisher.registerHandlerFor(EmbedEvent.class, embedHandler)
	}

	private EventHandler<TestStepStarted> testStepStartedHandler = new EventHandler<TestStepStarted>() {
		@Override
		public void receive(TestStepStarted event) {
			/*
			 * Containing step info (e.g. name, argument)
			 */
		}
	}

	private EventHandler<TestStepFinished> testStepFinishedHandler = new EventHandler<TestStepFinished>() {
		@Override
		public void receive(TestStepFinished event) {
			/*
			 * Containing step info (e.g. name, argument) and step result
			 */
		}
	}

	private EventHandler<EmbedEvent> embedHandler = new EventHandler<EmbedEvent>() {
		@Override
		public void receive(EmbedEvent event) {
			/*
			 * Trigger when scenario.embed method is called (taking screenshot). It contains a byte array and its mime-type.
			 */
		}
	}
}
