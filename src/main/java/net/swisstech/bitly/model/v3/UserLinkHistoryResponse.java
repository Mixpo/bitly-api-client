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
package net.swisstech.bitly.model.v3;

import java.util.List;

import net.swisstech.bitly.model.ToStringSupport;

import org.joda.time.DateTime;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/user_info.html#v3_user_link_history">/v3/user/link_history</a> request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class UserLinkHistoryResponse extends ToStringSupport {

	/** the number of returned links in this user's history */
	public long result_count;

	/** the user's link history */
	public List<UserLinkHistory> link_history;

	/** a single item from the user's link history */
	public static class UserLinkHistory extends ToStringSupport {

		/** the bitly link specific to this user and this long_url */
		public String link;

		/** the global bitly identifier for this long_url */
		public String aggregate_link;

		/** the original long URL */
		public String long_url;

		/** a <code>true</code>/<code>false</code> value indicating whether the user has archived this link */
		public boolean archived;

		/** a <code>true</code>/<code>false</code> value indicating whether the user has made this link private */
		@SerializedName("private")
		public boolean privat;

		/** an integer unix epoch indicating when this link was shortened/encoded */
		public DateTime created_at;

		/** user-provided timestamp for when this link was shortened/encoded, used for backfilling data */
		public DateTime user_ts;

		/** an integer unix epoch indicating when this link's metadata was last edited */
		public DateTime modified_at;

		/** the title for this link */
		public String title;

		/**
		 * a list of share actions (for the authenticated user only)
		 * 
		 * TODO what is this exactly?
		 */
		public String shares;
	}
}
