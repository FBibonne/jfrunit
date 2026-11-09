package org.moditect.jfrunit.customevent;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.moditect.jfrunit.EnableEvent;
import org.moditect.jfrunit.JfrEventTest;
import org.moditect.jfrunit.JfrEvents;
import org.moditect.jfrunit.events.FileRead;

import static org.moditect.jfrunit.JfrEventsAssert.assertThat;

@JfrEventTest
public class CustomEventTest {

    public JfrEvents jfrEvents = new JfrEvents();

    @Test
    @EnableEvent(FileRead.EVENT_NAME)
    public void shouldCompileAndRunWithCodeRelatedToCustomEvent() {
        //assertThat(jfrEvents).contains(HttpRequestEventDefinition.INSTANCE.withMethod("GET"));
        doNotUseIO();
        jfrEvents.awaitEvents();
        jfrEvents.events();
        Assertions.assertThatThrownBy(()->assertThat(jfrEvents).contains(FileRead.INSTANCE)).isInstanceOf(AssertionError.class);
        //assertThat(jfrEvents).contains(event("test.HttpRequestEvent").with("method", "GET"));
    }

    private void doNotUseIO() {
    }

}
