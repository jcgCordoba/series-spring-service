package com.example.clientbackseries.resources;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventViewer {
	
	@EventListener
	public void handlerEvent( Object evt ) {
		System.out.println( "Event ----> " + evt );
	}

}
