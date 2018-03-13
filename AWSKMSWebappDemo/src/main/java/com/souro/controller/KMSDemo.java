/**
 * 
 */
package com.souro.controller;

import java.nio.ByteBuffer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptResult;

/**
 * @author sourabrata
 *
 */
@Controller
@RequestMapping("/kms")

public class KMSDemo {
	@RequestMapping(value = "/encrypt", method = RequestMethod.GET)
	public ModelAndView encrypt (HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("kmspage");
		
		AWSKMS client = AWSKMSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		EncryptRequest enRequest = new EncryptRequest()
				.withKeyId("arn:aws:kms:us-east-1:711200063112:key/75ebcd56-cb54-441b-9834-a0197f56cbe8")
				.withPlaintext(ByteBuffer.wrap("demotextbysouro".getBytes()));
		EncryptResult enResponse = client.encrypt(enRequest);
		
		mv.addObject("encrypt", enResponse.toString());
		return mv;
	}
}
