package com.viglet.social.portlet;

import javax.portlet.ActionResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

public class VigSocialPortlet {
	static final Logger logger = LogManager.getLogger(VigSocialPortlet.class);
	
	public static final String DEFAULT_VIEW = "view";
	public static final String ALTERNATIVE_VIEW = "alternativeView";
	
    @RenderMapping
public String defaultView() {
    if (logger.isTraceEnabled()) {
    	logger.trace("Default View");
    }
    return DEFAULT_VIEW;
}
@RenderMapping(params = "render=alternative-view")
public String alternativeView() {
    if (logger.isTraceEnabled()) {
    	logger.trace("Alternative view");
    }
    return ALTERNATIVE_VIEW;
}
 
@ActionMapping(params = "action=action-one")
public void actionOne() {
    if (logger.isTraceEnabled()) {
    	logger.trace("Action one");
    }
    // Returns control to default view
}
 
@ActionMapping(params = "action=action-two")
public void actionTwo(ActionResponse actionResponse) {
    if (logger.isTraceEnabled()) {
    	logger.trace("Action two");
    }
 
    // Returns control to alternative view
    actionResponse.setRenderParameter("render", "alternative-view");
}
 
@ResourceMapping(value = "resource-one")
public void resourceOne() {
    if (logger.isTraceEnabled()) {
    	logger.trace("Resource one");
    }
}
}