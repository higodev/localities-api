package com.higodev.api.localities.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class UtilDate {

	public long getIntervalDateTimeToNow(ChronoUnit datePart, LocalDateTime dateCompare) {
		return datePart.between(dateCompare, LocalDateTime.now());
	}
	
}
