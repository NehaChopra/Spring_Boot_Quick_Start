package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples.CustomSerializationExample;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.util.ObjectUtils;

public class SupplierDeserializer implements Deserializer<Supplier>{
	private String encoding = "UTF8";
	
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Supplier deserialize(String topic, byte[] data) {
		if(!ObjectUtils.isEmpty(data)) {
			 try {
				ByteBuffer buf = ByteBuffer.wrap(data);
				int id = buf.getInt();
				
				int sizeOfName = buf.getInt();
				byte[] nameBytes = new byte[sizeOfName];
				buf.get(nameBytes);
				String deserializedName = new String(nameBytes, encoding);
				int sizeOfDate = buf.getInt();
				byte[] dateBytes = new byte[sizeOfDate];
				buf.get(dateBytes);
	         String dateString = new String(dateBytes,encoding);
            DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
            return new Supplier(id,deserializedName,df.parse(dateString));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
