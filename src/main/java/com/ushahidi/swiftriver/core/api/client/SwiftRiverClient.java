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
package com.ushahidi.swiftriver.core.api.client;

import java.io.IOException;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.ushahidi.swiftriver.core.api.client.service.DropsService;

/**
 * @author bmuita
 * 
 */
public class SwiftRiverClient {

	HttpTransport httpTransport;

	HttpRequestInitializer httpRequestInitializer;

	public SwiftRiverClient(HttpTransport httpTransport,
			HttpRequestInitializer httpRequestInitializer) throws IOException {
		this.httpTransport = httpTransport;
		this.httpRequestInitializer = httpRequestInitializer;
	}

	public DropsService drops() {
		return new DropsService(httpTransport, httpRequestInitializer);
	}
}
