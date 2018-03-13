/**
 * 
 */
package com.souro.kmsencrypt;

import java.nio.ByteBuffer;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptResult;

/**
 * @author sourabrata
 *
 */
public class KmsEncryptDemo {

	public static void main(String[] args) {
		
		AWSKMS client = AWSKMSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		EncryptRequest request = new EncryptRequest().withKeyId("arn:aws:iam::711200063112:user/sourabrta.moukherjee@mheducation.com").withPlaintext(ByteBuffer.wrap("demotextbysouro".getBytes()));
		EncryptResult response = client.encrypt(request);
		System.out.println(response);
	}
}
