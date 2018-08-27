package com.scotch.io.KafkaProducerConsumer.ProducerConsumerExamples.CustomSerializationExample;

import java.util.Date;

/*
 * Problem with custom serializer and deserializer when there is any changes in schema, and moreover we cannot read the previous messages 
 * as schema is changed.
 */
public class Supplier {
   private int supplierId;
   private String supplierName;
   private Date supplierStartDate;
   public Supplier(int supplierId, String supplierName, Date supplierStartDate) {
   	this.supplierId = supplierId;
   	this.supplierName = supplierName;
   	this.supplierStartDate = supplierStartDate;
   }
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getSupplierStartDate() {
		return supplierStartDate;
	}
	public void setSupplierStartDate(Date supplierStartDate) {
		this.supplierStartDate = supplierStartDate;
	}
   
}
