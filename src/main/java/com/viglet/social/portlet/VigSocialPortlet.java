/*
 * Copyright (C) 2016-2020 the original author or authors. 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.viglet.social.portlet;

import javax.portlet.ActionResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

/**
 * Social Portlet.
 *
 * @author Alexandre Oliveira
 * @since 0.3.0
 */
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