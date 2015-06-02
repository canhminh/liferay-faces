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
package com.liferay.faces.alloy.renderkit.internal;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.liferay.faces.util.lang.StringPool;


/**
 * @author  Neil Griffin
 */
public class FieldRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext facesContext, UIComponent uiComponent) throws IOException {
		super.encodeBegin(facesContext, uiComponent);

		Map<String, Object> attributes = uiComponent.getAttributes();

		ResponseWriter responseWriter = facesContext.getResponseWriter();

		// Outer <span>
		responseWriter.startElement(StringPool.SPAN, uiComponent);

		String id = uiComponent.getClientId(facesContext);
		responseWriter.writeAttribute(StringPool.ID, id, StringPool.ID);

		StringBuilder classNames = new StringBuilder();
		classNames.append("aui-field");

		String type = (String) attributes.get(StringPool.TYPE);

		if (type != null) {
			String lowerCaseType = type.trim().toLowerCase();

			if (lowerCaseType.equals("checkbox") || lowerCaseType.equals("boolean")) {
				classNames.append(" aui-field-choice");
			}
			else if (lowerCaseType.equals("menu") || lowerCaseType.equals("select")) {
				classNames.append(" aui-field-menu");
			}
		}
		else {
			classNames.append(" aui-field-text");
		}

		String cssClass = (String) attributes.get("cssClass");

		if ((cssClass != null) && (cssClass.length() > 0)) {
			classNames.append(StringPool.SPACE);
			classNames.append(cssClass);
		}

		String styleClass = (String) attributes.get("styleClass");

		if ((styleClass != null) && (styleClass.length() > 0)) {
			classNames.append(StringPool.SPACE);
			classNames.append(styleClass);
		}

		responseWriter.writeAttribute(StringPool.CLASS, classNames.toString(), null);

		// Inner <span>
		responseWriter.startElement(StringPool.SPAN, null);
		responseWriter.writeAttribute(StringPool.CLASS, "aui-field-content", null);

		String lowerCaseInlineLabel = "left";
		String inlineLabel = (String) attributes.get("inlineLabel");

		if (inlineLabel != null) {
			lowerCaseInlineLabel = inlineLabel.trim().toLowerCase();
		}

		// Left-aligned <label>
		if (lowerCaseInlineLabel.equals("left")) {
			responseWriter.startElement(StringPool.LABEL, null);
			responseWriter.writeAttribute(StringPool.CLASS, "aui-field-label", null);

			String label = (String) attributes.get(StringPool.LABEL);

			if (label != null) {
				responseWriter.writeText(label, uiComponent, StringPool.LABEL);
			}

			responseWriter.endElement(StringPool.LABEL);
		}

		// Inner-inner <span>
		responseWriter.startElement(StringPool.SPAN, null);
		classNames = new StringBuilder();
		classNames.append("aui-field-element");

		if (lowerCaseInlineLabel.equalsIgnoreCase(StringPool.RIGHT)) {
			classNames.append(" aui-field-label-right");
		}

		responseWriter.writeAttribute(StringPool.CLASS, classNames.toString(), null);

	}

	@Override
	public void encodeEnd(FacesContext facesContext, UIComponent uiComponent) throws IOException {
		super.encodeEnd(facesContext, uiComponent);

		ResponseWriter responseWriter = facesContext.getResponseWriter();

		// Inner-inner </span>
		responseWriter.endElement(StringPool.SPAN);

		String lowerCaseInlineLabel = "";
		Map<String, Object> attributes = uiComponent.getAttributes();
		String inlineLabel = (String) attributes.get("inlineLabel");

		if (inlineLabel != null) {
			lowerCaseInlineLabel = inlineLabel.trim().toLowerCase();
		}

		// Right-aligned <label>
		if (lowerCaseInlineLabel.equals(StringPool.RIGHT)) {
			responseWriter.startElement(StringPool.LABEL, null);
			responseWriter.writeAttribute(StringPool.CLASS, "aui-field-label", null);

			String label = (String) attributes.get(StringPool.LABEL);

			if (label != null) {
				responseWriter.writeText(label, uiComponent, StringPool.LABEL);
			}

			responseWriter.endElement(StringPool.LABEL);
		}

		// Inner </span>
		responseWriter.endElement(StringPool.SPAN);

		// Outer </span>
		responseWriter.endElement(StringPool.SPAN);
	}

}
