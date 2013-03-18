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

	public List<Drop> createDrops(List<Drop> drops) throws IOException {
		String json = new String(objectMapper.writeValueAsBytes(drops));
		System.out.println("JSON = " + json);
		HttpResponse response = post(
				"http://localhost:8080/swiftriver-api/v1/drops",
				new ByteArrayContent("application/json", objectMapper
						.writeValueAsBytes(drops)));
		return response.parseAs(drops.getClass());
	}
}
