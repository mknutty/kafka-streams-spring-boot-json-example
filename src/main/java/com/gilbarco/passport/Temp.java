package com.gilbarco.passport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gilbarco.passport.KafkaStreamsConfiguration.Test;

public class Temp {
	public static void main(String[] args) throws JsonProcessingException {
		Test test = new Test();
		test.getWords().add("adsfdsaf");
		System.out.println(new ObjectMapper().writeValueAsString(test));
	}
}
