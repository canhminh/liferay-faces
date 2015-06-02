/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.alloy.component.tabview;

import javax.el.MethodExpression;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;

import com.liferay.faces.alloy.component.tab.TabSelectEvent;


/**
 * @author  Vernon Singleton
 */
public class TabViewBehaviorListener implements AjaxBehaviorListener {

	@Override
	public void processAjaxBehavior(AjaxBehaviorEvent ajaxBehaviorEvent) throws AbortProcessingException {

		TabSelectEvent tabSelectEvent = (TabSelectEvent) ajaxBehaviorEvent;
		TabView tabView = (TabView) tabSelectEvent.getComponent();

		try {
			MethodExpression methodExpression = tabView.getTabSelectListener();

			if (methodExpression != null) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				methodExpression.invoke(facesContext.getELContext(), new Object[] { ajaxBehaviorEvent });
			}
		}
		catch (Exception e) {
			throw new AbortProcessingException(e);
		}
	}
}
