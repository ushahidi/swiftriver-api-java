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
package com.ushahidi.swiftriver.core.api.client.service;

import java.io.IOException;
import java.util.List;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.ushahidi.swiftriver.core.api.client.model.Drop;

/**
 * @author bmuita
 * 
 */
public class DropsService extends AbstractService {

	public DropsService(HttpTransport httpTransport,
			HttpRequestInitializer httpRequestInitializer) {
		super(httpTransport, httpRequestInitializer);
	}

	/**
	 * Sends a POST request to drops/ and returns the list
	 * of the created drops
	 * 
	 * @param postURL
	 * @param drops
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Drop> createDrops(String postURL, List<Drop> drops) throws IOException {
		HttpResponse response = post(postURL,
				new ByteArrayContent("application/json;charset=UTF-8", objectMapper
						.writeValueAsBytes(drops)));

		return response.parseAs(drops.getClass());
	}
}
