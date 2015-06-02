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
package com.liferay.faces.bridge.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.liferay.faces.util.config.ConfiguredServletMapping;


/**
 * @author  Neil Griffin
 */
public class BridgeConfigMockImpl implements BridgeConfig {

	public Object getAttribute(String name) {
		throw new UnsupportedOperationException();
	}

	public Map<String, Object> getAttributes() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public List<String> getConfiguredExtensions() {
		return getConfiguredSuffixes();
	}

	public List<ConfiguredServletMapping> getConfiguredFacesServletMappings() {
		throw new UnsupportedOperationException();
	}

	public List<String> getConfiguredSuffixes() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public List<ConfiguredSystemEventListener> getConfiguredSystemEventListeners() {
		throw new UnsupportedOperationException();
	}

	public String getContextParameter(String name) {
		throw new UnsupportedOperationException();
	}

	public Set<String> getExcludedRequestAttributes() {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public List<ServletMapping> getFacesServletMappings() {
		throw new UnsupportedOperationException();
	}

	public Set<String> getIncludedRequestAttributes() {
		throw new UnsupportedOperationException();
	}

	public Map<String, String[]> getPublicParameterMappings() {
		throw new UnsupportedOperationException();
	}

	public String getViewIdRenderParameterName() {
		return "";
	}

	public String getViewIdResourceParameterName() {
		return "";
	}

	public String getWriteBehindRenderResponseWrapper() {
		throw new UnsupportedOperationException();
	}

	public String getWriteBehindResourceResponseWrapper() {
		throw new UnsupportedOperationException();
	}
}
