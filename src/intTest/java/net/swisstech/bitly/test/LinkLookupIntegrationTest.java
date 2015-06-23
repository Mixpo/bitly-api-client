/*
 * Copyright (c) Patrick Huber (gmail: stackmagic)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.swisstech.bitly.test;

import static net.swisstech.bitly.test.util.TestUtil.printAndVerify;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkLookupResponse;

import org.testng.annotations.Test;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/links.html#v3_link_lookup">/v3/link/lookup</a> request.
 * </p>
 * @author Patrick Huber (gmail: stackmagic)
 */
public class LinkLookupIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callLinkLookup() {
		Response<LinkLookupResponse> resp = getClient().linkLookup() //
			.addUrl("https://www.example.com/") //
			.addUrls("https://www.example.com/1", "https://www.example.com/2") //
			.addUrls(Arrays.asList("https://www.example.com/1", "https://www.example.com/2")) //
			.call();

		printAndVerify(resp, LinkLookupResponse.class);

		assertEquals(resp.data.link_lookup.size(), 5);
		int foundCount = 0;
		for (LinkLookupResponse.LinkLookup lu : resp.data.link_lookup) {
			if (lu.aggregate_link != null) {
				foundCount++;
			}
		}
		assertEquals(foundCount, 1);
	}
}
