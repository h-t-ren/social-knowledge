package com.huaxinshengyuan.socknow.domain.oxm.mapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class OxMapperImpl implements OxMapper {
	
	private static final Log LOG = LogFactory.getLog(OxMapperImpl.class);
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	  public void writeObjectToXml(Object object, String filename) throws IOException {
		    FileOutputStream fos = null;
		   try {
		        fos = new FileOutputStream(filename);
	          marshaller.marshal(object, new StreamResult(fos));
		        } catch (XmlMappingException e) {
		  	            LOG.error("Xml-Serialization failed due to an XmlMappingException.", e);
		  	        } catch (IOException e) {
		  	            LOG.error("Xml-Serialization failed due to an IOException.", e);
		  	        } finally {
		  	            if (fos != null) {
		  	                fos.close();
		  	            }
		  	        }
		  	    }
		  	 
		  	    public Object readObjectFromXml(String filename) throws IOException {
		  	        FileInputStream fis = null;
		  	        try {
		  	            fis = new FileInputStream(filename);
		  	            return unmarshaller.unmarshal(new StreamSource(fis));
		  	        } catch (IOException e) {
		  	            LOG.error("Xml-Deserialization failed due to an IOException.", e);
		  	        } finally {
		  	            if (fis != null) {
		  	                fis.close();
		  	            }
		  	        }
		  	        return null;
		  	    }
		  	 
		  	    public Marshaller getMarshaller() {
		  	        return marshaller;
		  	    }
		  	 
		  	    public void setMarshaller(Marshaller marshaller) {
		  	        this.marshaller = marshaller;
		  	    }
		  	 
		  	    public Unmarshaller getUnmarshaller() {
		  	        return unmarshaller;
		  	    }
		  	 
		  	    public void setUnmarshaller(Unmarshaller unmarshaller) {
		          this.unmarshaller = unmarshaller;
		  	    }

}
