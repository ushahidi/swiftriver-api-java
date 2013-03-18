/**
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ushahidi.swiftriver.core.api.client.service;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson.JacksonFactory;

/**
 * @author bmuita
 * 
 */
public abstract class AbstractService {

	HttpTransport httpTransport;

	protected static final JsonFactory jsonFactory = new JacksonFactory();
	
	protected static final ObjectMapper objectMapper = new ObjectMapper();

	HttpRequestInitializer httpRequestInitializer;

	public AbstractService(HttpTransport httpTransport,
			HttpRequestInitializer httpRequestInitializer) {
		this.httpTransport = httpTransport;
		this.httpRequestInitializer = httpRequestInitializer;
	}

	protected HttpResponse post(String url, HttpContent content)
			throws IOException {
		return this.httpTransport.createRequestFactory(httpRequestInitializer)
				.buildPostRequest(new GenericUrl(url), content)
				.setParser(new JsonObjectParser(jsonFactory)).execute();
	}
}
