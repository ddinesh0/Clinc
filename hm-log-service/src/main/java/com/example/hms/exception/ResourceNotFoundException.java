package com.example.hms.exception;

public class ResourceNotFoundException extends RuntimeException{
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s :'%s'", resourceName, fieldName, fieldValue));
		System.out.println("Inside ExceptionConstructor");
		resourceName = resourceName;
		fieldName = fieldName;
		fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
		

}
