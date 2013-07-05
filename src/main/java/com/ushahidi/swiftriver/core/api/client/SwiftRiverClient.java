/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/agpl.html>
 * 
 * Copyright (C) Ushahidi Inc. All Rights Reserved.
 */
package com.ushahidi.swiftriver.core.api.client;

import java.io.IOException;
import java.util.List;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.ushahidi.swiftriver.core.api.client.model.Drop;
import com.ushahidi.swiftriver.core.api.client.service.DropsService;

/**
 * @author bmuita
 * 
 */
public class SwiftRiverClient {

	private DropsService dropsService;
	
	private String dropPostUrl;
	
	private HttpTransport httpTransport;
	
	private HttpRequestInitializer httpRequestInitializer;
	
	public SwiftRiverClient(HttpTransport httpTransport,
			HttpRequestInitializer httpRequestInitializer, String dropPostUrl) throws IOException {
		
		setHttpTransport(httpTransport);
		setHttpRequestInitializer(httpRequestInitializer);
		
		// Initialize the service
		this.dropsService = new DropsService(httpTransport, httpRequestInitializer);
		this.dropPostUrl = dropPostUrl;
	}

	
	public String getDropPostUrl() {
		return dropPostUrl;
	}


	public void setDropPostUrl(String dropPostUrl) {
		this.dropPostUrl = dropPostUrl;
	}


	public HttpTransport getHttpTransport() {
		return httpTransport;
	}


	public void setHttpTransport(HttpTransport httpTransport) {
		this.httpTransport = httpTransport;
	}


	public HttpRequestInitializer getHttpRequestInitializer() {
		return httpRequestInitializer;
	}


	public void setHttpRequestInitializer(
			HttpRequestInitializer httpRequestInitializer) {
		this.httpRequestInitializer = httpRequestInitializer;
	}


	/**
	 * 
	 * @param drops
	 * @return
	 */
	public List<Drop> postDrops(List<Drop> drops) {
		try {
			return dropsService.createDrops(this.dropPostUrl, drops);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
